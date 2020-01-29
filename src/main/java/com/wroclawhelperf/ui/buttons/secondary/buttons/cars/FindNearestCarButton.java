package com.wroclawhelperf.ui.buttons.secondary.buttons.cars;

import com.wroclawhelperf.ui.buttons.abstrct.templates.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.views.StationsView;

public class FindNearestCarButton extends SecondaryButtonAbstract {
    private final StationsView carView;

    public FindNearestCarButton(StationsView stationsView) {
        carView = stationsView;
        setText("FIND NEAREST");
    }
}
