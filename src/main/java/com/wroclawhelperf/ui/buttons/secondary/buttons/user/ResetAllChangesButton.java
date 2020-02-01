package com.wroclawhelperf.ui.buttons.secondary.buttons.user;

import com.wroclawhelperf.domain.User;
import com.wroclawhelperf.ui.buttons.abstrct.templates.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.views.UserPanelView;

public class ResetAllChangesButton extends SecondaryButtonAbstract {
    private final UserPanelView userPanelView;

    public ResetAllChangesButton(UserPanelView view) {
        super();
        userPanelView = view;

        setText("RESET ALL FIELDS");
        User user = userPanelView.getUser();
        addClickListener(e -> {
            userPanelView.getFirstNameField().setValue(user.getFirstName());
            userPanelView.getLastNameField().setValue(user.getLastName());
            userPanelView.getPasswordField().setValue("");
            userPanelView.getConfirmPasswordField().setValue("");
            userPanelView.getEmailField().setValue(user.getEmail());
            userPanelView.getLatitudeField().setValue(user.getLocation().getLatitude());
            userPanelView.getLongitudeField().setValue(user.getLocation().getLongitude());
            userPanelView.getSchedulerCheckbox().setValue(user.isSchedulerOn());

            userPanelView.getDialogLabel().setText("All changes cleared");
            userPanelView.getDialog().open();
        });
    }
}