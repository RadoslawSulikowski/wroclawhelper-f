package com.wroclawhelperf.ui.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class BikeStationsView extends VerticalLayout {

    private static BikeStationsView bikeStationsViewInstance = null;


    public static BikeStationsView getInstance() {
        if (bikeStationsViewInstance == null) {
            bikeStationsViewInstance = new BikeStationsView();
        }
        return bikeStationsViewInstance;
    }

    private BikeStationsView() {
        setContent();

    }

    private void setContent() {

    }

    public void reset() {
        removeAll();
        setContent();
    }

}
