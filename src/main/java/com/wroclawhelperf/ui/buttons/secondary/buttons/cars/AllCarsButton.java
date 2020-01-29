package com.wroclawhelperf.ui.buttons.secondary.buttons.cars;

import com.wroclawhelperf.ui.buttons.abstrct.templates.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.grids.layouts.AllCarsGridLayout;
import com.wroclawhelperf.ui.views.StationsView;

public class AllCarsButton extends SecondaryButtonAbstract {
    private final StationsView carView;

    public AllCarsButton(StationsView stationsView) {
        carView = stationsView;
        setText("ALL CARS");

        addClickListener(e -> {
            carView.removeAll();
            carView.add(new AllCarsGridLayout());
        });
    }
}
