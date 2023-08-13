package com.example.springhelloworld.subjects;

import com.example.springhelloworld.components.NutritionFacts;

public class ObjectCreationAndDestruction {
    public void simpleBuilder() {
        System.out.println("Build Nutrition fact");

        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).calories(100).sodium(35).build();

        System.out.println("Serving Size: " + cocaCola.getServingSize());
        System.out.println("Serving: " + cocaCola.getServings());
        System.out.println("Calories: " + cocaCola.getCalories());
        System.out.println("Sodium: " + cocaCola.getCalories());
    }
}

