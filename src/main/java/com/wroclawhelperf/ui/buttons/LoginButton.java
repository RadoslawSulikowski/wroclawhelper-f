package com.wroclawhelperf.ui.buttons;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.wroclawhelperf.domain.UserToVerify;
import com.wroclawhelperf.encryptor.Encryptor;
import com.wroclawhelperf.service.UserService;
import com.wroclawhelperf.ui.MainView;
import com.wroclawhelperf.ui.views.Dashboard;

public class LoginButton extends Button {

    private MainView mainView;
    private final UserService userService = UserService.getInstance();

    public LoginButton(MainView view) {
        mainView = view;
        setText("LOGIN!");
        addClickListener(e -> {
            TextField usernameField = mainView.getUsername();
            PasswordField passwordField = mainView.getPassword();
            String username = usernameField.getValue();
            String password = Encryptor.encrypt(passwordField.getValue());
            Dialog dialog = new Dialog();

            dialog.add(new Label("Wrong username or password"));

            dialog.setWidth("300px");
            dialog.setHeight("100px");

            if (userService.verifyUser(new UserToVerify(username, password))) {
                mainView.setLoggedUser(username);
                Dashboard dashboard = new Dashboard(mainView);
                usernameField.setValue("");
                passwordField.setValue("");
                mainView.removeAll();
                mainView.add(dashboard.getLeftButtonPanel());
                mainView.add(dashboard.getContainer());
            } else {
                usernameField.setValue("");
                passwordField.setValue("");
                dialog.open();
            }
        });
    }
}
