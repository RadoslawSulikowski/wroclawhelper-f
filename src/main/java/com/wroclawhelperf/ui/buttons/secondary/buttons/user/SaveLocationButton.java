package com.wroclawhelperf.ui.buttons.secondary.buttons.user;

import com.wroclawhelperf.service.UserService;
import com.wroclawhelperf.ui.MainView;
import com.wroclawhelperf.ui.buttons.abstrct.templates.SecondaryButtonAbstract;
import com.wroclawhelperf.ui.views.UserPanelView;

import java.util.HashMap;
import java.util.Map;

public class SaveLocationButton extends SecondaryButtonAbstract {

    private final UserPanelView userPanelView;

    public SaveLocationButton(UserPanelView view) {
        super();
        userPanelView = view;

        setText("SAVE LOCATION");
        addClickListener(e -> {
            if (userPanelView.getLatitudeField().isEmpty() || userPanelView.getLongitudeField().isEmpty()) {
                userPanelView.getDialogLabel().setText("Latitude and longitude cannot be empty!");
                userPanelView.getDialog().open();
            } else if (userPanelView.getLatitudeField().getValue()
                    .equals(userPanelView.getUser().getLocation().getLatitude())
                    && userPanelView.getLongitudeField().getValue()
                    .equals(userPanelView.getUser().getLocation().getLongitude())) {
                userPanelView.getDialogLabel().setText("Cannot save - nothing changed!");
                userPanelView.getDialog().open();
            } else {
                Map<String, String> map = new HashMap<>();
                map.put("username", MainView.getLoggedUser());
                map.put("latitude", userPanelView.getLatitudeField().getValue().toString());
                map.put("longitude", userPanelView.getLongitudeField().getValue().toString());
                userPanelView.setUser(UserService.getInstance().updateUserProperty(map));
                userPanelView.getDialogLabel().setText("New Location saved!");
                userPanelView.getDialog().open();
            }
        });
    }
}
