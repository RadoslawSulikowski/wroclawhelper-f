package com.wroclawhelperf.ui.buttons.secondary.buttons.weather;

import com.vaadin.flow.component.grid.Grid;
import com.wroclawhelperf.domain.Weather;
import com.wroclawhelperf.service.WeatherService;
import com.wroclawhelperf.ui.buttons.abstrct.templates.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.views.StationsView;

public class WeatherAtAllStationsButton extends SecondaryButtonAbstract {

    private final StationsView weatherView;
    private WeatherService service = WeatherService.getInstance();

    public WeatherAtAllStationsButton(StationsView staionView) {
        super();
        weatherView = staionView;
        setText("WEATHER ON ALL STATIONS");
        Grid<Weather> weather = new Grid<>(Weather.class);
        weather.setColumns("measuringTime", "windSpeed", "windDirection", "humidity", "airTemperature",
                "groundTemperature", "precipitationType", "weatherStationName");
        weather.getColumns().forEach(c -> c.setAutoWidth(true));
        weather.setItems(service.getWeatherOnAllStations());
        addClickListener(e -> {
            weatherView.removeAll();
            weatherView.add(weather);
        });
    }
}
