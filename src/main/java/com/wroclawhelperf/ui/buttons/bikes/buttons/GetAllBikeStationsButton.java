package com.wroclawhelperf.ui.buttons.bikes.buttons;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.wroclawhelperf.domain.BikeStation;
import com.wroclawhelperf.service.BikeService;
import com.wroclawhelperf.ui.buttons.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.views.BikeStationsView;

public class GetAllBikeStationsButton extends SecondaryButtonAbstract {

    private final BikeService service = BikeService.getInstance();
    private final BikeStationsView bikeStationsView;

    public GetAllBikeStationsButton(BikeStationsView bikeStationsView) {
        super();
        this.bikeStationsView = bikeStationsView;
        setText("ALL STATIONS");
        addClickListener(e -> {
            this.bikeStationsView.removeAll();

            Grid<BikeStation> bikeGrid = new Grid<>(BikeStation.class);
            Label stationName = new Label();
            Grid<BikeStation> bikeStationGrid = new Grid<>(BikeStation.class);

            bikeStationGrid.setColumns("name", "bikes", "bookedBikes");
            bikeGrid.setColumns("uniqueId", "number", "bikeList", "location");
            bikeGrid.getColumns().forEach(c -> c.setAutoWidth(true));
            bikeStationGrid.setItems(service.getAllBikeStations());
            bikeStationGrid.addComponentColumn(bikeStation -> {
                Button button = new Button("DETAILS");
                button.addClickListener(click -> {
                    stationName.setText(bikeStation.getName());
                    bikeGrid.setItems(bikeStation);
                });
                return button;
            });
            bikeStationsView.add(bikeStationGrid, stationName, bikeGrid);
        });
    }

}
