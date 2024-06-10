/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginapplication;
import UserDetails.AuthenticateData;
import javafx.scene.image.Image;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
/**
 *
 * @author Tanya
 */
public class LoginPage extends BorderPane {
    
    private TextField userNameF;
    private PasswordField passwordF;
    private TextField emailF;
    private Scene newScene;
    
    public LoginPage(Stage primaryStage){
        loginUI(primaryStage);
    }
    
    public final void loginUI(Stage primaryStage){
        defaultButtons(primaryStage);
        GridPane contentPane = new GridPane();
        contentPane.setHgap(5);
        contentPane.setVgap(6);
        Image appLogo= new Image("file:src/Pictures/study co logo 2.png");
        ImageView imageView = new ImageView(appLogo);
        Label appName = new Label("Motions");
        appName.getStyleClass().add("label-appName");
        HBox appLabels = new HBox();
        appLabels.getChildren().addAll(imageView, appName);
        contentPane.add(appLabels, 0, 0, 2, 1);
        
        Label userNameL = new Label("Username:");
        userNameL.getStyleClass().add("label-general");
        contentPane.add(userNameL, 0, 4);
        userNameF = new TextField();
        userNameF.getStyleClass().add("textfields");
        contentPane.add(userNameF, 1, 4);
        
        Label passwordL = new Label("Password:");
        passwordL.getStyleClass().add("label-general");
        contentPane.add(passwordL, 0, 5);
        passwordF = new PasswordField();
        passwordF.getStyleClass().add("textfields");
        contentPane.add(passwordF, 1, 5);
        
        Label emailL = new Label("Email:");
        emailL.getStyleClass().add("label-general");
        contentPane.add(emailL, 0, 6);
        emailF = new TextField();
        emailF.getStyleClass().add("textfields");
        contentPane.add(emailF, 1, 6);
        
        Button signUpB = new Button("Sign Up");
        signUpB.setOnAction(e-> signUpBClicked(primaryStage));
        signUpB.getStyleClass().add("button-login");
        Button loginB = new Button("Login");
        loginB.getStyleClass().add("button-login");
        HBox loginButtons = new HBox(2);
        loginButtons.getChildren().addAll(signUpB, loginB);
        contentPane.add(loginButtons, 1, 10);
        contentPane.setAlignment(Pos.TOP_CENTER);
        setCenter(contentPane);
    }
    
    private void defaultButtons(Stage primaryStage){
        Button exitButton = new Button("\u00D7");
        exitButton.getStyleClass().add("exit-button");
        exitButton.setOnAction(e -> primaryStage.close());
        Button minimiseButton = new Button("\u2212");
        minimiseButton.getStyleClass().add("button-min");
        minimiseButton.setOnAction(e->primaryStage.setIconified(true));
        HBox defaultButtons = new HBox(7);
        defaultButtons.setAlignment(Pos.TOP_RIGHT);
        defaultButtons.getChildren().addAll(minimiseButton,exitButton);
        setTop(defaultButtons);
    }
    
    private void signUpBClicked(Stage primaryStage){
        String userName = userNameF.getText();
        String email = emailF.getText();
        String password = passwordF.getText();
        AuthenticateData auInput = new AuthenticateData(userName, password, email);
        if (!auInput.hasError()){
            writeData();
            MainPage mainpage = new MainPage(primaryStage);
            newScene = new Scene(mainpage, 400, 400);
            primaryStage.setScene(newScene);
            mainpage.GUI(primaryStage);
        }
    }
    
    private void writeData(){
        DatabaseOperations createTable = new DatabaseOperations();
    }
}
