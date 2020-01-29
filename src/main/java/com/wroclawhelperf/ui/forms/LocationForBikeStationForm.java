package com.wroclawhelperf.ui.forms;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.wroclawhelperf.domain.BikeStation;
import com.wroclawhelperf.domain.GPSLocation;
import com.wroclawhelperf.service.BikeService;
import com.wroclawhelperf.ui.views.StationsView;

import static java.lang.Double.parseDouble;

public class LocationForBikeStationForm extends LocationFormAbstract {

    private BikeService service = BikeService.getInstance();
    private StationsView stationsView;

    public LocationForBikeStationForm(StationsView stationsView) {
        super();
        this.stationsView = stationsView;
    }

    @Override
    protected void find() {
        try {
            double latitude = parseDouble(latitudeTF.getValue());
            double longitude = parseDouble(longitudeTF.getValue());
            GPSLocation location = new GPSLocation(latitude, longitude);
            Grid<BikeStation> resultStation = new Grid<>(BikeStation.class);
            resultStation.setColumns("name", "bikes", "bookedBikes", "uniqueId", "number", "bikeList",
                    "location.latitude", "location.longitude");
            resultStation.getColumns().forEach(c -> c.setAutoWidth(true));
            stationsView.getResultContainer().removeAll();
            stationsView.getResultContainer().add(resultStation);
            resultStation.setItems(service.getBikeStationNearestLocation(location));
        } catch(Exception e) {
            LOGGER.error(e.getMessage(), e);
            Notification.show("Check data format and completeness");
        }
    }

}
