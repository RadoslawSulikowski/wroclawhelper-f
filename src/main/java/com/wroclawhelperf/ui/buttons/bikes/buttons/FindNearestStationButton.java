package com.wroclawhelperf.ui.buttons.bikes.buttons;

import com.wroclawhelperf.ui.forms.*;
import com.vaadin.flow.component.html.Span;
import com.wroclawhelperf.ui.buttons.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.views.BikeStationsView;


public class FindNearestStationButton extends SecondaryButtonAbstract {

    private final BikeStationsView bikeStationsView;

    public FindNearestStationButton(BikeStationsView bikeStationsView) {
        super();
        this.bikeStationsView = bikeStationsView;
        setText("FIND NEAREST");



        addClickListener(e -> {
            this.bikeStationsView.reset();
            this.bikeStationsView.add(new Span("Typ location and find the nearest bike station" +
                    " from this location with available bikes "));
            this.bikeStationsView.add(new LocationForm(bikeStationsView));
        });
    }
}
