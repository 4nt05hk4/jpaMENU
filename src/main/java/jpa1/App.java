package jpa1;

import java.time.ZonedDateTime;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        DishDAO dishDAO = new DishDAO();

        DishUnit[] dishArray = Randomizer.getRandomDishArray(10);
        dishDAO.saveDishesArray(dishArray);

        System.out.println("Dishes By Price Range------------------------------------------");
        for (DishUnit dish : dishDAO.getDishesByPriceRange(40.00, 50.00)) {
            System.out.println(dish);
        }

        System.out.println("Discount Dishes------------------------------------------");
        for (DishUnit dish : dishDAO.getDiscountDishes()) {
            System.out.println(dish);
        }

        System.out.println("Dishes By WeightLimit------------------------------------------");
        for (DishUnit dish : dishDAO.getDishesByWeightLimit(200.00)) {
            System.out.println(dish);
        }
    }
}


