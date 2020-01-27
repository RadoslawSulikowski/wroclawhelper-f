package com.wroclawhelperf.ui.buttons;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;

public abstract class SecondaryButtonAbstract extends Button {

    public SecondaryButtonAbstract() {
        addThemeVariants(ButtonVariant.LUMO_SMALL);
    }
}
