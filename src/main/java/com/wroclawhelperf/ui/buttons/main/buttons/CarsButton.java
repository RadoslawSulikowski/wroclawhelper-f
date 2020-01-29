package com.wroclawhelperf.ui.buttons.main.buttons;

import com.vaadin.flow.component.button.Button;
import com.wroclawhelperf.ui.buttons.abstrct.templates.MainButtonAbstract;
import com.wroclawhelperf.ui.buttons.secondary.buttons.cars.AllCarsButton;
import com.wroclawhelperf.ui.buttons.secondary.buttons.cars.FindNearestCarButton;
import com.wroclawhelperf.ui.views.Dashboard;
import com.wroclawhelperf.ui.views.StationsView;

public final class CarsButton extends MainButtonAbstract {

    private final Dashboard dashboard;

    public CarsButton(Dashboard dashboard) {
        super();
        this.dashboard = dashboard;
        setText("CARS");
        StationsView stationsView = new StationsView(this.dashboard);
        Button getAllCarsButton = new AllCarsButton(stationsView);
        Button findNearestCarButton = new FindNearestCarButton(stationsView);
        addClickListener(e -> {
            this.dashboard.reset();
            this.dashboard.getHeading().setText("VOZILLA CARS PANEL");
            this.dashboard.getContainer().add(stationsView);
            this.dashboard.getSecondaryButtonPanel().add(getAllCarsButton, findNearestCarButton);
        });
    }
}
