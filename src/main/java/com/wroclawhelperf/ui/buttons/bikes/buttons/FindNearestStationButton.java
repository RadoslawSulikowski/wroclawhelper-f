package com.wroclawhelperf.ui.buttons.bikes.buttons;

import com.wroclawhelperf.ui.buttons.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.views.BikeStationsView;

public class FindNearestStationButton extends SecondaryButtonAbstract {

    private final BikeStationsView bikeStationsView;

    public FindNearestStationButton(BikeStationsView bikeStationsView) {
        super();
        this.bikeStationsView = bikeStationsView;
        setText("FIND NEAREST");
        addClickListener(e -> {
            this.bikeStationsView.reset();

        });
    }
}
