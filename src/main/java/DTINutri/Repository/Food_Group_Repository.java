package DTINutri.Repository;

import DTINutri.Domain.Food_Group;

import java.util.ArrayList;
import java.util.List;

public class Food_Group_Repository {
    private List<Food_Group> cad_food_groups;

    public Food_Group_Repository() {
        this.cad_food_groups = new ArrayList<Food_Group>();
    }

    public List<Food_Group> get_all_Food_Groups() {
        return cad_food_groups;
    }

    public void insert_Food_Group(Food_Group food_group) {
        this.cad_food_groups.add(food_group);
    }
}
