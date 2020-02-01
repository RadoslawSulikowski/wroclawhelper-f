package com.wroclawhelperf.ui.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.wroclawhelperf.domain.User;
import com.wroclawhelperf.service.UserService;
import com.wroclawhelperf.ui.MainView;

public class UserPanelView extends VerticalLayout {

    private final Dashboard dashboard;
    private final UserService userService = UserService.getInstance();
    User user = userService.getUserByUsername(MainView.getLoggedUser());

    private HorizontalLayout usernameRow = new HorizontalLayout();
    private HorizontalLayout firstNameRow = new HorizontalLayout();
    private HorizontalLayout lastNameRow = new HorizontalLayout();
    private HorizontalLayout passwordRow = new HorizontalLayout();
    private HorizontalLayout emailRow = new HorizontalLayout();
    private HorizontalLayout LocationBlock = new HorizontalLayout();
    private HorizontalLayout schedulerRow = new HorizontalLayout();
    private HorizontalLayout saveAndCancelButtonsRow = new HorizontalLayout();

    public UserPanelView(Dashboard d) {
        dashboard = d;
        setContent();

    }

    private void setContent() {

        usernameRow.add(new Label(MainView.getLoggedUser()));

        TextField firstNameField = new TextField();
        firstNameField.setValue(user.getFirstName());
        Button saveFirstNameButton = new Button("SAVE");
        firstNameRow.add(new Label(" FIRST NAME:"), firstNameField,saveFirstNameButton);

        TextField lastNameField = new TextField();
        lastNameField.setValue(user.getLastName());
        Button saveLastNameButton = new Button("SAVE");
        lastNameRow.add(new Label("LAST NAME:"), lastNameField, saveLastNameButton);

        PasswordField passwordField = new PasswordField();
        PasswordField confirmPasswordField = new PasswordField();
        firstNameField.setValue(user.getFirstName());
        Button savePasswordButton = new Button("SAVE");
        passwordRow.add(new Label("PASSWORD:"), passwordField, confirmPasswordField, savePasswordButton);

        EmailField emailField = new EmailField();
        emailField.setValue(user.getEmail());
        Button saveEmailButton = new Button("SAVE");
        emailRow.add(new Label("EMAIL:"), emailField, saveEmailButton);

        LocationBlock.add(new Label("LOCATION:"));
        schedulerRow.add(new Label("SCHEDULER:"));
        saveAndCancelButtonsRow.add(new Button("CANCEL"), new Button("SAVE ALL CHANGES"));
        
        
        
        add(usernameRow, firstNameRow, lastNameRow, passwordRow, emailRow, LocationBlock, schedulerRow, saveAndCancelButtonsRow);
    }
}
