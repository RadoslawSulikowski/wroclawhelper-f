package com.wroclawhelperf.ui.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class BikeStationsView extends VerticalLayout {

    private final Dashboard dashboard;
    private static BikeStationsView bikeStationsViewInstance = null;

    public static BikeStationsView getInstance(Dashboard dashboard) {
        if (bikeStationsViewInstance == null) {
            bikeStationsViewInstance = new BikeStationsView(dashboard);
        }
        return bikeStationsViewInstance;
    }

    private BikeStationsView(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

}
