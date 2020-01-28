package com.wroclawhelperf.ui.forms;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.wroclawhelperf.domain.GPSLocation;
import com.wroclawhelperf.domain.Weather;
import com.wroclawhelperf.service.WeatherService;
import com.wroclawhelperf.ui.views.StationsView;

import static java.lang.Double.parseDouble;

public class LocationForWeatherForm extends LocationFormAbstract {

    private final WeatherService service = WeatherService.getInstance();
    private StationsView weatherView;

    public LocationForWeatherForm(StationsView weatherView) {
        super();
        this.weatherView = weatherView;
    }

    @Override
    protected void find() {
        try {
            double latitude = parseDouble(latitudeTF.getValue());
            double longitude = parseDouble(longitudeTF.getValue());
            GPSLocation location = new GPSLocation(latitude, longitude);
            Grid<Weather> weather = new Grid<>(Weather.class);
            weather.setColumns("measuringTime", "windSpeed", "windDirection", "humidity", "airTemperature",
                    "groundTemperature", "precipitationType", "weatherStationName");
            weather.getColumns().forEach(c -> c.setAutoWidth(true));
            weatherView.getResultContainer().removeAll();
            weatherView.getResultContainer().add(weather);
            weather.setItems(service.getWeatherNearestLocation(location));
        } catch(Exception e) {
            LOGGER.error(e.getMessage(), e);
            Notification.show("Check data format and completeness");
        }
    }
}
