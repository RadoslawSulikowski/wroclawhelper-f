package com.wroclawhelperf.ui.buttons.main.buttons;

import com.wroclawhelperf.ui.buttons.MainButtonAbstract;
import com.wroclawhelperf.ui.views.Dashboard;

public final class UserPanelButton extends MainButtonAbstract {

    private final Dashboard dashboard;

    public UserPanelButton(Dashboard dashboard) {
        super();
        this.dashboard = dashboard;
        setText("USER PANEL");

        addClickListener(e -> {
            this.dashboard.reset();
            this.dashboard.getHeading().setText("USER PANEL");
        });
    }
}