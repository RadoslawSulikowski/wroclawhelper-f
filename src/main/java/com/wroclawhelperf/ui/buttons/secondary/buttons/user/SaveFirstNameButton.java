package com.wroclawhelperf.ui.buttons.secondary.buttons.user;

import com.wroclawhelperf.service.UserService;
import com.wroclawhelperf.ui.MainView;
import com.wroclawhelperf.ui.buttons.abstrct.templates.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.views.UserPanelView;

import java.util.HashMap;
import java.util.Map;

public class SaveFirstNameButton extends SecondaryButtonAbstract {

    private final UserPanelView userPanelView;

    public SaveFirstNameButton(UserPanelView view) {
        super();
        userPanelView = view;

        setText("SAVE FIRST NAME");
        addClickListener(e -> {
            if (userPanelView.getFirstNameField().isEmpty()) {
                userPanelView.getDialogLabel().setText("First name cannot be empty!");
                userPanelView.getDialog().open();
            } else if (userPanelView.getFirstNameField().getValue().equals(userPanelView.getUser().getFirstName())) {
                userPanelView.getDialogLabel().setText("Cannot save - nothing changed!");
                userPanelView.getDialog().open();
            } else {
                Map<String, String> map = new HashMap<>();
                map.put("username", MainView.getLoggedUser());
                map.put("firstName", userPanelView.getFirstNameField().getValue());
                userPanelView.setUser(UserService.getInstance().updateUserProperty(map));
                userPanelView.getDialogLabel().setText("First name updated!");
                userPanelView.getDialog().open();
            }
        });
    }
}
