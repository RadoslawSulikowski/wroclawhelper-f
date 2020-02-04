package com.wroclawhelperf.ui.buttons;

import com.vaadin.flow.component.button.Button;
import com.wroclawhelperf.ui.MainView;
import com.wroclawhelperf.ui.views.RegistrationPanelView;

public class RegistrationPanelButton extends Button {

    private final MainView mainView;

    public RegistrationPanelButton(MainView view) {
        mainView = view;
        setText("REGISTRATION PANEL");

        addClickListener(e -> {
            mainView.getContainer().removeAll();
            mainView.getContainer().add(new RegistrationPanelView(mainView));
        });
    }
}
