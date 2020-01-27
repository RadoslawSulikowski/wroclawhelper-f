package com.wroclawhelperf.ui.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.wroclawhelperf.ui.MainView;
import com.wroclawhelperf.ui.buttons.main.buttons.*;
import lombok.Getter;

@Getter
public class Dashboard extends HorizontalLayout {

    private final MainView mainView;

    private VerticalLayout leftButtonPanel = new VerticalLayout();
    private VerticalLayout container = new VerticalLayout();

    private Button userPanelButton = new UserPanelButton(this);
    private Button bikesButton = new BikesButton(this);
    private Button weatherButton = new WeatherButton(this);
    private Button carsButton = new CarsButton(this);
    private Button goodbyeButton = new GoodbyeButton(this);
    private Label heading = new Label();

    private HorizontalLayout secondaryButtonPanel = new HorizontalLayout();

    public Dashboard(MainView mainView) {
        this.mainView = mainView;
        setContent();
    }

    private void setContent() {
        heading.setHeight("10%");
        secondaryButtonPanel.setHeight("10%");
        leftButtonPanel.setWidth("10%");
        container.setWidth("90%");

        leftButtonPanel.add(userPanelButton,bikesButton, weatherButton, carsButton, goodbyeButton);
        container.add(heading, secondaryButtonPanel);

        add(leftButtonPanel, container);
    }

    public void reset() {
        heading.setText("");
        secondaryButtonPanel.removeAll();
        container.removeAll();
        container.add(heading, secondaryButtonPanel);
    }
}
