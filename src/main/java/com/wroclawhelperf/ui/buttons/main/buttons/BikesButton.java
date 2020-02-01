package com.wroclawhelperf.ui.buttons.main.buttons;

import com.vaadin.flow.component.button.Button;
import com.wroclawhelperf.ui.buttons.abstrct.templates.MainButtonAbstract;
import com.wroclawhelperf.ui.buttons.secondary.buttons.bikes.FindNearestBikeStationButton;
import com.wroclawhelperf.ui.buttons.secondary.buttons.bikes.AllBikeStationsButton;
import com.wroclawhelperf.ui.views.StationsView;
import com.wroclawhelperf.ui.views.Dashboard;

public final class BikesButton extends MainButtonAbstract {

    private final Dashboard dashboard;

    public BikesButton(Dashboard d) {
        super();
        dashboard = d;
        setText("BIKES");
        StationsView stationsView = new StationsView(dashboard);
        Button getAllBikeStationsButton = new AllBikeStationsButton(stationsView);
        Button findNearestStationButton = new FindNearestBikeStationButton(stationsView);
        addClickListener(e -> {
            dashboard.reset();
            dashboard.getHeading().setText("BIKE STATION PANEL");
            dashboard.getSecondaryButtonPanel().add(getAllBikeStationsButton, findNearestStationButton);
            dashboard.getContainer().add(stationsView);
        });
    }
}
