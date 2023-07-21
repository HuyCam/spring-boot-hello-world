package com.example.springhelloworld.components;

public class BotHelper {


    private String name;
    private String function;
    public BotHelper(String name, String function) {
        this.name = name;
        this.function = function;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void talk() {
        System.out.println("Hello I'm " + this.name);
    }
}
