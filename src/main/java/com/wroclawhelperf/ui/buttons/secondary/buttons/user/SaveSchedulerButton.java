package com.wroclawhelperf.ui.buttons.secondary.buttons.user;

import com.wroclawhelperf.service.UserService;
import com.wroclawhelperf.ui.MainView;
import com.wroclawhelperf.ui.buttons.abstrct.templates.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.views.UserPanelView;

import java.util.HashMap;
import java.util.Map;

public class SaveSchedulerButton extends SecondaryButtonAbstract {

    private final UserPanelView userPanelView;

    public SaveSchedulerButton(UserPanelView view) {
        super();
        userPanelView = view;

        setText("SAVE SCHEDULER SETTINGS");
        addClickListener(e -> {
            if (userPanelView.getSchedulerCheckbox().getValue().equals(userPanelView.getUser().isSchedulerOn())) {
                userPanelView.getDialogLabel().setText("Cannot save - nothing changed!");
                userPanelView.getDialog().open();
            } else {
                Map<String, String> map = new HashMap<>();
                map.put("username", MainView.getLoggedUser());
                map.put("schedulerOn", userPanelView.getSchedulerCheckbox().getValue().toString());
                userPanelView.setUser(UserService.getInstance().updateUserProperty(map));
                userPanelView.getDialogLabel().setText("Scheduler settings updated!");
                userPanelView.getDialog().open();
            }
        });
    }
}
