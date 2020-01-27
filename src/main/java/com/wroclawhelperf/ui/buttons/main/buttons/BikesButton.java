package com.wroclawhelperf.ui.buttons.main.buttons;

import com.wroclawhelperf.ui.buttons.MainButtonAbstract;
import com.wroclawhelperf.ui.buttons.bikes.buttons.GetAllBikeStationsButton;
import com.wroclawhelperf.ui.views.BikeStationsView;
import com.wroclawhelperf.ui.views.Dashboard;

public final class BikesButton extends MainButtonAbstract {

    private static BikesButton bikesButtonInstance = null;
    private final Dashboard dashboard = Dashboard.getInstance();

    public static BikesButton getInstance() {
        if (bikesButtonInstance == null) {
            bikesButtonInstance = new BikesButton();
        }
        return bikesButtonInstance;
    }

    private BikesButton() {
        super();
        setText("BIKES");
        addClickListener(e -> {
            BikeStationsView.getInstance().reset();
            dashboard.reset();
            dashboard.getHeading().setText("BIKE STATION PANEL");
            dashboard.getSecondaryButtonPanel().add(GetAllBikeStationsButton.getInstance());
            dashboard.add(BikeStationsView.getInstance());
        });
    }
}
