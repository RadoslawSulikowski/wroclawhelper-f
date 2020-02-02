package com.wroclawhelperf.ui.buttons.secondary.buttons.user;

import com.wroclawhelperf.service.UserService;
import com.wroclawhelperf.ui.MainView;
import com.wroclawhelperf.ui.buttons.abstrct.templates.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.views.UserPanelView;

import java.util.HashMap;
import java.util.Map;

public class SaveEmailButton extends SecondaryButtonAbstract {

    private final UserPanelView userPanelView;

    public SaveEmailButton(UserPanelView view) {
        super();
        userPanelView = view;

        setText("SAVE EMAIL");
        addClickListener(e -> {
            if (userPanelView.getEmailField().isEmpty()) {
                userPanelView.getDialogLabel().setText("Email cannot be empty!");
                userPanelView.getDialog().open();
            } else if (userPanelView.getEmailField().isInvalid()) {
                userPanelView.getDialogLabel().setText("Email address is invalid!");
                userPanelView.getDialog().open();
            } else if (userPanelView.getEmailField().getValue().equals(userPanelView.getUser().getEmail())) {
                userPanelView.getDialogLabel().setText("Cannot save - nothing changed!");
                userPanelView.getDialog().open();
            } else {
                Map<String, String> map = new HashMap<>();
                map.put("username", MainView.getLoggedUser());
                map.put("email", userPanelView.getEmailField().getValue());
                userPanelView.setUser(UserService.getInstance().updateUserProperty(map));
                userPanelView.getDialogLabel().setText("Email address updated!");
                userPanelView.getDialog().open();
            }
        });
    }
}
