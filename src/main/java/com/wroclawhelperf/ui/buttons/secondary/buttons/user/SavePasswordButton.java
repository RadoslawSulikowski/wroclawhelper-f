package com.wroclawhelperf.ui.buttons.secondary.buttons.user;

import com.wroclawhelperf.encryptor.Encryptor;
import com.wroclawhelperf.service.UserService;
import com.wroclawhelperf.ui.MainView;
import com.wroclawhelperf.ui.buttons.abstrct.templates.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.views.UserPanelView;

import java.util.HashMap;
import java.util.Map;

public class SavePasswordButton extends SecondaryButtonAbstract {

    private final UserPanelView userPanelView;

    public SavePasswordButton(UserPanelView view) {
        super();
        userPanelView = view;

        setText("SAVE PASSWORD");
        addClickListener(e -> {
            if (userPanelView.getPasswordField().isEmpty() || userPanelView.getConfirmPasswordField().isEmpty()) {
                userPanelView.getDialogLabel().setText("Both fields cannot be empty!");
                userPanelView.getDialog().open();
            } else if (!Encryptor.encrypt(userPanelView.getPasswordField().getValue())
                    .equals(Encryptor.encrypt(userPanelView.getConfirmPasswordField().getValue()))) {
                userPanelView.getDialogLabel().setText("Password and it's confirmation are different!");
                userPanelView.getDialog().open();
            } else {
                Map<String, String> map = new HashMap<>();
                map.put("username", MainView.getLoggedUser());
                map.put("password", Encryptor.encrypt(userPanelView.getPasswordField().getValue()));
                userPanelView.setUser(UserService.getInstance().updateUserProperty(map));
                userPanelView.getDialogLabel().setText("New password saved!");
                userPanelView.getDialog().open();
            }
        });
    }
}
