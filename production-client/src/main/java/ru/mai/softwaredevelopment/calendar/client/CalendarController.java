package ru.mai.softwaredevelopment.calendar.client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CalendarController {
    private static CalendarController calendarController;
    private CalendarModel calendarModel;

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

    public static CalendarController getCalendarController() {
        return calendarController;
    }

    @FXML
    private void initialize() {
        calendarController = this;
        calendarModel = new CalendarModel();
        calendarModel.initializeCalendar();
    }

    @FXML
    private void onUsernameFieldMouseClicked() {

    }

    @FXML
    private void onLogOutButtonMouseClicked() {

    }

    @FXML
    private void onPrevMonthButtonAction() {
        calendarModel.prevMonth();
    }

    @FXML
    private void onNextMonthButtonAction() {
        calendarModel.nextMonth();
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
