package com.wroclawhelperf.ui.views;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Dashboard extends VerticalLayout {

    private static Dashboard dashboardInstance = null;
    private Label heading = new Label();
    private HorizontalLayout secondaryButtonPanel = new HorizontalLayout();


    public static Dashboard getInstance() {
        if (dashboardInstance == null) {
            dashboardInstance = new Dashboard();
        }
        return dashboardInstance;
    }

    private Dashboard() {
        setContent();
    }

    private void setContent() {
        heading.setHeight("10%");
        secondaryButtonPanel.setHeight("10%");
        add(heading, secondaryButtonPanel);

    }

    public void reset() {
        heading.setText("");
        secondaryButtonPanel.removeAll();
        removeAll();
        add(heading, secondaryButtonPanel);
    }

    public Label getHeading() {
        return heading;
    }

    public HorizontalLayout getSecondaryButtonPanel() {
        return secondaryButtonPanel;
    }
}
