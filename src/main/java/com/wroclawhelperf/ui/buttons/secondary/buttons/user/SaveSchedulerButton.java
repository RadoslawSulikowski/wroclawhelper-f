package com.wroclawhelperf.ui.buttons.secondary.buttons.user;

import com.wroclawhelperf.ui.buttons.abstrct.templates.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.views.UserPanelView;

public class SaveSchedulerButton extends SecondaryButtonAbstract {

    private final UserPanelView userPanelView;

    public SaveSchedulerButton(UserPanelView view) {
        super();
        userPanelView = view;

        setText("SAVE SCHEDULER SETTINGS");
    }
}
