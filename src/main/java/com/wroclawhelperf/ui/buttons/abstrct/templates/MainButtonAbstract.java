package com.wroclawhelperf.ui.buttons.abstrct.templates;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.wroclawhelperf.ui.MainView;

public abstract class MainButtonAbstract extends Button {

    public MainButtonAbstract() {
        addThemeVariants(ButtonVariant.LUMO_CONTRAST);
    }
}
