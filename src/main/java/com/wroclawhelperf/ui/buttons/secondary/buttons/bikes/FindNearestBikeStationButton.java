package com.wroclawhelperf.ui.buttons.secondary.buttons.bikes;

import com.vaadin.flow.component.html.Span;
import com.wroclawhelperf.ui.buttons.abstrct.templates.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.forms.LocationForBikeStationForm;
import com.wroclawhelperf.ui.views.StationsView;


public class FindNearestBikeStationButton extends SecondaryButtonAbstract {

    private final StationsView bikeStationsView;

    public FindNearestBikeStationButton(StationsView stationsView) {
        super();
        bikeStationsView = stationsView;
        setText("FIND NEAREST");

        addClickListener(e -> {
            bikeStationsView.reset();
            bikeStationsView.add(new Span("Typ location and find the nearest bike station" +
                    " from this location with available bikes "));
            bikeStationsView.add(new LocationForBikeStationForm(stationsView));
        });
    }
}
