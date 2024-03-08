package algorithms.homework.hw3;

import java.util.ArrayList;
import java.util.List;

class Item {
    public int value;
    public int weight;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class Knapsack {
    public static void main(String[] args) {
        final int MAX_CAPACITY = 10;
        List<Item> items = new ArrayList<>();
        items.add(new Item(7,42));
        items.add(new Item(3,12));
        items.add(new Item(4,40));
        items.add(new Item(5,25));

        int maxValue = findMaxValue(items, MAX_CAPACITY);
        System.out.println("Maximum possible value: $" + maxValue);
    }

    public static int findMaxValue(List<Item> items, int MAX_CAPACITY) {
        int[][] knapsack = new int[items.size() + 1][MAX_CAPACITY + 1];

        for (int i = 1; i <= items.size(); i++) {
            int weight = items.get(i - 1).weight;
            int value = items.get(i - 1).value;

            for (int w = 1; w <= MAX_CAPACITY; w++) {
                if (weight <= w) {
                    knapsack[i][w] = Math.max(knapsack[i - 1][w], knapsack[i - 1][w - weight] + value);

                } else {
                    knapsack[i][w] = knapsack[i - 1][w];
                }
            }
            System.out.println("weight = " + weight + " value = " + value);
        }
        return knapsack[items.size()][MAX_CAPACITY];
    }
}


