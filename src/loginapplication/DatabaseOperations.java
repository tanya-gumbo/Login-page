/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Alert;



/**
 *
 * @author Tanya
 */
public class DatabaseOperations {
    String errorMSG;
    
    public DatabaseOperations(){
        createTable();
    }
    private Connection createConnection(){
        Connection connection = null;
        try{
          connection = DriverManager.getConnection("jdbc:sqlite:UserData.db");
        }catch(SQLException e){
            errorMSG = e.getMessage() + "\n";
        }
        return connection;
    }
    private void createTable(){
        try{
            Connection cnnDB = createConnection();
            Statement createTable = cnnDB.createStatement();
            String query = "CREATE TABLE User_Data (User_Name TEXT PRIMARY KEY, Email Text, Password TEXT)";
            createTable.execute(query);
            createTable.close();
        }catch(SQLException e){
            errorMSG = e.getMessage() + "\n";
        }
    }
}
