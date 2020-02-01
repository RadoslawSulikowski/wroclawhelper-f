package com.wroclawhelperf.ui.buttons.main.buttons;

import com.wroclawhelperf.ui.buttons.abstrct.templates.MainButtonAbstract;
import com.wroclawhelperf.ui.views.Dashboard;

public final class LogOutButton extends MainButtonAbstract {

    private final Dashboard dashboard;

    public LogOutButton(Dashboard dashboard) {
        super();
        this.dashboard = dashboard;
        setText("LOG OUT!");

        addClickListener(e -> {
            this.dashboard.removeAll();
            dashboard.getMainView().setLoggedUser("");
            dashboard.reset();
            dashboard.getMainView().reset();
        });
    }
}
