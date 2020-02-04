package com.wroclawhelperf.ui.grids.layouts;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.wroclawhelperf.domain.VozillaCar;
import com.wroclawhelperf.service.CarService;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;


public class AllCarsGridLayout extends VerticalLayout {

    private TextField filterByPlates = new TextField();
    private TextField filterByAddress = new TextField();
    private Grid<VozillaCar> singleCarGrid = new Grid<>(VozillaCar.class);
    private Grid<VozillaCar> carsGrid = new Grid<>(VozillaCar.class);
    private Label plateNumber = new Label();
    private List<VozillaCar> carList = CarService.getInstance().getAllCars();

    public AllCarsGridLayout() {

        filterByPlates.setPlaceholder("Filter by plates number...");
        filterByPlates.setClearButtonVisible(true);
        filterByPlates.setValueChangeMode(ValueChangeMode.EAGER);
        filterByPlates.addValueChangeListener(e -> updateByPlatesNumber());

        filterByAddress.setPlaceholder("Filter by address number...");
        filterByAddress.setClearButtonVisible(true);
        filterByAddress.setValueChangeMode(ValueChangeMode.EAGER);
        filterByAddress.addValueChangeListener(e -> updateByAddress());


        carsGrid.setColumns("name", "platesNumber", "status", "batteryLevelPct", "address");
        carsGrid.getColumns().forEach(c -> c.setAutoWidth(true));
        carsGrid.setItems(carList);
        carsGrid.addComponentColumn(cars -> {
            Button button = new Button("DETAILS");
            button.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
            button.addClickListener(click -> {
                plateNumber.setText(cars.getPlatesNumber());
                add(singleCarGrid);
                singleCarGrid.setItems(cars);
            });
            return button;
        });

        singleCarGrid.setColumns("sideNumber", "color", "type", "rangeKm",
                "location.latitude", "location.longitude");
        singleCarGrid.getColumns().forEach(c -> c.setAutoWidth(true));
        add(new HorizontalLayout(filterByPlates, filterByAddress), carsGrid, plateNumber);
    }

    private void updateByAddress() {
        carsGrid.setItems(carList.stream()
                .filter(c -> (ofNullable(c.getAddress()).orElse("")).toUpperCase().contains(filterByAddress.getValue().toUpperCase()))
                .collect(Collectors.toList()));
    }

    private void updateByPlatesNumber() {
        carsGrid.setItems(carList.stream()
                .filter(c -> c.getPlatesNumber().toUpperCase().contains(filterByPlates.getValue().toUpperCase()))
                .collect(Collectors.toList()));
    }
}
