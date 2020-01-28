package com.wroclawhelperf.ui.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class WeatherView extends VerticalLayout {

    private final Dashboard dashboard;

    public WeatherView(Dashboard dashboard) {
        this.dashboard = dashboard;
    }
}
