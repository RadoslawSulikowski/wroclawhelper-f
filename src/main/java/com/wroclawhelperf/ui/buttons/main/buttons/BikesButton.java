package com.wroclawhelperf.ui.buttons.main.buttons;

import com.vaadin.flow.component.button.Button;
import com.wroclawhelperf.ui.buttons.MainButtonAbstract;
import com.wroclawhelperf.ui.buttons.bikes.buttons.FindNearestBikeStationButton;
import com.wroclawhelperf.ui.buttons.bikes.buttons.AllBikeStationsButton;
import com.wroclawhelperf.ui.views.StationsView;
import com.wroclawhelperf.ui.views.Dashboard;

public final class BikesButton extends MainButtonAbstract {

    private final Dashboard dashboard;

    public BikesButton(Dashboard dashboard) {
        super();
        this.dashboard = dashboard;
        setText("BIKES");
        StationsView stationsView = new StationsView(this.dashboard);
        Button getAllBikeStationsButton = new AllBikeStationsButton(stationsView);
        Button findNearestStationButton = new FindNearestBikeStationButton(stationsView);
        addClickListener(e -> {
            this.dashboard.reset();
            this.dashboard.getHeading().setText("BIKE STATION PANEL");
            this.dashboard.getSecondaryButtonPanel().add(getAllBikeStationsButton, findNearestStationButton);
            this.dashboard.getContainer().add(stationsView);
        });
    }
}
