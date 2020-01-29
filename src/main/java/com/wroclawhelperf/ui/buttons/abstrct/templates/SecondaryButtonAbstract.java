package com.wroclawhelperf.ui.buttons.abstrct.templates;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;

public abstract class SecondaryButtonAbstract extends Button {

    public SecondaryButtonAbstract() {
        addThemeVariants(ButtonVariant.LUMO_SMALL);
    }
}
