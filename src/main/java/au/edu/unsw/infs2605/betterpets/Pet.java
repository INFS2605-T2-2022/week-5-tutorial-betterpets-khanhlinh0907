package au.edu.unsw.infs2605.betterpets;

/**
 *
 * @author infs2605
 */
public class Pet {
    // Attributes of Pet
    protected int id;
    protected String name;
    protected String species;
    protected String colour;
    protected String owner;

    // Create a constructor for a Pet class
    public Pet (int id, String name, String species, String colour, String owner) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.colour = colour;
        this.owner = owner;
    }
    
    // Create getters and setters for a Pet class
    // id
    public void setID(int id) {
        this.id = id;
    }
    
    public int getID() {
        return this.id;
    }
    
    // name
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    // species
    public void setSpecies(String species) {
        this.species = species;
    }
    
    public String getSpecies() {
        return this.species;
    }  
    
    // colour
    public void setColour(String colour) {
        this.colour = colour;
    }
    
    public String getColour() {
        return this.colour;
    }
    
    // owner
    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    public String getOwner() {
        return this.owner;
    }
}
