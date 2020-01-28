package com.wroclawhelperf.ui.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;

@Getter
public class BikeStationsView extends VerticalLayout {

    private final Dashboard dashboard;

    private VerticalLayout resultContainer = new VerticalLayout();

    public BikeStationsView(Dashboard dashboard) {
        this.dashboard = dashboard;
        setContent();
    }

    private void setContent() {
        resultContainer.setHeight("30%");
        add(resultContainer);
    }

    public void reset() {
        resultContainer.removeAll();
        removeAll();
        setContent();
    }

}
