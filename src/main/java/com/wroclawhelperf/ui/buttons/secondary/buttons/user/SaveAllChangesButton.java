package com.wroclawhelperf.ui.buttons.secondary.buttons.user;

import com.wroclawhelperf.domain.GPSLocation;
import com.wroclawhelperf.domain.User;
import com.wroclawhelperf.service.UserService;
import com.wroclawhelperf.ui.MainView;
import com.wroclawhelperf.ui.buttons.abstrct.templates.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.views.UserPanelView;

public class SaveAllChangesButton extends SecondaryButtonAbstract {

    private final UserPanelView userPanelView;
    private final UserService userService = UserService.getInstance();

    public SaveAllChangesButton(UserPanelView view) {
        super();
        userPanelView = view;

        setText("SAVE ALL CHANGES");
        addClickListener(e -> {
            if (userPanelView.getFirstNameField().isEmpty() || userPanelView.getLastNameField().isEmpty()
                    || userPanelView.getPasswordField().isEmpty() || userPanelView.getEmailField().isEmpty()
                    || userPanelView.getLatitudeField().isEmpty() || userPanelView.getLongitudeField().isEmpty()) {
                userPanelView.getDialogLabel().setText("There are empty fields");
                userPanelView.getDialog().open();
            } else if (!userPanelView.getPasswordField().getValue()
                    .equals(userPanelView.getConfirmPasswordField().getValue())) {
                userPanelView.getDialogLabel().setText("Password and it's confirmation are different!");
                userPanelView.getDialog().open();
            } else {
                userService.updateUser(new User(
                        userPanelView.getFirstNameField().getValue(),
                        userPanelView.getLastNameField().getValue(),
                        MainView.getLoggedUser(),
                        userPanelView.getPasswordField().getValue(),
                        userPanelView.getEmailField().getValue(),
                        new GPSLocation(
                                userPanelView.getLatitudeField().getValue(),
                                userPanelView.getLongitudeField().getValue()),
                        userPanelView.getSchedulerCheckbox().getValue()
                ));
                userPanelView.getDialogLabel().setText("Changes saved correctly");
                userPanelView.getDialog().open();
            }
        });
    }
}
