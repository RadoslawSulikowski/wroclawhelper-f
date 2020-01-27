package com.wroclawhelperf.ui;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.wroclawhelperf.ui.buttons.StartButton;

@Route
public class MainView extends HorizontalLayout {

    private VerticalLayout leftPanel = new VerticalLayout();
    private Label label = new Label();

    public MainView() {
        setContent();
    }

    private void setContent() {
        label.setText("WELCOME!");
        leftPanel.setWidth("10%");
        leftPanel.add(label, StartButton.getInstance(this));
        add(leftPanel);
    }

    public void reset() {
        leftPanel.removeAll();
        leftPanel.add(label, StartButton.getInstance(this));
    }

    public VerticalLayout getLeftPanel() {
        return leftPanel;
    }
}
