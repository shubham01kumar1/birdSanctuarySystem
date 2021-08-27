package com.bl.birdsanctuary;

import java.util.Objects;

abstract public class Bird {

    enum Color{
        RED, WHITE, BLACK, GREY, GREEN, BLACK_WHITE
    }

    String id;
    Color color;
    String name;

    @Override
    public String toString() {
        return "Bird{" +
                "id='" + id + '\'' +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bird)) return false;
        Bird bird = (Bird) o;
        return id.equals(bird.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    abstract public void fly();

    abstract public void swim();

    abstract public void eat();
}
