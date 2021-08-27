package com.bl.birdsanctuary;

public class Ostrich extends Bird {
    public Ostrich() {
        color = Color.GREY;
        name = "ostrich";
    }

    @Override
    public void fly() {
    }

    @Override
    public void swim() {
    }

    @Override
    public void eat() {
        System.out.println(name + " can eat.");
    }
}
