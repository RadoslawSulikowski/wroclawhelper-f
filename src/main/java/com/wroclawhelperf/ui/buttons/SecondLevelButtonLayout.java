package com.wroclawhelperf.ui.buttons;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;

public abstract class SecondLevelButtonLayout extends Button {

    public SecondLevelButtonLayout() {
        addThemeVariants(ButtonVariant.LUMO_SMALL);
    }
}
