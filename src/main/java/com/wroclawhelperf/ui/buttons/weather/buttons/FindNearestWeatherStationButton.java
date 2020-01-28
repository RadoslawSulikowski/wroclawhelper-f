package com.wroclawhelperf.ui.buttons.weather.buttons;

import com.vaadin.flow.component.html.Span;
import com.wroclawhelperf.ui.buttons.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.forms.LocationForWeatherForm;
import com.wroclawhelperf.ui.views.StationsView;

public class FindNearestWeatherStationButton extends SecondaryButtonAbstract {

    private final StationsView weatherView;

    public FindNearestWeatherStationButton(StationsView weatherView) {
        super();
        this.weatherView = weatherView;
        setText("FIND NEAREST");

        addClickListener(e -> {
            this.weatherView.reset();
            this.weatherView.add(new Span("Typ location and find the nearest weather station" +
                    " from this location and check weather"));
            this.weatherView.add(new LocationForWeatherForm(weatherView));
        });
    }
}
