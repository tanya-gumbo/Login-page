/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginapplication;

import java.awt.Toolkit;
import java.awt.Rectangle;
import java.awt.Taskbar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Tanya
 */

public class MainPage extends BorderPane{
    
    public MainPage(Stage primaryStage){
        setBackground(primaryStage);
    }
    
    private void setBackground(Stage primaryStage){
        Image mainPage = new Image("file:src/Pictures/Background for app inspo.png");
        ImageView mainPageImage = new ImageView(mainPage);
        setCenter(mainPageImage);
    }
    
    public void GUI(Stage primaryStage){
        
        primaryStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight() - getTaskBarHeight());
        primaryStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
        primaryStage.setResizable(true);
        primaryStage.setFullScreen(true);
    }
    
    private double getTaskBarHeight(){
        // Get the screen bounds
        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenBounds = new Rectangle(0, 0, screenSize.width, screenSize.height);
        // Get the taskbar height
        double taskBarHeight = screenBounds.height - screenBounds.getHeight();
        return taskBarHeight;
    }
    
    
}
