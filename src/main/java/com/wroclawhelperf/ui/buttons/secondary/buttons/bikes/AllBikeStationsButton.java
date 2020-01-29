package com.wroclawhelperf.ui.buttons.secondary.buttons.bikes;

import com.wroclawhelperf.ui.buttons.abstrct.templates.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.grids.layouts.AllBikeStationsGridLayout;
import com.wroclawhelperf.ui.views.StationsView;

public class AllBikeStationsButton extends SecondaryButtonAbstract {

    private final StationsView bikeStationsView;

    public AllBikeStationsButton(StationsView stationsView) {
        super();
        bikeStationsView = stationsView;
        setText("ALL STATIONS");

        addClickListener(e -> {
            bikeStationsView.removeAll();
            bikeStationsView.add(new AllBikeStationsGridLayout());
        });
    }
}
