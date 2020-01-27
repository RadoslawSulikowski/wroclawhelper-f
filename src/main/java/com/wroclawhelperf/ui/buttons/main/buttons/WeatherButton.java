package com.wroclawhelperf.ui.buttons.main.buttons;

import com.wroclawhelperf.ui.buttons.MainButtonLayout;
import com.wroclawhelperf.ui.views.Dashboard;

public final class WeatherButton extends MainButtonLayout {

    private static WeatherButton weatherButtonInstance = null;
    private final Dashboard dashboard;

    public static WeatherButton getInstance(Dashboard dashboard) {
        if (weatherButtonInstance == null) {
            weatherButtonInstance = new WeatherButton(dashboard);
        }
        return weatherButtonInstance;
    }

    private WeatherButton(Dashboard dashboard) {
        super();
        this.dashboard = dashboard;
        setText("WEATHER");
    }
}
