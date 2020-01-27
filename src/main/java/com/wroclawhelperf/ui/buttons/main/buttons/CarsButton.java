package com.wroclawhelperf.ui.buttons.main.buttons;

import com.wroclawhelperf.ui.buttons.MainButtonLayout;
import com.wroclawhelperf.ui.views.Dashboard;

public final class CarsButton extends MainButtonLayout {

    private final Dashboard dashboard;
    private static CarsButton carsButtonInstance = null;

    public static CarsButton getInstance(Dashboard dashboard) {
        if (carsButtonInstance == null) {
            carsButtonInstance = new CarsButton(dashboard);
        }
        return carsButtonInstance;
    }

    private CarsButton(Dashboard dashboard) {
        super();
        this.dashboard = dashboard;
        setText("CARS");

        addClickListener(e -> dashboard.removeAll());
    }
}
