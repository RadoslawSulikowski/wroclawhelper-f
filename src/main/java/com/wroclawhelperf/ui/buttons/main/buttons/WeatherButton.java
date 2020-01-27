package com.wroclawhelperf.ui.buttons.main.buttons;

import com.wroclawhelperf.ui.buttons.MainButtonAbstract;
import com.wroclawhelperf.ui.views.Dashboard;

public final class WeatherButton extends MainButtonAbstract {

    private static WeatherButton weatherButtonInstance = null;
    private final Dashboard dashboard = Dashboard.getInstance();

    public static WeatherButton getInstance() {
        if (weatherButtonInstance == null) {
            weatherButtonInstance = new WeatherButton();
        }
        return weatherButtonInstance;
    }

    private WeatherButton() {
        super();
        setText("WEATHER");
        addClickListener(e -> {
            dashboard.reset();
            dashboard.getHeading().setText("WEATHER");
        });
    }
}
