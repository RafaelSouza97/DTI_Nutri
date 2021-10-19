package DTINutri.Repository;

import DTINutri.Controller;
import DTINutri.Domain.*;
import org.junit.jupiter.api.Assertions;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

class Food_RepositoryTest {
    //Controller - Conjunto de objetos criados
    Controller controller = new Controller();

    Food_RepositoryTest() throws ParseException {
    }

    @org.junit.jupiter.api.Test
    void search_food_by_group_with_invalid_group_id() throws ParseException {
        //Verify if the informed id group is negative, if is, the system show a exception
        Assertions.assertThrows(Exception.class,() -> controller.getFoods().search_food_by_group(-1));
    }

    @org.junit.jupiter.api.Test
    void search_food_by_group_with_valid_group() throws Exception {
        List<Food> resultado_esperado = new ArrayList<Food>();
        //Verify if the list<object> has an object inside the position 0, if not, the system show a exception
        Assertions.assertThrows(Exception.class,() -> resultado_esperado.get(0));

        resultado_esperado.add(controller.getFoods().get_all_foods().get(6));
        //Verify if the list<object> has an object inside the position 0
        Assertions.assertNotNull(resultado_esperado.get(0));

        resultado_esperado.add(controller.getFoods().get_all_foods().get(7));
        Assertions.assertNotNull(resultado_esperado.get(1));

        resultado_esperado.add(controller.getFoods().get_all_foods().get(8));
        Assertions.assertNotNull(resultado_esperado.get(2));

        List<Food> resultado_obtido = controller.getFoods().search_food_by_group(2);

        //Verify if the method search the correct list of foods for each food group
        Assertions.assertIterableEquals(resultado_esperado, resultado_obtido);
    }
}