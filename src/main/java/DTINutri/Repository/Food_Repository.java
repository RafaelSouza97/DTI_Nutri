package DTINutri.Repository;

import DTINutri.Domain.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public List<Food> search_food_by_group(int id_group) throws Exception{
        List<Food> group;

        if(id_group < 0){
            throw new Exception();
        }

        Collection<Food> collection = this.cad_foods;
        Stream<Food> result = collection.stream().filter(c -> c.getFood_group().getId_food_group() == id_group);

        group = result.collect(Collectors.toList());

        return group;
    }

}
