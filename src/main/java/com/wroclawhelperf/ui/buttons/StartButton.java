package com.wroclawhelperf.ui.buttons;

import com.vaadin.flow.component.button.Button;
import com.wroclawhelperf.ui.MainView;
import com.wroclawhelperf.ui.views.Dashboard;

public class StartButton extends Button {

    private MainView mainView;

    public StartButton(MainView mainView) {
        this.mainView = mainView;
        Dashboard dashboard = new Dashboard(mainView);
        setText("LET'S GET STARTED!");
        addClickListener(e -> {
            this.mainView.removeAll();
            this.mainView.add(dashboard.getLeftButtonPanel());
            this.mainView.add(dashboard.getContainer());
        });
    }
}
