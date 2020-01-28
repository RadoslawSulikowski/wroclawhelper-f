package com.wroclawhelperf.ui.buttons.bikes.buttons;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.wroclawhelperf.domain.BikeStation;
import com.wroclawhelperf.service.BikeService;
import com.wroclawhelperf.ui.buttons.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.views.StationsView;

public class AllBikeStationsButton extends SecondaryButtonAbstract {

    private final BikeService service = BikeService.getInstance();
    private final StationsView stationsView;

    public AllBikeStationsButton(StationsView stationsView) {
        super();
        this.stationsView = stationsView;
        setText("ALL STATIONS");

        Label stationName = new Label();

        Grid<BikeStation> bikeGrid = new Grid<>(BikeStation.class);
        bikeGrid.setColumns("uniqueId", "number", "bikeList", "location");
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

        addClickListener(e -> {
            this.stationsView.removeAll();
            this.stationsView.add(bikeStationGrid, stationName, bikeGrid);
        });
    }

}
