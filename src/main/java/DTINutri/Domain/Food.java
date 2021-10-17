package DTINutri.Domain;

import java.util.ArrayList;
import java.util.List;

public class Food {
    private int id_food;
    private String name;
    private double calories;
    private Food_Group food_group;
    private List<Restriction> restrictions;

    public Food(int id_food, String name, double calories, Food_Group food_group) {
        this.id_food = id_food;
        this.name = name;
        this.calories = calories;
        this.food_group = food_group;
        this.restrictions = new ArrayList<Restriction>();
    }

    public int getId_food() {
        return id_food;
    }

    public void setId_food(int id_food) {
        this.id_food = id_food;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public Food_Group getFood_group() {
        return food_group;
    }

    public void setFood_group(Food_Group food_group) {
        this.food_group = food_group;
    }

    public List<Restriction> getRestrictions() {
        return restrictions;
    }

    public void insertRestriction(Restriction restriction) {
        this.restrictions.add(restriction);
    }
}
