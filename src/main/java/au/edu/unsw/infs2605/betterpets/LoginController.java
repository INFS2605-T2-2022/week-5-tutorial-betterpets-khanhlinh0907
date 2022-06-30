package au.edu.unsw.infs2605.betterpets;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 * @author infs2605
 */
public class LoginController {
    
    Database database = new Database();
    
    // Declare FXML elements and add relevant imports
    // (Hint: implement and use the same IDs in the handleLoginButtonAction function)

    @FXML
    private void handleLoginButtonAction(ActionEvent event) throws IOException, SQLException {
        System.out.println("clicked login");
        // Check if username and password exist as a user in the database
        // (Hint: use a function in the Database class)

        // If the username and password are correct - move to the PetTable screen
        // Otherwise display text "Incorrect username or password"
    }

    private void switchToPetTable() throws IOException {
        App.setRoot("petscreen");
    }
    
}
