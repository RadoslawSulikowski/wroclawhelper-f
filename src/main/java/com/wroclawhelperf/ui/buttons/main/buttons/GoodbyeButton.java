package com.wroclawhelperf.ui.buttons.main.buttons;

import com.wroclawhelperf.ui.MainView;
import com.wroclawhelperf.ui.buttons.MainButtonAbstract;
import com.wroclawhelperf.ui.views.Dashboard;

public final class GoodbyeButton extends MainButtonAbstract {

    private final MainView mainView;
    private static GoodbyeButton goodbyeButtonInstance = null;

    public static GoodbyeButton getInstance(MainView mainView) {
        if (goodbyeButtonInstance == null) {
            goodbyeButtonInstance = new GoodbyeButton(mainView);
        }
        return goodbyeButtonInstance;
    }

    private GoodbyeButton(MainView mainView) {
        super(mainView);
        this.mainView = mainView;
        setText("GOODBYE!");

        addClickListener(e -> {
            this.mainView.reset();
            Dashboard.getInstance().reset();
        });
    }
}
