package com.wroclawhelperf.ui.forms;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.wroclawhelperf.domain.BikeStation;
import com.wroclawhelperf.domain.GPSLocation;
import com.wroclawhelperf.service.BikeService;
import com.wroclawhelperf.ui.buttons.bikes.buttons.nextlvlbut.FindNearestFromLocation;
import com.wroclawhelperf.ui.views.BikeStationsView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Double.parseDouble;

public class LocationForm extends FormLayout {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindNearestFromLocation.class);
    private BikeService service = BikeService.getInstance();
    private BikeStationsView bikeStationsView;

    private TextField latitudeTF = new TextField("latitude", "latitude");
    private TextField longitudeTF = new TextField("longitude", "longitude");
    private Button find = new FindNearestFromLocation();

    private HorizontalLayout fields = new HorizontalLayout(latitudeTF, longitudeTF);
    private VerticalLayout form = new VerticalLayout(fields, find);

    public LocationForm(BikeStationsView bikeStationsView) {
        this.bikeStationsView = bikeStationsView;
        add(form);
        find.addClickListener(e -> find());
    }

    private void find() {
        try {
            double latitude = parseDouble(latitudeTF.getValue());
            double longitude = parseDouble(longitudeTF.getValue());
            GPSLocation location = new GPSLocation(latitude, longitude);
            Grid<BikeStation> resultStation = new Grid<>(BikeStation.class);
            resultStation.setColumns("name", "bikes", "bookedBikes", "uniqueId", "number", "bikeList", "location");
            resultStation.getColumns().forEach(c -> c.setAutoWidth(true));
            bikeStationsView.getResultContainer().removeAll();
            bikeStationsView.getResultContainer().add(resultStation);
            resultStation.setItems(service.getBikeStationNearestLocation(location));
        } catch(Exception e) {
            LOGGER.error(e.getMessage());
            Notification.show("Check data format and completeness");
        }
    }

}
