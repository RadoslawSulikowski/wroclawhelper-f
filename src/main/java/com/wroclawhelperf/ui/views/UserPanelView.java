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
import com.wroclawhelperf.domain.User;
import com.wroclawhelperf.ui.MainView;
import com.wroclawhelperf.ui.buttons.secondary.buttons.user.*;
import lombok.Getter;

@Getter
public class UserPanelView extends VerticalLayout {

    private final Dashboard dashboard;

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

    private Label dialogLabel = new Label();
    private Dialog dialog = new Dialog(dialogLabel);

    private TextField firstNameField = new TextField();
    private TextField lastNameField = new TextField();
    private EmailField emailField = new EmailField();
    private NumberField latitudeField = new NumberField();
    private NumberField longitudeField = new NumberField();
    private Checkbox schedulerCheckbox = new Checkbox();
    private PasswordField passwordField = new PasswordField();
    private PasswordField confirmPasswordField = new PasswordField();

    public UserPanelView(Dashboard d) {
        dashboard = d;
    }

    public void setContentPersonalData() {

        usernameRow.add(new Label("USERNAME:"), new Label(MainView.getLoggedUser()));

        dialog.setWidth("300px");
        dialog.setHeight("100px");

        firstNameField.setValue(dashboard.getUser().getFirstName());
        firstNameRow.add(new Label(" FIRST NAME:"), firstNameField, new SaveFirstNameButton(this));

        lastNameField.setValue(dashboard.getUser().getLastName());
        lastNameRow.add(new Label("LAST NAME:"), lastNameField, new SaveLastNameButton(this));


        emailField.setValue(dashboard.getUser().getEmail());
        emailRow.add(new Label("EMAIL:"), emailField, new SaveEmailButton(this));

        latitudeField.setValue(dashboard.getUser().getLocation().getLatitude());
        longitudeField.setValue(dashboard.getUser().getLocation().getLongitude());
        latitudeRow.add(new Label("latitude"), latitudeField);
        longitudeRow.add(new Label("longitude"), longitudeField);

        LocationBlock.add(new Label("FAVORITE LOCATION:"), latitudeRow, longitudeRow, new SaveLocationButton(this));

        schedulerCheckbox.setValue(dashboard.getUser().isSchedulerOn());
        schedulerRow.add(new Label("SCHEDULER ON:"), schedulerCheckbox, new SaveSchedulerButton(this));

        saveAndCancelButtonsRow.add(new ResetAllChangesButton(this), new SaveAllChangesButton(this));


        add(usernameRow, firstNameRow, lastNameRow, emailRow, LocationBlock, schedulerRow, saveAndCancelButtonsRow);
    }

    public void setContentChangePassword() {

        passwordRow.add(new Label("PASSWORD:"), passwordField,
                new Label("CONFIRM PASSWORD:"), confirmPasswordField, new SavePasswordButton(this));

        add(passwordRow);
    }

    public void reset() {
        usernameRow.removeAll();
        firstNameRow.removeAll();
        lastNameRow.removeAll();
        emailRow.removeAll();
        LocationBlock.removeAll();
        schedulerRow.removeAll();
        latitudeRow.removeAll();
        longitudeRow.removeAll();
        saveAndCancelButtonsRow.removeAll();
        passwordRow.removeAll();
        removeAll();
    }

    public User getUser() {
        return dashboard.getUser();
    }

    public void setUser(User user) {
        dashboard.setUser(user);
    }
}
