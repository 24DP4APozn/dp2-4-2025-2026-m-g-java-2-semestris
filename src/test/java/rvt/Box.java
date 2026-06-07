package rvt;

import java.util.ArrayList;

public class Box implements Packable {
    private ArrayList<Packable> items;
    private double maxWeight;

    public Box(double capacity) {
        items = new ArrayList<>();
        maxWeight = capacity;
    }

    public void add(Packable item) {
        if (weight() + item.weight() <= maxWeight) {
            items.add(item);
        }
    }

    public double weight() {
        double totalWeight = 0;

        for (Packable item : items) {
            totalWeight = totalWeight + item.weight();
        }

        return totalWeight;
    }

    public String toString() {
        return "Box: " + items.size() + " items, total weight " + weight() + " kg";
    }
}