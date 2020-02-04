package com.wroclawhelperf.ui.buttons.secondary.buttons.user;

import com.wroclawhelperf.ui.buttons.abstrct.templates.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.views.UserPanelView;

public class PersonalDataButton extends SecondaryButtonAbstract {

    private final UserPanelView userPanelView;


    public PersonalDataButton(UserPanelView view) {
        super();
        userPanelView = view;
        setText("PERSONAL DATA");

        addClickListener(e -> {
            userPanelView.reset();
            userPanelView.setContentPersonalData();
        });


    }
}
