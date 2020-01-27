package com.wroclawhelperf.ui.buttons.main.buttons;

import com.wroclawhelperf.ui.buttons.MainButtonAbstract;
import com.wroclawhelperf.ui.views.Dashboard;

public final class UserPanelButton extends MainButtonAbstract {

    private final Dashboard dashboard = Dashboard.getInstance();
    private static UserPanelButton userPanelButtonInstance = null;

    public static UserPanelButton getInstance() {
        if (userPanelButtonInstance == null) {
            userPanelButtonInstance = new UserPanelButton();
        }
        return userPanelButtonInstance;
    }

    private UserPanelButton() {
        super();
        setText("USER PANEL");

        addClickListener(e -> {
            dashboard.reset();
            dashboard.getHeading().setText("USER PANEL");
        });
    }
}