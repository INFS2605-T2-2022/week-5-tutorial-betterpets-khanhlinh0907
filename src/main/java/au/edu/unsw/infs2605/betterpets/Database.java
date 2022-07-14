package au.edu.unsw.infs2605.betterpets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author infs2605
 */
public class Database {
    final private String database= "jdbc:sqlite:PetDatabase.db";
    
    public void setupDatabase() throws SQLException {
        // Connect to Database 
        Connection conn = DriverManager.getConnection(database);
        Statement st = conn.createStatement();
        
        // Create Users table, with id, username, and password fields
        String createUserTable = "CREATE TABLE Users"
                + "(userID INTEGER PRIMARY KEY"
                + ", username TEXT NOT NULL"
                + ", password TEXT NOT NULL"
                + ")";
        st.execute(createUserTable);
        
        // Insert a user account
        String insertUser = "INSERT INTO Users(userID, username, password)"
                + "VALUES (1001, 'khanhlinh0907', 'nhatminh')";
        st.execute(insertUser);
        
        // Create Pets Table, with id, name, species, colour, and owner fields
        String createPetTable = "CREATE TABLE PETS"
                + "(id INTEGER PRIMARY KEY AUTOINCREMENT"
                + ", name TEXT NOT NULL"
                + ", species TEXT NOT NULL"
                + ", colour TEXT NOT NULL"
                + ", owner TEXT NOT NULL"
                + ")";
        st.execute(createPetTable);

        // Insert some pets into this table
        insertPets();
        
        // Close connections and statements
        st.close();
        conn.close();
    }
    
    public void insertPets() throws SQLException{
        //create connection
        Connection conn = DriverManager.getConnection(database);
        //create statement	
        Statement st = conn.createStatement();

        //write the SQL query and the java code to insert all four pets
        PreparedStatement pSt = conn.prepareStatement(
            "INSERT OR IGNORE INTO PETS (id, name, species, colour, owner) VALUES (?,?,?,?,?)"
        );
        
        // Data to insert
        String[] names = {"Kitty", "Bunchy", "Mimi", "QuackyMooMoo"};
        String[] species = {"cat", "cat", "frog", "dog"};
        String[] colour = {"grey", "white", "green", "brown"};
        String[] owner = {"Andrew", "Lenny", "Hatherine", "Phoebe"};

        // Loop to insert via sanitised prepared statements
        for (int i = 0; i < 4; i++) {
            pSt.setInt(1, i);
            pSt.setString(2, names[i]);
            pSt.setString(3, species[i]);
            pSt.setString(4, colour[i]);
            pSt.setString(5, owner[i]);
            pSt.executeUpdate();
        }
        
        st.close();
        conn.close();
    }
    
    public boolean login(String username, String password) throws SQLException {
        Connection conn = DriverManager.getConnection(database);
        //Statement st = conn.createStatement();
        PreparedStatement pst = conn.prepareStatement(
            "SELECT * FROM Users WHERE USERNAME = ? AND PASSWORD = ?"
        );
        pst.setString(1, username);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            pst.close();
            conn.close();
            return true;
        }
            pst.close();
            conn.close();
        return false; 
    }
    
    public ObservableList<Pet> getPets() throws SQLException {
        // Get ResultSet of all pets that exist in the database
        Connection conn = DriverManager.getConnection(database);
        Statement st = conn.createStatement();
        String query = "SELECT id, name, species, colour, owner FROM PETS";
        ResultSet rs = st.executeQuery(query);
        ObservableList<Pet> petsList = FXCollections.observableArrayList();
        // Add each row in the ResultSet to the petsList
        while (rs.next()) {
            petsList.add(new Pet(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5)));
        }
        
        // Close 
        st.close();
        conn.close();
        return petsList;
        
    }
}
