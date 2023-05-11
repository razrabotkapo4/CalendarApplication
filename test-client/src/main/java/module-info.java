module ru.mai.softwaredevelopment.client {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.mai.softwaredevelopment.client to javafx.fxml;
    exports ru.mai.softwaredevelopment.client;
}