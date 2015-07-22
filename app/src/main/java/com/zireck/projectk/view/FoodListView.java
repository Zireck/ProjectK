package com.zireck.projectk.view;

import com.zireck.projectk.model.Food;

import java.util.List;

/**
 * Created by Zireck on 22/07/2015.
 */
public interface FoodListView {
    public void setFoodItems(List<Food> foodItems);
    public int getCurrentTag();
    public int getFoodTag();
    public int getDrinkTag();
    public int getRecentTag();
}
