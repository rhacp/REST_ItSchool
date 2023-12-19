package com.andrei.rest.utils.designpatterns;

import lombok.Builder;

public class BuilderExample {

    public static void main(String[] args) {
        Meal meal = new Meal.Builder()
                .mainCourse("main course description")
                .drink("pepsi")
                .side("cheesecake")
                .build();

        SecondMeal secondMeal = new SecondMeal.SecondMealBuilder()
                .mainCourse("description")
                .drink("description drink")
                .side("description side")
                .build();
    }
}

@Builder
class SecondMeal {

    private String mainCourse;
    private String drink;
    private String side;
}

class Meal {

    private String mainCourse;
    private String drink;
    private String side;

    private Meal(Builder builder) {
        this.mainCourse = builder.mainCourse;
        this.drink = builder.drink;
        this.side = builder.side;
    }

    public static class Builder {

        private String mainCourse;
        private String drink;
        private String side;

        public Builder mainCourse(String mainCourse) {
            this.mainCourse = mainCourse;
            return this;
        }

        public Builder drink(String drink) {
            this.drink = drink;
            return this;
        }

        public Builder side(String side) {
            this.side = side;
            return this;
        }

        public Meal build() {
            return new Meal(this);
        }
    }
}
