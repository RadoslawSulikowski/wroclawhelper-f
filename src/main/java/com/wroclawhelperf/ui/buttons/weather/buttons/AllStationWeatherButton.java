package com.wroclawhelperf.ui.buttons.weather.buttons;

import com.vaadin.flow.component.grid.Grid;
import com.wroclawhelperf.domain.Weather;
import com.wroclawhelperf.service.WeatherService;
import com.wroclawhelperf.ui.buttons.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.views.WeatherView;

public class AllStationWeatherButton extends SecondaryButtonAbstract {

    private final WeatherView weatherView;
    private WeatherService service = WeatherService.getInstance();

    public AllStationWeatherButton(WeatherView weatherView) {
        super();
        this.weatherView = weatherView;
        setText("WEATHER ON ALL STATIONS");
        Grid<Weather> weather = new Grid<>(Weather.class);
        weather.setColumns("measuringTime", "windSpeed", "windDirection", "humidity", "airTemperature",
                "groundTemperature", "precipitationType", "weatherStationName");
        weather.getColumns().forEach(c -> c.setAutoWidth(true));
        weather.setItems(service.getWeatherOnAllStations());
        addClickListener(e -> {
            this.weatherView.removeAll();
            this.weatherView.add(weather);
        });
    }
}
