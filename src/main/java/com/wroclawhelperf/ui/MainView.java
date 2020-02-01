package com.wroclawhelperf.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.wroclawhelperf.ui.buttons.LoginButton;
import lombok.Getter;

@Getter
@Route
public class MainView extends HorizontalLayout {

    public static String loggedUser;

    private VerticalLayout leftPanel = new VerticalLayout();
    private VerticalLayout container = new VerticalLayout();
    private Label loginLabel = new Label();
    private TextField username = new TextField("username", "username");
    private PasswordField password = new PasswordField("password", "password");
    private Button loginButton = new LoginButton(this);
    private Label registerLabel = new Label();
    private Button registerButton = new Button();
    
    public MainView() {
        setContent();
    }

    private void setContent() {
        loginLabel.setText("Pleas log in:");
        registerLabel.setText("Or register");
        leftPanel.setWidth("10%");
        leftPanel.add(loginLabel, username, password, loginButton, registerLabel, registerButton);
        add(leftPanel, container);
    }

    public void reset() {
        leftPanel.removeAll();
        container.removeAll();
        removeAll();
        setContent();
    }

    public void setLoggedUser(String username) {
        loggedUser = username;
    }

    public String getLoggedUser() {
        return loggedUser;
    }
}
