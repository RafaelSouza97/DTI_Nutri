package DTINutri.Domain;

public class Restriction {
    private int id_restriction;
    private String name;

    public Restriction(int id_restriction, String name) {
        this.id_restriction = id_restriction;
        this.name = name;
    }

    public int getId_restriction() {
        return id_restriction;
    }

    public void setId_restriction(int id_restriction) {
        this.id_restriction = id_restriction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
