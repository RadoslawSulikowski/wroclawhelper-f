package com.wroclawhelperf.ui.buttons.secondary.buttons.weather;

import com.vaadin.flow.component.html.Span;
import com.wroclawhelperf.ui.buttons.abstrct.templates.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.forms.LocationForWeatherForm;
import com.wroclawhelperf.ui.views.StationsView;

public class FindNearestWeatherStationButton extends SecondaryButtonAbstract {

    private final StationsView weatherView;

    public FindNearestWeatherStationButton(StationsView stationsView) {
        super();
        weatherView = stationsView;
        setText("FIND NEAREST");

        addClickListener(e -> {
            weatherView.reset();
            weatherView.add(new Span("Typ location and find the nearest weather station" +
                    " from this location and check weather"));
            weatherView.add(new LocationForWeatherForm(weatherView));
        });
    }
}
