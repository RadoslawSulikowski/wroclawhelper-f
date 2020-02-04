package com.wroclawhelperf.ui.forms;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.wroclawhelperf.domain.GPSLocation;
import com.wroclawhelperf.domain.User;
import com.wroclawhelperf.domain.Weather;
import com.wroclawhelperf.service.WeatherService;
import com.wroclawhelperf.ui.views.StationsView;

public class LocationForWeatherForm extends LocationFormAbstract {

    private StationsView weatherView;

    public LocationForWeatherForm(StationsView weatherView) {
        super();
        this.weatherView = weatherView;
    }

    @Override
    protected void find() {
        try {
            double latitude = latitudeTF.getValue();
            double longitude = longitudeTF.getValue();
            GPSLocation location = new GPSLocation(latitude, longitude);
            Grid<Weather> weather = new Grid<>(Weather.class);
            weather.setColumns("measuringTime", "windSpeed", "windDirection", "humidity", "airTemperature",
                    "groundTemperature", "precipitationType", "weatherStationName");
            weather.getColumns().forEach(c -> c.setAutoWidth(true));
            weatherView.getResultContainer().removeAll();
            weatherView.getResultContainer().add(weather);
            weather.setItems(WeatherService.getInstance().getWeatherNearestLocation(location));
        } catch(Exception e) {
            LOGGER.error(e.getMessage(), e);
            Notification.show("Check data format and completeness");
        }
    }

    @Override
    protected void fill() {
        User user = weatherView.getDashboard().getUser();
        latitudeTF.setValue(user.getLocation().getLatitude());
        longitudeTF.setValue(user.getLocation().getLongitude());
    }
}
