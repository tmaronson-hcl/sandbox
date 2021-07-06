package com.hcl;

public class Widgets {

    private int weight;
    private Colors color;

    public Widgets(Colors color, int weight) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public Colors getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "WidgetsStream{" +
                "weight=" + weight +
                ", colors=" + color +
                '}';
    }
}
