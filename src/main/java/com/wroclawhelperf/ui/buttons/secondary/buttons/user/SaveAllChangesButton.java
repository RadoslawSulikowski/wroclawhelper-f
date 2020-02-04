package com.wroclawhelperf.ui.buttons.secondary.buttons.user;

import com.wroclawhelperf.domain.GPSLocation;
import com.wroclawhelperf.domain.User;
import com.wroclawhelperf.service.UserService;
import com.wroclawhelperf.ui.MainView;
import com.wroclawhelperf.ui.buttons.abstrct.templates.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.views.UserPanelView;

public class SaveAllChangesButton extends SecondaryButtonAbstract {

    private final UserPanelView userPanelView;

    public SaveAllChangesButton(UserPanelView view) {
        super();
        userPanelView = view;

        setText("SAVE ALL CHANGES");
        addClickListener(e -> {
            if (ifIsEmptyField()) {
                userPanelView.getDialogLabel().setText("There are empty fields!");
                userPanelView.getDialog().open();
            } else if (userPanelView.getEmailField().isInvalid()) {
                userPanelView.getDialogLabel().setText("Email address is invalid!");
                userPanelView.getDialog().open();
            } else if (ifNothingChanged()) {
                userPanelView.getDialogLabel().setText("Cannot save - nothing changed!");
                userPanelView.getDialog().open();
            } else {
                userPanelView.setUser(UserService.getInstance().updateUser(new User(
                        userPanelView.getFirstNameField().getValue(),
                        userPanelView.getLastNameField().getValue(),
                        MainView.getLoggedUser(),
                        userPanelView.getEmailField().getValue(),
                        new GPSLocation(
                                userPanelView.getLatitudeField().getValue(),
                                userPanelView.getLongitudeField().getValue()),
                        userPanelView.getSchedulerCheckbox().getValue()
                )));
                userPanelView.getDialogLabel().setText("Changes saved correctly");
                userPanelView.getDialog().open();
            }
        });
    }

    private boolean ifNothingChanged() {
        return userPanelView.getEmailField().getValue().equals(userPanelView.getUser().getEmail())
                && userPanelView.getFirstNameField().getValue().equals(userPanelView.getUser().getFirstName())
                && userPanelView.getLastNameField().getValue().equals(userPanelView.getUser().getLastName())
                && userPanelView.getLatitudeField().getValue()
                .equals(userPanelView.getUser().getLocation().getLatitude())
                && userPanelView.getLongitudeField().getValue()
                .equals(userPanelView.getUser().getLocation().getLongitude())
                && userPanelView.getSchedulerCheckbox().getValue().equals(userPanelView.getUser().isSchedulerOn());
    }

    private boolean ifIsEmptyField() {
        return userPanelView.getFirstNameField().isEmpty() || userPanelView.getLastNameField().isEmpty()
                || userPanelView.getEmailField().isEmpty() || userPanelView.getLatitudeField().isEmpty()
                || userPanelView.getLongitudeField().isEmpty();
    }
}
