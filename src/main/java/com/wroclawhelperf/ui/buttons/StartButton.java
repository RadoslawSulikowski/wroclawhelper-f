package com.wroclawhelperf.ui.buttons;

import com.vaadin.flow.component.button.Button;
import com.wroclawhelperf.ui.MainView;
import com.wroclawhelperf.ui.buttons.main.buttons.*;
import com.wroclawhelperf.ui.views.Dashboard;

public class StartButton extends Button {

    private MainView mainView;
    private static StartButton startButtonInstance = null;

    public static StartButton getInstance(MainView mainView) {
        if (startButtonInstance == null) {
            startButtonInstance = new StartButton(mainView);
        }
        return startButtonInstance;
    }

    private StartButton(MainView mainView) {
        this.mainView = mainView;
        setText("LET'S GET STARTED!");
        addClickListener(e -> {
            this.mainView.reset();
            this.mainView.getLeftPanel().removeAll();
            this.mainView.getLeftPanel().add(
                    UserPanelButton.getInstance(),
                    BikesButton.getInstance(),
                    WeatherButton.getInstance(),
                    CarsButton.getInstance(),
                    GoodbyeButton.getInstance(this.mainView));
            this.mainView.add(Dashboard.getInstance());
        });
    }
}
