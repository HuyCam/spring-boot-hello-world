package com.example.springhelloworld.components;

import lombok.Getter;

public class NutritionFacts {
    @Getter
    private final int servingSize;
    @Getter
    private final int servings;
    @Getter
    private final int calories;

    @Getter
    private final int fat;

    @Getter
    private final int sodium;

    public static class Builder {
        // Required parameters
        private final int servingSize;
        private final int servings;

        // Optional parameters - initialized to default values;
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;

        public Builder (int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories (int val) { calories = val; return this; }

        public Builder fat (int val) { fat = val; return this; }

        public Builder sodium(int val) { sodium = val; return this;}

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
    }


}
