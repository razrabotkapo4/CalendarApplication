package ru.mai.softwaredevelopment.calendar.client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.mai.softwaredevelopment.calendar.client.controllers.AuthenticationController;
import ru.mai.softwaredevelopment.calendar.client.controllers.MainController;
import ru.mai.softwaredevelopment.calendar.client.modules.MonthlyCalendar;
import ru.mai.softwaredevelopment.calendar.client.modules.User;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class CalendarModel {
    private MainController mainController;
    private AuthenticationController authenticationController;
    private CalendarView calendarView;
    private MonthlyCalendar monthlyCalendar;
    private User user;

    private Stage authenticationStage;
    private HashMap<Date, String> notesMap;
    private Date date;

    public CalendarModel() {
        mainController = MainController.getMainController();
        calendarView = new CalendarView();
        monthlyCalendar = new MonthlyCalendar();
    }

    public void initializeCalendar() {
        calendarView.displayCalendar(monthlyCalendar);
        calendarView.displayCalendarHeader(monthlyCalendar.getMonth() + " - " + monthlyCalendar.getYear());
    }

    public void initializeNotes() {
        calendarView.setCalendarEnabled(monthlyCalendar);

        for (Button button : monthlyCalendar.getButtons()) {
            if (!button.isDisable()) {
                button.setOnMouseClicked(mouseEvent -> {
                    calendarView.setNotesEnabled();
                    calendarView.displayNotesHeader("Notes: " + button.getText() + " " + monthlyCalendar.getMonth());

                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
                    try {
                        int month = Arrays.asList(MonthlyCalendar.getMonths()).indexOf(monthlyCalendar.getMonth());
                        date = simpleDateFormat.parse(button.getText() + "." + month + "."
                                + monthlyCalendar.getYear());
                    } catch (ParseException parseException) {
                        throw new RuntimeException(parseException);
                    }

                    calendarView.displayNotes(notesMap.get(date));

                    mainController.getSaveButton().setOnMouseClicked(mouseEvent1 -> {
                        notesMap.put(date, mainController.getNotesDisplayField().getText());
                        // Save to DB.
                    });
                    mainController.getDeleteButton().setOnMouseClicked(mouseEvent1 -> {
                        notesMap.remove(date);
                        // Delete from database.

                        calendarView.displayNotes("");
                    });
                });
            }
        }
    }

    public void prevMonth() {
        monthlyCalendar.prevMonth();
        calendarView.displayCalendarHeader(monthlyCalendar.getMonth() + " - " + monthlyCalendar.getYear());
        calendarView.setNotesDisabled();
    }

    public void nextMonth() {
        monthlyCalendar.nextMonth();
        calendarView.displayCalendarHeader(monthlyCalendar.getMonth() + " - " + monthlyCalendar.getYear());
        calendarView.setNotesDisabled();
    }

    public void initializeAuthentication() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("authentication-window.fxml"));
        authenticationStage = new Stage();
        Scene authenticationScene = new Scene(fxmlLoader.load());
        authenticationStage.setTitle("Authentication");
        authenticationStage.setScene(authenticationScene);
        authenticationStage.initModality(Modality.APPLICATION_MODAL);
        authenticationStage.showAndWait();
    }

    public void cancelAuthentication() {
        authenticationStage.close();
    }

    public void signUp() {
        authenticationController = AuthenticationController.getAuthenticationController();

        String signUpUsername = authenticationController.getSignUpUsername().getText();
        String signUpPassword = authenticationController.getSignUpPassword().getText();
        String signUpRepeatPassword = authenticationController.getSignUpRepeatPassword().getText();

        if (signUpPassword.equals(signUpRepeatPassword)) user = new User(signUpUsername, signUpPassword);
        if (user.signUp()) {
            notesMap = user.getNotes();

            initializeNotes();
            cancelAuthentication();

            calendarView.setUsername(user.getUsername());
        } else {
            calendarView.clearSignUpForm();
        }
    }

    public void signIn() {
        authenticationController = AuthenticationController.getAuthenticationController();

        String signInUsername = authenticationController.getSignInUsername().getText();
        String signInPassword = authenticationController.getSignInPassword().getText();

        user = new User(signInUsername, signInPassword);
        if (user.signIn()) {
            notesMap = user.getNotes();

            initializeNotes();
            cancelAuthentication();

            calendarView.setUsername(user.getUsername());
        } else {
            calendarView.clearSignInForm();
        }
    }

    public void logOut() {
        calendarView.setCalendarDisabled(monthlyCalendar);
        calendarView.setUsername("Authentication");

        user = null;
    }
}
