package ru.mai.softwaredevelopment.calendar.client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import ru.mai.softwaredevelopment.calendar.client.CalendarModel;

import java.io.IOException;

public class MainController {
    private static MainController mainController;
    private static CalendarModel calendarModel;

    @FXML
    private Button deleteButton;

    @FXML
    private GridPane gridPane;

    @FXML
    private ImageView logOutButton;

    @FXML
    private Label monthField;

    @FXML
    private Button nextMonthButton;

    @FXML
    private TextArea notesDisplayField;

    @FXML
    private Label notesField;

    @FXML
    private VBox notesGroundField;

    @FXML
    private Button prevMonthButton;

    @FXML
    private Button saveButton;

    @FXML
    private ImageView userimageField;

    @FXML
    private Label usernameField;

    @FXML
    private void initialize() {
        mainController = this;
        calendarModel = new CalendarModel();
        calendarModel.initializeCalendar();
    }

    @FXML
    void onLogOutButtonMouseClicked(MouseEvent event) {
        calendarModel.logOut();
    }

    @FXML
    void onNextMonthButtonAction(ActionEvent event) {
        calendarModel.nextMonth();
    }

    @FXML
    void onPrevMonthButtonAction(ActionEvent event) {
        calendarModel.prevMonth();
    }

    @FXML
    void onUsernameFieldMouseClicked(MouseEvent event) {
        try {
            calendarModel.initializeAuthentication();
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }

    public static MainController getMainController() {
        return mainController;
    }

    public static CalendarModel getCalendarModel() {
        return calendarModel;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public ImageView getLogOutButton() {
        return logOutButton;
    }

    public Label getMonthField() {
        return monthField;
    }

    public Button getNextMonthButton() {
        return nextMonthButton;
    }

    public TextArea getNotesDisplayField() {
        return notesDisplayField;
    }

    public Label getNotesField() {
        return notesField;
    }

    public VBox getNotesGroundField() {
        return notesGroundField;
    }

    public Button getPrevMonthButton() {
        return prevMonthButton;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public ImageView getUserimageField() {
        return userimageField;
    }

    public Label getUsernameField() {
        return usernameField;
    }
}
