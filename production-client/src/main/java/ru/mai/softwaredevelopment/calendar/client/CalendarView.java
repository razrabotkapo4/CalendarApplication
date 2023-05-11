package ru.mai.softwaredevelopment.calendar.client;

import javafx.scene.control.TextField;
import ru.mai.softwaredevelopment.calendar.client.controllers.AuthenticationController;
import ru.mai.softwaredevelopment.calendar.client.controllers.MainController;
import ru.mai.softwaredevelopment.calendar.client.modules.MonthlyCalendar;

import java.util.TimerTask;
import java.util.Timer;

public class CalendarView {
    private MainController mainController;
    private AuthenticationController authenticationController;

    public CalendarView() {
        mainController = MainController.getMainController();
    }

    public void displayCalendarHeader(String calendarHeader) {
        mainController.getMonthField().setText(calendarHeader);
    }

    public void displayCalendar(MonthlyCalendar monthlyCalendar) {
        mainController.getGridPane().add(monthlyCalendar, 0, 1);
    }

    public void displayNotesHeader(String notesHeader) {
        mainController.getNotesField().setText(notesHeader);
    }

    public void displayNotes(String notes) {
        mainController.getNotesDisplayField().setText(notes);
    }

    public void setNotesEnabled() {
        mainController.getNotesGroundField().setDisable(false);

        displayNotes("");
    }

    public void setNotesDisabled() {
        mainController.getNotesGroundField().setDisable(true);

        displayNotes("Select a date...");
        displayNotesHeader("Notes");
    }

    public void setCalendarEnabled(MonthlyCalendar monthlyCalendar) {
        monthlyCalendar.setDisable(false);

        displayNotes("");
    }

    public void setCalendarDisabled(MonthlyCalendar monthlyCalendar) {
        monthlyCalendar.setDisable(true);

        setNotesDisabled();
    }

    public void clearSignUpForm() {
        authenticationController = AuthenticationController.getAuthenticationController();


        TextField signInUsername = authenticationController.getSignUpUsername();
        TextField signInPassword = authenticationController.getSignUpPassword();
        TextField signInRepeatPassword = authenticationController.getSignUpRepeatPassword();

        signInUsername.setText("");
        signInPassword.setText("");
        signInRepeatPassword.setText("");

        signInUsername.setStyle("-fx-border-color: red");
        signInPassword.setStyle("-fx-border-color: red");
        signInRepeatPassword.setStyle("-fx-border-color: red");

        TimerTask task = new TimerTask() {
            public void run() {
                signInUsername.setStyle("-fx-border-color: none");
                signInPassword.setStyle("-fx-border-color: none");
                signInRepeatPassword.setStyle("-fx-border-color: none");
            }
        };

        long delay = 1000L;

        Timer timer = new Timer();
        timer.schedule(task, delay);
    }

    public void clearSignInForm() {
        authenticationController = AuthenticationController.getAuthenticationController();


        TextField signInUsername = authenticationController.getSignInUsername();
        TextField signInPassword = authenticationController.getSignInPassword();

        signInUsername.setText("");
        signInPassword.setText("");

        signInUsername.setStyle("-fx-border-color: red");
        signInPassword.setStyle("-fx-border-color: red");

        TimerTask task = new TimerTask() {
            public void run() {
                signInUsername.setStyle("-fx-border-color: none");
                signInPassword.setStyle("-fx-border-color: none");
            }
        };

        long delay = 1000L;

        Timer timer = new Timer();
        timer.schedule(task, delay);
    }

    public void setUsername(String username) {
        mainController.getUsernameField().setText(username);
    }
}
