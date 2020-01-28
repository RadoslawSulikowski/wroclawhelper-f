package com.wroclawhelperf.ui.buttons.bikes.buttons;

import com.vaadin.flow.component.html.Span;
import com.wroclawhelperf.ui.buttons.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.forms.LocationForBikeStationForm;
import com.wroclawhelperf.ui.views.StationsView;


public class FindNearestBikeStationButton extends SecondaryButtonAbstract {

    private final StationsView stationsView;

    public FindNearestBikeStationButton(StationsView stationsView) {
        super();
        this.stationsView = stationsView;
        setText("FIND NEAREST");

        addClickListener(e -> {
            this.stationsView.reset();
            this.stationsView.add(new Span("Typ location and find the nearest bike station" +
                    " from this location with available bikes "));
            this.stationsView.add(new LocationForBikeStationForm(stationsView));
        });
    }
}
