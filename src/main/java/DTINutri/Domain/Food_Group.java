package DTINutri.Domain;

public class Food_Group {
    private int id_food_group;
    private String name;

    public Food_Group(int id_food_group, String name) {
        this.id_food_group = id_food_group;
        this.name = name;
    }

    public int getId_food_group() {
        return id_food_group;
    }

    public void setId_food_group(int id_food_group) {
        this.id_food_group = id_food_group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
