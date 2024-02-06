package jpa1;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DishDAO {
    private final EntityManagerFactory factory;

    public DishDAO() {
        this.factory = Persistence.createEntityManagerFactory("JPA_HW");

    }

    public void saveDishesArray(DishUnit[] dishes) {
        for (DishUnit dish : dishes) {
            saveDish(dish);
        }
    }

    public void saveDish(DishUnit dish) {
        EntityManager entityManager = factory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            entityManager.persist(dish);

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public DishUnit getRandomDish() {
        EntityManager entityManager = factory.createEntityManager();
        String jpql = "SELECT p FROM DishUnit p ORDER BY RAND()";
        TypedQuery<DishUnit> query = entityManager.createQuery(jpql, DishUnit.class);
        query.setMaxResults(1);
        List<DishUnit> resultList = query.getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }

    public List<DishUnit> getDishesByPriceRange(double minPrice, double maxPrice) {
        EntityManager entityManager = factory.createEntityManager();
        try {
            String jpql = "SELECT x FROM DishUnit x WHERE x.price BETWEEN :minPrice AND :maxPrice";
            TypedQuery<DishUnit> query = entityManager.createQuery(jpql, DishUnit.class);
            query.setParameter("minPrice", minPrice);
            query.setParameter("maxPrice", maxPrice);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public List<DishUnit> getDiscountDishes() {
        EntityManager entityManager = factory.createEntityManager();
        try {
            String jpql = "SELECT x FROM DishUnit x WHERE x.isDiscount = true";
            TypedQuery<DishUnit> query = entityManager.createQuery(jpql, DishUnit.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public List<DishUnit> getDishesByWeightLimit(double weightLimit) {
        double totalWeight = 0.0;
        List<DishUnit> dishes = new ArrayList<DishUnit>();
        while (true) {
            DishUnit dish = getRandomDish();
            totalWeight += dish.getWeight();
            if (totalWeight <= weightLimit) {
                dishes.add(dish);
            } else break;
        }
        return dishes;
    }
}
