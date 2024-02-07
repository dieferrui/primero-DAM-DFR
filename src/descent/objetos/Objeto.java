package Descent.Objetos;

public class Objeto {
    
    protected String objectID;
    protected String name;
    protected String description;
    protected String type;
    protected int value;

    public Objeto(String objectID, String name, String description, String type, int value) {

        this.objectID = objectID;
        this.name = name;
        this.description = description;
        this.type = type;
        this.value = value;

    }
}
