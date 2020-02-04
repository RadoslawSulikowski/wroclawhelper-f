package com.wroclawhelperf.ui.buttons;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.wroclawhelperf.domain.GPSLocation;
import com.wroclawhelperf.domain.UserToRegister;
import com.wroclawhelperf.encryptor.Encryptor;
import com.wroclawhelperf.service.UserService;
import com.wroclawhelperf.ui.views.RegistrationPanelView;

public class RegisterButton extends Button {

    private final RegistrationPanelView view;
    private final UserService userService = UserService.getInstance();

    private Label dialogLabel = new Label();
    private Dialog dialog = new Dialog(dialogLabel);

    public RegisterButton(RegistrationPanelView registrationPanelView) {
        view = registrationPanelView;

        dialog.setWidth("300px");
        dialog.setHeight("100px");

        addClickListener(e -> {
            if (isEmptyField()) {
                dialogLabel.setText("All fields must be completed!");
            } else if (!Encryptor.encrypt(view.getPasswordField().getValue())
                    .equals(Encryptor.encrypt(view.getConfirmPasswordField().getValue()))) {
                dialogLabel.setText("Password and it's confirmation are different!");
                dialog.open();
            } else if (!userService.isUsernameUnique(view.getUsernameField().getValue())) {
                dialogLabel.setText("Username " + view.getUsernameField().getValue() + " already exists!");
                dialog.open();
            } else if (view.getEmailField().isInvalid()) {
                dialogLabel.setText("Email address is invalid!");
                dialog.open();
            } else {
                UserToRegister user = new UserToRegister(
                        view.getFirstNameField().getValue(),
                        view.getLastNameField().getValue(),
                        view.getUsernameField().getValue(),
                        Encryptor.encrypt(view.getPasswordField().getValue()),
                        view.getEmailField().getValue(),
                        new GPSLocation(view.getLatitudeField().getValue(),
                                view.getLongitudeField().getValue()),
                        view.getSchedulerCheckbox().getValue()
                );

                if (userService.registerUser(user)) {
                    clearAllFields();
                    dialogLabel.setText("Registration complete! Now you can login and enjoy using wroclawhelper!");
                    dialog.open();
                } else {
                    dialogLabel.setText("Something went wrong and your profile isn't created! We're really sorry. " +
                            "Pleas, dont giv up, and try again latter");
                    dialog.open();
                }
            }
        });
    }

    private void clearAllFields() {
        view.getFirstNameField().clear();
        view.getLastNameField().clear();
        view.getUsernameField().clear();
        view.getPasswordField().clear();
        view.getEmailField().clear();
        view.getLatitudeField().clear();
        view.getLongitudeField().clear();
        view.getSchedulerCheckbox().clear();
    }

    private boolean isEmptyField() {
        return view.getFirstNameField().isEmpty() || view.getLastNameField().isEmpty()
                || view.getUsernameField().isEmpty() || view.getPasswordField().isEmpty()
                || view.getConfirmPasswordField().isEmpty() || view.getEmailField().isEmpty()
                || view.getLatitudeField().isEmpty() || view.getLongitudeField().isEmpty();
    }
}
