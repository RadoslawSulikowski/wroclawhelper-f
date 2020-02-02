package com.wroclawhelperf.ui.buttons.main.buttons;

import com.vaadin.flow.component.button.Button;
import com.wroclawhelperf.ui.buttons.abstrct.templates.MainButtonAbstract;
import com.wroclawhelperf.ui.buttons.secondary.buttons.weather.AllWeatherStationsButton;
import com.wroclawhelperf.ui.buttons.secondary.buttons.weather.FindNearestWeatherStationButton;
import com.wroclawhelperf.ui.buttons.secondary.buttons.weather.WeatherAtAllStationsButton;
import com.wroclawhelperf.ui.views.Dashboard;
import com.wroclawhelperf.ui.views.StationsView;

public final class WeatherButton extends MainButtonAbstract {

    private final Dashboard dashboard;

    public WeatherButton(Dashboard d) {
        super();
        dashboard = d;
        setText("WEATHER");
        StationsView weatherView = new StationsView(dashboard);
        Button allWeatherStationsButton = new AllWeatherStationsButton(weatherView);
        Button allStationWeatherButton = new WeatherAtAllStationsButton(weatherView);
        Button findNearestWeatherStationButton = new FindNearestWeatherStationButton(weatherView);

        addClickListener(e -> {
            dashboard.reset();
            dashboard.getHeading().setText("WEATHER");
            dashboard.getSecondaryButtonPanel()
                    .add(allWeatherStationsButton, allStationWeatherButton, findNearestWeatherStationButton);
            dashboard.getContainer().add(weatherView);
        });
    }
}
