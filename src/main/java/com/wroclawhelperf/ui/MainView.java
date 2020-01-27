package com.wroclawhelperf.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.wroclawhelperf.ui.views.Dashboard;

@Route
public class MainView extends VerticalLayout {

    private Button logIn = new Button("LET'S GET STARTED!");
    private Label label = new Label();

    public MainView() {
        setContent();
    }

    private void setContent() {
        label.setText("WELCOME!");
        logIn.addClickListener(e -> {
            removeAll();
            Dashboard.getInstance(this).reset();
            add(Dashboard.getInstance(this));
        });
        HorizontalLayout heading = new HorizontalLayout(label);
        HorizontalLayout toolbar = new HorizontalLayout(logIn);
        add(heading, toolbar);
        setSizeFull();
    }

    public void reset() {
        removeAll();
        setContent();
    }

}
