package ru.mai.softwaredevelopment.client;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Login extends Application {
    private Label label;
    private VBox vBox;
    private Button button;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        GridPane gridPane = new GridPane();

        label = new Label("Username:");
        TextField username = new TextField();
        vBox = new VBox(label, username);
        gridPane.add(vBox, 0, 0);

        label = new Label("Password:");
        TextField password = new TextField();
        vBox = new VBox(label, password);
        gridPane.add(vBox, 0, 1);

        button = new Button("Enter data");
        gridPane.add(button, 0, 2);

        button.setOnMouseClicked(mouseEvent -> {
            try {
                URL url = new URL("http://localhost:3000/authorization/login");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type", "application/json");

                String requestBody = "{\"username\": \"" + username.getText() + "\", \"password\": \"" + password.getText() + "\"}";
                con.setDoOutput(true);
                OutputStream os = con.getOutputStream();
                os.write(requestBody.getBytes());
                os.flush();
                os.close();

                int responseCode = con.getResponseCode();
                System.out.println("Response code: " + responseCode);

                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println(requestBody);
                System.out.println(response);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        stage.setTitle("Registration");
        stage.setScene(new Scene(gridPane));
        stage.show();
    }
}
