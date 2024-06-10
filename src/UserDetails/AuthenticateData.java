/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserDetails;

import javafx.scene.control.Alert;

/**
 *
 * @author Tanya
 */
public class AuthenticateData {
        
    private String message = "";
    private Boolean hasError = false;
    
    public AuthenticateData(String userName, String password,String email){
        if (checkIfBlank(userName, password, email)){
            /*hasError = true;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(message);
            alert.showAndWait(); */
        }else{
            validateUserName(userName);
            validatePassword(password);
            validateEmail(email);
            if(!message.isBlank()){
                hasError = true;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(message);
                alert.showAndWait(); 
            }
        }
  

    }
    
    private boolean checkIfBlank(String userName,String password, String email){
        if (userName.isBlank() || password.isBlank() || email.isBlank() || userName.isEmpty() || password.isEmpty() || email.isEmpty()) {
            message+="Fields can't be empty\n";
            return true;
        }
        return false;
    }
    
    private void validateUserName(String userName){
        String pattern = "^[a-zA-Z0-9_]{4,}$";
        if (!userName.matches(pattern)){
            message+= """
                    Invalid username!\n
                    Username must contain\n
                    number/numbers\n 
                    letter/letters \n _ only\n""";
        }
    }
    
    private void validateEmail(String email){
       String pattern = "^(?=.*[a-zA-Z])([a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})$";
       if(!email.matches(pattern)){
           message+="Invalid email\n";
       }
    }
    
    private void validatePassword(String password){
        String passwordFormat = "^[a-zA-Z0-9!@#$%&*]{6,}$";
        if (!password.matches(passwordFormat)){
            message+="""
                     Password must contain: \n
                     1: at least 6 characters\n
                     2: contain at least one character\n
                     3. one number and one special character""";
        }
    }
    
    public boolean hasError(){return hasError;}
}
