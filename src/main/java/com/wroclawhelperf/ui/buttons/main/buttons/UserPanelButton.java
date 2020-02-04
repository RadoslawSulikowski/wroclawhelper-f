package com.wroclawhelperf.ui.buttons.main.buttons;

import com.vaadin.flow.component.button.Button;
import com.wroclawhelperf.ui.buttons.abstrct.templates.MainButtonAbstract;
import com.wroclawhelperf.ui.buttons.secondary.buttons.user.ChangePasswordButton;
import com.wroclawhelperf.ui.buttons.secondary.buttons.user.PersonalDataButton;
import com.wroclawhelperf.ui.views.Dashboard;
import com.wroclawhelperf.ui.views.UserPanelView;

public final class UserPanelButton extends MainButtonAbstract {

    private final Dashboard dashboard;

    public UserPanelButton(Dashboard d) {
        super();
        dashboard = d;
        setText("USER PANEL");

        UserPanelView userPanelView = new UserPanelView(dashboard);
        Button personalDataButton = new PersonalDataButton(userPanelView);
        Button changePasswordButton = new ChangePasswordButton(userPanelView);

        addClickListener(e -> {
            dashboard.reset();
            userPanelView.reset();
            dashboard.getHeading().setText("USER PANEL");
            dashboard.getSecondaryButtonPanel()
                    .add(personalDataButton, changePasswordButton);
            dashboard.getContainer().add(userPanelView);
        });
    }
}