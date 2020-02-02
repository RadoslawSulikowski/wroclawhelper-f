package com.wroclawhelperf.ui.buttons.main.buttons;

import com.wroclawhelperf.ui.buttons.abstrct.templates.MainButtonAbstract;
import com.wroclawhelperf.ui.views.Dashboard;
import com.wroclawhelperf.ui.views.UserPanelView;

public final class UserPanelButton extends MainButtonAbstract {

    private final Dashboard dashboard;

    public UserPanelButton(Dashboard d) {
        super();
        dashboard = d;
        setText("USER PANEL");

        addClickListener(e -> {
            dashboard.reset();
            dashboard.getHeading().setText("USER PANEL");
            dashboard.getContainer().add(new UserPanelView(dashboard));
        });
    }
}