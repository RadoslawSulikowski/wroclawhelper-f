package com.wroclawhelperf.ui.buttons.main.buttons;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.wroclawhelperf.ui.buttons.MainButtonLayout;
import com.wroclawhelperf.ui.buttons.bikes.buttons.GetAllBikeStationsButton;
import com.wroclawhelperf.ui.views.BikeStationsView;
import com.wroclawhelperf.ui.views.Dashboard;

public final class BikesButton extends MainButtonLayout {

    private static BikesButton bikesButtonInstance = null;
    private final Dashboard dashboard;

    public static BikesButton getInstance(Dashboard dashboard) {
        if (bikesButtonInstance == null) {
            bikesButtonInstance = new BikesButton(dashboard);
        }
        return bikesButtonInstance;
    }

    private BikesButton(Dashboard dashboard) {
        super();
        this.dashboard = dashboard;
        setText("BIKES");
        HorizontalLayout secondLevelButtonPanel = new HorizontalLayout(
                GetAllBikeStationsButton.getInstance(BikeStationsView.getInstance(dashboard)));
        addClickListener(e -> {
            BikeStationsView.getInstance(dashboard).removeAll();
            dashboard.add(secondLevelButtonPanel);
            dashboard.add(BikeStationsView.getInstance(dashboard));
        });
    }
}
