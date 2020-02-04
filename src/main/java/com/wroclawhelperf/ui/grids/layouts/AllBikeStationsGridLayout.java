package com.wroclawhelperf.ui.grids.layouts;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.wroclawhelperf.domain.BikeStation;
import com.wroclawhelperf.service.BikeService;

import java.util.List;
import java.util.stream.Collectors;

public class AllBikeStationsGridLayout extends VerticalLayout {

    private List<BikeStation> bikeStationList = BikeService.getInstance().getAllBikeStations();
    private TextField filter = new TextField();
    private Grid<BikeStation> bikeStationGrid = new Grid<>(BikeStation.class);
    private Label stationName = new Label();
    private Grid<BikeStation> bikeGrid = new Grid<>(BikeStation.class);

    public AllBikeStationsGridLayout() {

        filter.setPlaceholder("Filter by name...");
        filter.setClearButtonVisible(true);
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> update());

        bikeStationGrid.setColumns("name", "bikes", "bookedBikes");
        bikeStationGrid.getColumns().forEach(c -> c.setAutoWidth(true));
        bikeStationGrid.setItems(bikeStationList);
        bikeStationGrid.addComponentColumn(bikeStation -> {
            Button button = new Button("DETAILS");
            button.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
            button.addClickListener(click -> {
                stationName.setText(bikeStation.getName());
                bikeGrid.setItems(bikeStation);
            });
            return button;
        });

        bikeGrid.setColumns("uniqueId", "number", "bikeList", "location.latitude", "location.longitude");
        bikeGrid.getColumns().forEach(c -> c.setAutoWidth(true));

        add(filter, bikeStationGrid, stationName, bikeGrid);
    }

    private void update() {
        bikeStationGrid.setItems(bikeStationList.stream()
                .filter(b -> b.getName().toUpperCase().contains(filter.getValue().toUpperCase()))
                .collect(Collectors.toList()));
    }
}
