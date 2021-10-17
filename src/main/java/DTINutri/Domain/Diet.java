package DTINutri.Domain;

public class Diet {
    private int id_diet;
    private Food first_option;
    private Food second_option;
    private Food third_option;
    private double total_calories;

    public Diet(int id_diet, Food first_option, Food second_option, Food third_option, double total_calories) {
        this.id_diet = id_diet;
        this.first_option = first_option;
        this.second_option = second_option;
        this.third_option = third_option;
        this.total_calories = total_calories;
    }

    public int getId_diet() {
        return id_diet;
    }

    public void setId_diet(int id_diet) {
        this.id_diet = id_diet;
    }

    public Food getFirst_option() {
        return first_option;
    }

    public void setFirst_option(Food first_option) {
        this.first_option = first_option;
    }

    public Food getSecond_option() {
        return second_option;
    }

    public void setSecond_option(Food second_option) {
        this.second_option = second_option;
    }

    public Food getThird_option() {
        return third_option;
    }

    public void setThird_option(Food third_option) {
        this.third_option = third_option;
    }

    public double getTotal_calories() {
        return total_calories;
    }

    public void setTotal_calories(double total_calories) {
        this.total_calories = total_calories;
    }
}
