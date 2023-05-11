package ru.mai.softwaredevelopment.calendar.client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.mai.softwaredevelopment.calendar.client.CalendarModel;

public class AuthenticationController {
    private static AuthenticationController authenticationController;
    private CalendarModel calendarModel;

    @FXML
    private Button signInCancelButton;

    @FXML
    private Button signInOkButton;

    @FXML
    private TextField signInPassword;

    @FXML
    private TextField signInUsername;

    @FXML
    private Button signUpCancelButton;

    @FXML
    private Button signUpOkButton;

    @FXML
    private TextField signUpPassword;

    @FXML
    private TextField signUpRepeatPassword;

    @FXML
    private TextField signUpUsername;

    @FXML
    private void initialize() {
        authenticationController = this;
        calendarModel = MainController.getCalendarModel();
    }

    @FXML
    void onSignInCancelButtonAction(ActionEvent event) {
        calendarModel.cancelAuthentication();
    }

    @FXML
    void onSignInOkButtonAction(ActionEvent event) {
        calendarModel.signIn();
    }

    @FXML
    void onSignUpCancelButtonAction(ActionEvent event) {
        calendarModel.cancelAuthentication();
    }

    @FXML
    void onSignUpOkButtonAction(ActionEvent event) {
        calendarModel.signUp();
    }

    public static AuthenticationController getAuthenticationController() {
        return authenticationController;
    }

    public TextField getSignInPassword() {
        return signInPassword;
    }

    public TextField getSignInUsername() {
        return signInUsername;
    }

    public TextField getSignUpPassword() {
        return signUpPassword;
    }

    public TextField getSignUpRepeatPassword() {
        return signUpRepeatPassword;
    }

    public TextField getSignUpUsername() {
        return signUpUsername;
    }
}
