package task2;

import task2.base.Food;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Корзина
 *
 * @param <T> Еда
 */
public class Cart<T extends Food> {
    private String PROTEINS = "proteins";
    private String FATS = "fats";
    private String CARBOHYDRATES = "carbohydrates";
    private Balans balans = new Balans();

    /**
     * Товары в магазине
     */
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;

    public Cart(Class<T> clazz, UMarket market) {
        this.clazz = clazz;
        this.market = market;
        foodstuffs = new ArrayList<>();
    }

    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }

    /**
     * Распечатать список продуктов в корзине
     */
    public void printFoodstuffs() {
        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> {
            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                    index.getAndIncrement(), food.getName(),
                    food.getProteins() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "Нет",
                    food.getCarbohydrates() ? "Да" : "Нет");
        });
    }

    /**
     * Балансировка корзины
     */
    public void cardBalancing() {
        
        if(!balans.isBalansed()){
            System.out.println("Вывод корзины до балансировки");
            printFoodstuffs();

            foodstuffs.stream()
                    .forEach(food -> {
                        if (!balans.isProteins() && food.getProteins()) balans.setProteins(true);
                        else if (!balans.isFats() && food.getFats()) balans.setFats(true);
                        else balans.setCarbohydrares(true);
                    });

            market.getThings(Food.class).stream()
                    .forEach(food -> {
                        if (!balans.isProteins() && food.getProteins()) {
                            balans.setProteins(true);
                            foodstuffs.add((T)food);
                        }
                        else if (!balans.isFats() && food.getFats()) {
                            balans.setFats(true);
                            foodstuffs.add((T)food);
                        }
                        else if (!balans.isCarbohydrares() && food.getCarbohydrates()){
                            balans.setCarbohydrares(true);
                            foodstuffs.add((T)food);
                        }
                    });

//        foodstuffs.forEach(food -> {
//            if (!balans.get("proteins") && food.getProteins()) balans.put("proteins", true);
//            if (!balans.get("fats") && food.getProteins()) balans.put("fats", true);
//            if (!balans.get("carbohydrates") && food.getProteins()) balans.put("carbohydrates", true);
//        });

            if (!balans.isBalansed())
                System.out.println("Невозможно сбалансировать корзину по БЖУ.");

        } else {
            System.out.println("Корзина сбалансирована по БЖУ.");
        }




    }

}
