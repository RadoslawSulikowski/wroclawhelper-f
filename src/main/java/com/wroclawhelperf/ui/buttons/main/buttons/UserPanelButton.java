package com.wroclawhelperf.ui.buttons.main.buttons;

import com.wroclawhelperf.ui.buttons.MainButtonLayout;
import com.wroclawhelperf.ui.views.Dashboard;

public final class UserPanelButton extends MainButtonLayout {

    private final Dashboard dashboard;
    private static UserPanelButton userPanelButtonInstance = null;

    public static UserPanelButton getInstance(Dashboard dashboard) {
        if (userPanelButtonInstance == null) {
            userPanelButtonInstance = new UserPanelButton(dashboard);
        }
        return userPanelButtonInstance;
    }

    private UserPanelButton(Dashboard dashboard) {
        super();
        this.dashboard = dashboard;
        setText("USER PANEL");
    }
}