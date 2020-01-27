package com.wroclawhelperf.ui.buttons;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;

public abstract class MainButtonLayout extends Button {

    public MainButtonLayout() {
        addThemeVariants(ButtonVariant.LUMO_CONTRAST);
    }
}
