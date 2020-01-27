package com.wroclawhelperf.ui.buttons.bikes.buttons;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.wroclawhelperf.domain.BikeStation;
import com.wroclawhelperf.service.BikeService;
import com.wroclawhelperf.ui.buttons.SecondLevelButtonLayout;
import com.wroclawhelperf.ui.views.BikeStationsView;

public class GetAllBikeStationsButton extends SecondLevelButtonLayout {

    private final BikeService service = BikeService.getInstance();
    private final BikeStationsView bikeStationsView = BikeStationsView.getInstance();
    private static GetAllBikeStationsButton getAllBikeStationsButtonInstance = null;

    public static GetAllBikeStationsButton getInstance() {
        if (getAllBikeStationsButtonInstance == null) {
            getAllBikeStationsButtonInstance = new GetAllBikeStationsButton();
        }
        return getAllBikeStationsButtonInstance;
    }

    private GetAllBikeStationsButton() {
        super();
        setText("ALL STATIONS");
        addClickListener(e -> {
            bikeStationsView.removeAll();
            Grid<BikeStation> bikeGrid = new Grid<>(BikeStation.class);
            bikeGrid.setColumns("name", "bikes", "bookedBikes");
            bikeGrid.setItems(service.getAllBikeStations());
            bikeGrid.addComponentColumn(bikeStation -> {
                Button button = new Button("DETAILS");
                button.addClickListener(click ->
                        Notification.show("Clicked: " + bikeStation.toString()));
                return button;
            });
            bikeStationsView.add(bikeGrid);
        });
    }

}
