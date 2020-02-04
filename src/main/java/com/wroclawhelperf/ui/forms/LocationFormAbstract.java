package com.wroclawhelperf.ui.forms;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class LocationFormAbstract extends FormLayout {

    static final Logger LOGGER = LoggerFactory.getLogger(LocationFormAbstract.class);
    NumberField latitudeTF = new NumberField("latitude", "latitude");
    NumberField longitudeTF = new NumberField("longitude", "longitude");
    private Button find = new Button("FIND");
    private Button fill = new Button("FILL WITH FAVORITE LOCATION");

    private HorizontalLayout fields = new HorizontalLayout(latitudeTF, longitudeTF, fill);
    private VerticalLayout form = new VerticalLayout(fields, find);

    LocationFormAbstract() {
        add(form);
        find.addClickListener(e -> find());
        fill.addClickListener(e -> fill());
    }

    protected abstract void find();

    protected abstract void fill();

}
