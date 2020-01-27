package com.wroclawhelperf.ui.buttons.main.buttons;

import com.vaadin.flow.component.button.Button;
import com.wroclawhelperf.ui.buttons.MainButtonAbstract;
import com.wroclawhelperf.ui.buttons.bikes.buttons.FindNearestStationButton;
import com.wroclawhelperf.ui.buttons.bikes.buttons.GetAllBikeStationsButton;
import com.wroclawhelperf.ui.views.BikeStationsView;
import com.wroclawhelperf.ui.views.Dashboard;

public final class BikesButton extends MainButtonAbstract {

    private final Dashboard dashboard;
//    private BikeStationsView bikeStationsView = new BikeStationsView();
//    private Button getAllBikeStationsButton = new GetAllBikeStationsButton(bikeStationsView);
//    private Button findNearestStationButton = new FindNearestStationButton(bikeStationsView);

    public BikesButton(Dashboard dashboard) {
        super();
        this.dashboard = dashboard;
        setText("BIKES");
        BikeStationsView bikeStationsView = new BikeStationsView(this.dashboard);
        Button getAllBikeStationsButton = new GetAllBikeStationsButton(bikeStationsView);
        Button findNearestStationButton = new FindNearestStationButton(bikeStationsView);
        addClickListener(e -> {
            this.dashboard.reset();
            this.dashboard.getHeading().setText("BIKE STATION PANEL");
            this.dashboard.getSecondaryButtonPanel().add(getAllBikeStationsButton, findNearestStationButton);
            this.dashboard.getContainer().add(bikeStationsView);
        });
    }
}
