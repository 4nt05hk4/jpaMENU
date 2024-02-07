package jpa1;

import java.util.Random;

public class Randomizer {
    public static DishUnit[] getRandomDishArray(int quantity) {
        DishUnit[] objectsArray = new DishUnit[quantity];

        for (int i = 0; i < objectsArray.length; i++) {
            objectsArray[i] = new DishUnit(getRandomDishName(), getRandomDouble(), getRandomDouble(), getRandomBoolean(), getRandomDiscount());
        }

        return objectsArray;
    }

    private static String getRandomDishName() {
        String[] adjectives = {"fried", "boiled", "salted", "spicy", "grilled", "roasted", "marinated", "baked", "smoked", "sauteed",
                "creamy", "crispy", "tangy", "savory", "zesty", "juicy", "tender", "flavorful", "hearty", "wholesome"};

        String[] nouns = {"fish", "eggs", "beef", "vegetables", "chicken", "pasta", "shrimp", "tofu", "rice", "potatoes",
                "salmon", "pork", "steak", "soup", "curry", "sandwich", "pizza", "stir-fry", "lasagna", "tacos"};

        Random random = new Random();
        String randomAdjective = adjectives[random.nextInt(adjectives.length)];
        String randomNoun = nouns[random.nextInt(nouns.length)];

        return randomAdjective + " " + randomNoun;
    }

    public static double getRandomDouble() {
        Random random = new Random();
        int randomInt = random.nextInt(4);
        int decimalValue = randomInt * 25;
        int randomNumber = 20 + random.nextInt(81);
        double randomPrice = randomNumber + (double) decimalValue / 100;

        return randomPrice;
    }

    public static boolean getRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public static int getRandomDiscount() {
        int[] availableDiscounts = {20, 30, 50, 80};
        Random random = new Random();
        int randomIndex = random.nextInt(availableDiscounts.length);
        int randomDiscount = availableDiscounts[randomIndex];

        return randomDiscount;
    }
}
