package com.wroclawhelperf.ui.buttons;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;

public abstract class TertiaryButtonAbstract extends Button {

    public TertiaryButtonAbstract() {
        addThemeVariants(ButtonVariant.LUMO_SMALL);
    }
}
