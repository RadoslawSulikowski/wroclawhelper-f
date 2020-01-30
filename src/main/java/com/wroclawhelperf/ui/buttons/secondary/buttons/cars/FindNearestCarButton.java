package com.wroclawhelperf.ui.buttons.secondary.buttons.cars;

import com.vaadin.flow.component.html.Span;
import com.wroclawhelperf.ui.buttons.abstrct.templates.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.forms.LocationForCarForm;
import com.wroclawhelperf.ui.views.StationsView;

public class FindNearestCarButton extends SecondaryButtonAbstract {

    private final StationsView carView;

    public FindNearestCarButton(StationsView stationsView) {
        super();
        carView = stationsView;
        setText("FIND NEAREST");

        addClickListener(e -> {
            carView.reset();
            carView.add(new Span("Typ location and find the nearest available car" +
                    " from this location"));
            carView.add(new LocationForCarForm(stationsView));
        });
    }
}
