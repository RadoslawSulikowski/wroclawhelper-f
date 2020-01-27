package com.wroclawhelperf.ui.buttons.main.buttons;

import com.wroclawhelperf.ui.buttons.MainButtonAbstract;
import com.wroclawhelperf.ui.views.Dashboard;

public final class WeatherButton extends MainButtonAbstract {

    private final Dashboard dashboard;

    public WeatherButton(Dashboard dashboard) {
        super();
        this.dashboard = dashboard;
        setText("WEATHER");
        addClickListener(e -> {
            this.dashboard.reset();
            this.dashboard.getHeading().setText("WEATHER");
        });
    }
}
