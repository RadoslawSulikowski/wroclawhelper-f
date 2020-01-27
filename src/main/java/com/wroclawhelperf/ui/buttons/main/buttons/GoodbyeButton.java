package com.wroclawhelperf.ui.buttons.main.buttons;

import com.wroclawhelperf.ui.buttons.MainButtonAbstract;
import com.wroclawhelperf.ui.views.Dashboard;

public final class GoodbyeButton extends MainButtonAbstract {

    private final Dashboard dashboard;

    public GoodbyeButton(Dashboard dashboard) {
        super();
        this.dashboard = dashboard;
        setText("GOODBYE!");

        addClickListener(e -> {
            this.dashboard.removeAll();
            dashboard.reset();
            dashboard.getMainView().reset();
        });
    }
}
