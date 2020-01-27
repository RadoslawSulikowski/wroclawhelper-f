package com.wroclawhelperf.ui.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;

@Getter
public class BikeStationsView extends VerticalLayout {
    private final Dashboard dashboard;

    public BikeStationsView(Dashboard dashboard) {
        this.dashboard = dashboard;
        setContent();
    }

    private void setContent() {

    }

    public void reset() {
        removeAll();
        setContent();
    }

}
