package com.wroclawhelperf.ui.buttons.secondary.buttons.user;

import com.wroclawhelperf.service.UserService;
import com.wroclawhelperf.ui.MainView;
import com.wroclawhelperf.ui.buttons.abstrct.templates.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.views.UserPanelView;

import java.util.HashMap;
import java.util.Map;

public class SaveLastNameButton extends SecondaryButtonAbstract {

    private final UserPanelView userPanelView;

    public SaveLastNameButton(UserPanelView view) {
        super();
        userPanelView = view;

        setText("SAVE LAST NAME");
        addClickListener(e -> {
            if (userPanelView.getLastNameField().isEmpty()) {
                userPanelView.getDialogLabel().setText("Last name cannot be empty!");
                userPanelView.getDialog().open();
            } else if (userPanelView.getLastNameField().getValue().equals(userPanelView.getUser().getLastName())) {
                userPanelView.getDialogLabel().setText("Cannot save - nothing changed!");
                userPanelView.getDialog().open();
            } else {
                Map<String, String> map = new HashMap<>();
                map.put("username", MainView.getLoggedUser());
                map.put("lastName", userPanelView.getLastNameField().getValue());
                userPanelView.setUser(UserService.getInstance().updateUserProperty(map));
                userPanelView.getDialogLabel().setText("Last name updated!");
                userPanelView.getDialog().open();
            }
        });
    }
}
