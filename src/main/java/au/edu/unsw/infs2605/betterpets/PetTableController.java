package au.edu.unsw.infs2605.betterpets;

import java.sql.SQLException;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author infs2605
 */
public class PetTableController {
    
    Database database = new Database();
    
    @FXML
    TableView<Pet> petTbl;
    
    @FXML
    TableColumn<Pet, String> nameCol;
    
    @FXML
    TableColumn<Pet, String> speciesCol;
    
    @FXML
    TableColumn<Pet, String> colourCol;
    
    @FXML
    TableColumn<Pet, String> ownerCol;
    
    
    @FXML
    public void initialize() throws SQLException {
        // Get a list of all of pets in the database
        ObservableList<Pet> petsList = database.getPets();
        
        // Set this list into the TableView
        petTbl.setItems(petsList);
        
        // Set all the columns in to tableview columns
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        speciesCol.setCellValueFactory(new PropertyValueFactory("species"));
        colourCol.setCellValueFactory(new PropertyValueFactory("colour"));
        ownerCol.setCellValueFactory(new PropertyValueFactory("owner"));
    }
    
}
