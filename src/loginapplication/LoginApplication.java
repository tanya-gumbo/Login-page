/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package loginapplication;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Tanya
 * Notes: This app is a tangled mess. There has to be a better way
 */
public class LoginApplication extends Application {
    Scene scene;
    @Override
    public void start(Stage primaryStage) {
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        LoginPage loginScene = new LoginPage(primaryStage); 
        scene = new Scene(loginScene, 600, 500);
        scene.getStylesheets().add(getClass().getResource("applicationStyles.css").toExternalForm());
        scene.getRoot().getStyleClass().add("scene");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
