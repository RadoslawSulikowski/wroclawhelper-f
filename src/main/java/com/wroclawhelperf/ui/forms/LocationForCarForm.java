package com.wroclawhelperf.ui.forms;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.wroclawhelperf.domain.GPSLocation;
import com.wroclawhelperf.domain.User;
import com.wroclawhelperf.domain.VozillaCar;
import com.wroclawhelperf.service.CarService;
import com.wroclawhelperf.ui.views.StationsView;

public class LocationForCarForm extends LocationFormAbstract {

    private final StationsView carView;
    private final CarService service = CarService.getInstance();

    public LocationForCarForm(StationsView stationsView) {
        super();
        carView = stationsView;
    }

    @Override
    protected void find() {
        try {
            double latitude = latitudeTF.getValue();
            double longitude = longitudeTF.getValue();
            GPSLocation location = new GPSLocation(latitude, longitude);
            Grid<VozillaCar> resultCar = new Grid<>(VozillaCar.class);
            resultCar.setColumns("platesNumber", "type", "name", "color", "status", "batteryLevelPct", "rangeKm",
                    "address", "location.latitude", "location.longitude");
            resultCar.getColumns().forEach(c -> c.setAutoWidth(true));
            carView.getResultContainer().removeAll();
            carView.getResultContainer().add(resultCar);
            resultCar.setItems(service.getNearestCarFromLocation(location));
        } catch(Exception e) {
            LOGGER.error(e.getMessage(), e);
            Notification.show("Check data format and completeness");
        }
    }

    @Override
    protected void fill() {
        User user = carView.getDashboard().getUser();
        latitudeTF.setValue(user.getLocation().getLatitude());
        longitudeTF.setValue(user.getLocation().getLongitude());
    }
}
