package com.wroclawhelperf.ui.forms;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class LocationFormAbstract extends FormLayout {

    static final Logger LOGGER = LoggerFactory.getLogger(LocationFormAbstract.class);
    TextField latitudeTF = new TextField("latitude", "latitude");
    TextField longitudeTF = new TextField("longitude", "longitude");
    private Button find = new Button("FIND");

    private HorizontalLayout fields = new HorizontalLayout(latitudeTF, longitudeTF);
    private VerticalLayout form = new VerticalLayout(fields, find);

    LocationFormAbstract() {
        add(form);
        find.addClickListener(e -> find());
    }

    protected abstract void find();

}
