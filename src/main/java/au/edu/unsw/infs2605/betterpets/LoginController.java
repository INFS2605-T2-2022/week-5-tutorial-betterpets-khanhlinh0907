package au.edu.unsw.infs2605.betterpets;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author infs2605
 */

public class LoginController {
   
    Database database = new Database();
    
    // Declare FXML elements and add relevant imports
    // (Hint: implement and use the same IDs in the handleLoginButtonAction function)
    @FXML
    TextField usernameField;
    
    @FXML
    PasswordField passwordField;
    
    @FXML
    Label incorrectMessage;
    
    @FXML
    private void handleLoginButtonAction(ActionEvent event) throws IOException, SQLException {
        System.out.println("clicked login");
        // Check if username and password exist as a user in the database
        // (Hint: use a function in the Database class)
        String username = usernameField.getText();
        String password = passwordField.getText();
        try {
            database.setupDatabase();
        } catch (SQLException e) {
            System.out.println("data inserted");
        }
        
        boolean loginCheck = database.login(username, password);
        
        //System.out.println(loginCheck);
        // If the username and password are correct - move to the PetTable screen
        // Otherwise display text "Incorrect username or password"
        if (!loginCheck) {
            incorrectMessage.setVisible(true);
            incorrectMessage.setText("Incorrect username or password");
        }
        else {
            switchToPetTable();
        }
    }

    private void switchToPetTable() throws IOException {
        App.setRoot("petscreen");
    }
    
}
