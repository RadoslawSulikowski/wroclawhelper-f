package com.wroclawhelperf.ui.buttons.secondary.buttons.user;

import com.wroclawhelperf.ui.buttons.abstrct.templates.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.views.UserPanelView;

public class SaveLastNameButton extends SecondaryButtonAbstract {

    private final UserPanelView userPanelView;

    public SaveLastNameButton(UserPanelView view) {
        super();
        userPanelView = view;

        setText("SAVE LAST NAME");
    }
}
