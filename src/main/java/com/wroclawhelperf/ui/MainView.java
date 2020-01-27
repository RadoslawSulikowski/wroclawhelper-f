package com.wroclawhelperf.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.wroclawhelperf.ui.buttons.StartButton;
import lombok.Getter;

@Getter
@Route
public class MainView extends HorizontalLayout {

    private VerticalLayout leftPanel = new VerticalLayout();
    private VerticalLayout container = new VerticalLayout();
    private Label label = new Label();
    private Button startButton = new StartButton(this);

    public MainView() {
        setContent();
    }

    private void setContent() {
        label.setText("WELCOME!");
        leftPanel.setWidth("10%");
        leftPanel.add(label, startButton);
        add(leftPanel, container);
    }

    public void reset() {
        leftPanel.removeAll();
        container.removeAll();
        removeAll();
        setContent();
    }
}
