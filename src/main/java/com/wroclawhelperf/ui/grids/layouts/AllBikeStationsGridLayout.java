package com.wroclawhelperf.ui.grids.layouts;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.wroclawhelperf.domain.BikeStation;
import com.wroclawhelperf.service.BikeService;

public class AllBikeStationsGridLayout extends VerticalLayout {

    private final BikeService service = BikeService.getInstance();

    public AllBikeStationsGridLayout() {

        Label stationName = new Label();

        Grid<BikeStation> bikeGrid = new Grid<>(BikeStation.class);
        bikeGrid.setColumns("uniqueId", "number", "bikeList", "location.latitude", "location.longitude");
        bikeGrid.getColumns().forEach(c -> c.setAutoWidth(true));

        Grid<BikeStation> bikeStationGrid = new Grid<>(BikeStation.class);
        bikeStationGrid.setColumns("name", "bikes", "bookedBikes");
        bikeStationGrid.getColumns().forEach(c -> c.setAutoWidth(true));
        bikeStationGrid.setItems(service.getAllBikeStations());
        bikeStationGrid.addComponentColumn(bikeStation -> {
            Button button = new Button("DETAILS");
            button.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
            button.addClickListener(click -> {
                stationName.setText(bikeStation.getName());
                bikeGrid.setItems(bikeStation);
            });
            return button;
        });

        add(bikeStationGrid, stationName, bikeGrid);
    }
}
