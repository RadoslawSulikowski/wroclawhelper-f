package com.wroclawhelperf.ui.buttons.secondary.buttons.user;

import com.wroclawhelperf.ui.buttons.abstrct.templates.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.views.UserPanelView;

public class ChangePasswordButton extends SecondaryButtonAbstract {

    private final UserPanelView userPanelView;

    public ChangePasswordButton(UserPanelView view) {
        super();
        userPanelView = view;
        setText("CHANGE PASSWORD");

        addClickListener(e -> {
            userPanelView.reset();
            userPanelView.setContentChangePassword();
        });
    }

}
