package com.wroclawhelperf.ui.views;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.wroclawhelperf.ui.MainView;
import com.wroclawhelperf.ui.buttons.RegisterButton;
import lombok.Getter;

@Getter
public class RegistrationPanelView extends VerticalLayout {

    private final MainView mainView;

    private HorizontalLayout usernameRow = new HorizontalLayout();
    private HorizontalLayout firstNameRow = new HorizontalLayout();
    private HorizontalLayout lastNameRow = new HorizontalLayout();
    private HorizontalLayout emailRow = new HorizontalLayout();
    private VerticalLayout LocationBlock = new VerticalLayout();
    private HorizontalLayout schedulerRow = new HorizontalLayout();
    private HorizontalLayout latitudeRow = new HorizontalLayout();
    private HorizontalLayout longitudeRow = new HorizontalLayout();
    private HorizontalLayout saveAndCancelButtonsRow = new HorizontalLayout();
    private HorizontalLayout passwordRow = new HorizontalLayout();

    private TextField firstNameField = new TextField();
    private TextField lastNameField = new TextField();
    private TextField usernameField = new TextField();
    private EmailField emailField = new EmailField();
    private NumberField latitudeField = new NumberField();
    private NumberField longitudeField = new NumberField();
    private Checkbox schedulerCheckbox = new Checkbox();
    private PasswordField passwordField = new PasswordField();
    private PasswordField confirmPasswordField = new PasswordField();

    public RegistrationPanelView(MainView view) {
        mainView = view;

        usernameRow.add(new Label("USERNAME:"), usernameField);
        firstNameRow.add(new Label(" FIRST NAME:"), firstNameField);
        lastNameRow.add(new Label("LAST NAME:"), lastNameField);
        emailRow.add(new Label("EMAIL:"), emailField);
        latitudeRow.add(new Label("latitude"), latitudeField);
        longitudeRow.add(new Label("longitude"), longitudeField);
        LocationBlock.add(new Label("FAVORITE LOCATION:"), latitudeRow, longitudeRow);
        schedulerRow.add(new Label("SCHEDULER ON:"), schedulerCheckbox);

        passwordRow.add(new Label("PASSWORD:"), passwordField,
                new Label("CONFIRM PASSWORD:"), confirmPasswordField);
        saveAndCancelButtonsRow.add(new RegisterButton(this));

        add(usernameRow, firstNameRow, lastNameRow, passwordRow, emailRow, LocationBlock, schedulerRow,
                saveAndCancelButtonsRow);
    }
}
