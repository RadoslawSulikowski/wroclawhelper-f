package com.wroclawhelperf.ui.buttons.secondary.buttons.weather;

import com.wroclawhelperf.ui.buttons.abstrct.templates.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.grids.layouts.AllWeatherStationGridLayout;
import com.wroclawhelperf.ui.views.StationsView;

public class AllWeatherStationsButton extends SecondaryButtonAbstract {

    private final StationsView weatherView;

    public AllWeatherStationsButton(StationsView stationsView) {
        super();
        weatherView = stationsView;
        setText("All STATIONS");

        addClickListener(e -> {
            weatherView.reset();
            weatherView.add(new AllWeatherStationGridLayout());
        });

    }

}
