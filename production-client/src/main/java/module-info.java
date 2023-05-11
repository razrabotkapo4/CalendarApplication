module ru.mai.softwaredevelopment.calendar.client {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.mai.softwaredevelopment.calendar.client to javafx.fxml;
    exports ru.mai.softwaredevelopment.calendar.client;
    exports ru.mai.softwaredevelopment.calendar.client.controllers;
    opens ru.mai.softwaredevelopment.calendar.client.controllers to javafx.fxml;
}