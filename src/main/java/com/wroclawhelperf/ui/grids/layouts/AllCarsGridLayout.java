package com.wroclawhelperf.ui.grids.layouts;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.wroclawhelperf.domain.VozillaCar;
import com.wroclawhelperf.service.CarService;

public class AllCarsGridLayout extends VerticalLayout {

    private final CarService service = CarService.getInstance();

    public AllCarsGridLayout() {

        Label plateNumber = new Label();

        Grid<VozillaCar> singleCarGrid = new Grid<>(VozillaCar.class);
        singleCarGrid.setColumns("sideNumber", "batteryLevelPct", "rangeKm",
                "address", "location.latitude", "location.longitude");
        singleCarGrid.getColumns().forEach(c -> c.setAutoWidth(true));

        Grid<VozillaCar> carsGrid = new Grid<>(VozillaCar.class);
        carsGrid.setColumns("platesNumber", "type", "name", "color", "status");
        carsGrid.getColumns().forEach(c -> c.setAutoWidth(true));
        carsGrid.setItems(service.getAllCars());
        carsGrid.addComponentColumn(cars -> {
            Button button = new Button("DETAILS");
            button.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
            button.addClickListener(click -> {
                plateNumber.setText(cars.getPlatesNumber());
                singleCarGrid.setItems(cars);
            });
            return button;
        });

        add(carsGrid, plateNumber, singleCarGrid);
    }
}
