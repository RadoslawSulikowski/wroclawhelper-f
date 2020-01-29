package com.wroclawhelperf.ui.grids.layouts;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.wroclawhelperf.domain.Weather;
import com.wroclawhelperf.domain.WeatherStation;
import com.wroclawhelperf.service.WeatherService;
import com.wroclawhelperf.service.WeatherStationService;

public class AllWeatherStationGridLayout extends VerticalLayout {

    private final WeatherStationService stationService = WeatherStationService.getInstance();
    private final WeatherService weatherService= WeatherService.getInstance();

    public AllWeatherStationGridLayout() {

        Label stationName = new Label();

        Grid<Weather> weatherOnStation = new Grid<>(Weather.class);
        weatherOnStation.setColumns("measuringTime", "windSpeed", "windDirection", "humidity", "airTemperature",
                "groundTemperature", "precipitationType", "weatherStationName");
        weatherOnStation.getColumns().forEach(c -> c.setAutoWidth(true));

        Grid<WeatherStation> allStations = new Grid<>(WeatherStation.class);
        allStations.setColumns("shortName", "name", "location");
        allStations.getColumns().forEach(c -> c.setAutoWidth(true));
        allStations.setItems(stationService.getWeatherStations());
        allStations.addComponentColumn(station -> {
            Button button = new Button("CHECK WEATHER");
            button.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
            button.addClickListener(e -> {
                stationName.setText(station.getName());
                weatherOnStation.setItems(weatherService.getWeatherOnStation(station.getShortName()));
            });
            return button;
        });

        add(allStations, stationName, weatherOnStation);
    }
}
