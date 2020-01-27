package com.wroclawhelperf.ui.views;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.wroclawhelperf.ui.MainView;
import com.wroclawhelperf.ui.buttons.main.buttons.*;

public class Dashboard extends VerticalLayout {

    private final MainView mainView;
    private static Dashboard dashboardInstance = null;

    public static Dashboard getInstance(MainView mainView) {
        if (dashboardInstance == null) {
            dashboardInstance = new Dashboard(mainView);
        }
        return dashboardInstance;
    }

    private Dashboard(MainView mainView) {
        this.mainView = mainView;
        setContent();
    }

    private void setContent() {
        HorizontalLayout buttonPanel = new HorizontalLayout(
                UserPanelButton.getInstance(this),
                BikesButton.getInstance(this),
                WeatherButton.getInstance(this),
                CarsButton.getInstance(this),
                GoodbyeButton.getInstance(this));
        mainView.add(buttonPanel);
    }

    public void reset() {
        removeAll();
        setContent();
    }

    public MainView getMainView() {
        return mainView;
    }
}
