package com.wroclawhelperf.ui.buttons.main.buttons;

import com.wroclawhelperf.ui.buttons.MainButtonAbstract;
import com.wroclawhelperf.ui.views.Dashboard;

public final class CarsButton extends MainButtonAbstract {

    private final Dashboard dashboard = Dashboard.getInstance();
    private static CarsButton carsButtonInstance = null;

    public static CarsButton getInstance() {
        if (carsButtonInstance == null) {
            carsButtonInstance = new CarsButton();
        }
        return carsButtonInstance;
    }

    private CarsButton() {
        super();
        setText("CARS");

        addClickListener(e -> {
            dashboard.reset();
            dashboard.getHeading().setText("CARS");
        });
    }
}
