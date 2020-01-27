package com.wroclawhelperf.ui.buttons.main.buttons;

import com.wroclawhelperf.ui.buttons.MainButtonLayout;
import com.wroclawhelperf.ui.views.Dashboard;

public final class GoodbyeButton extends MainButtonLayout {

    private final Dashboard dashboard;
    private static GoodbyeButton goodbyeButtonInstance = null;

    public static GoodbyeButton getInstance(Dashboard dashboard) {
        if (goodbyeButtonInstance == null) {
            goodbyeButtonInstance = new GoodbyeButton(dashboard);
        }
        return goodbyeButtonInstance;
    }

    public GoodbyeButton(Dashboard dashboard) {
        super();
        this.dashboard = dashboard;
        setText("GOODBYE!");

        addClickListener(e -> dashboard.getMainView().reset());
    }
}
