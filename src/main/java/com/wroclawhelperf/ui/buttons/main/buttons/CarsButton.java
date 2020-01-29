package com.wroclawhelperf.ui.buttons.main.buttons;

import com.wroclawhelperf.ui.buttons.abstrct.templates.MainButtonAbstract;
import com.wroclawhelperf.ui.views.Dashboard;

public final class CarsButton extends MainButtonAbstract {

    private final Dashboard dashboard;

    public CarsButton(Dashboard dashboard) {
        super();
        this.dashboard = dashboard;
        setText("CARS");

        addClickListener(e -> {
            this.dashboard.reset();
            this.dashboard.getHeading().setText("CARS");
        });
    }
}
