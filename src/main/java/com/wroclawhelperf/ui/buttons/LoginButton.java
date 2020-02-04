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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.ResourceAccessException;


public class LoginButton extends Button {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginButton.class);
    private MainView mainView;
    private Label dialogLabel = new Label();
    private Dialog dialog = new Dialog(dialogLabel);


    public LoginButton(MainView view) {
        mainView = view;
        setText("LOGIN!");

        dialog.setWidth("300px");
        dialog.setHeight("100px");

        addClickListener(e -> {
            try {
                TextField usernameField = mainView.getUsername();
                PasswordField passwordField = mainView.getPassword();
                String username = usernameField.getValue();
                String password = Encryptor.encrypt(passwordField.getValue());
                if (UserService.getInstance().verifyUser(new UserToVerify(username, password))) {
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
                    dialogLabel.setText("Wrong username or password");
                    dialog.open();
                }
            } catch (ResourceAccessException ioe) {
                LOGGER.error("Can not connect with api");
                dialogLabel.setText("Can not connect with api");
                dialog.open();
            }
        });
    }
}
