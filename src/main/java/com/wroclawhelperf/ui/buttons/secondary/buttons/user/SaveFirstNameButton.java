package com.wroclawhelperf.ui.buttons.secondary.buttons.user;

import com.wroclawhelperf.ui.buttons.abstrct.templates.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.views.UserPanelView;

public class SaveFirstNameButton extends SecondaryButtonAbstract {
    private final UserPanelView userPanelView;

    public SaveFirstNameButton(UserPanelView view) {
        super();
        userPanelView = view;

        setText("SAVE FIRST NAME");
    }
}
