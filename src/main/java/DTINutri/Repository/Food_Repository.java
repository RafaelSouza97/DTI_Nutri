package DTINutri.Repository;

import DTINutri.Domain.Food;

import java.util.ArrayList;
import java.util.List;

public class Food_Repository {
    private List<Food> cad_foods;

    public Food_Repository() {
        this.cad_foods = new ArrayList<Food>();
    }

    public List<Food> get_all_foods() {
        return cad_foods;
    }

    public void insert_food(Food food) {
        this.cad_foods.add(food);
    }
}
