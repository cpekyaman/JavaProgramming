package udemy.java.algorithmic.dynamic;

import java.util.List;

final class Knapsack {
    private final int itemCount;
    private final int weightCapacity;
    private final int[][] table;
    private final List<Item> items;

    Knapsack(int itemCount, int weightCapacity, List<Item> items) {
        this.itemCount = itemCount;
        this.weightCapacity = weightCapacity;
        this.items = items;
        this.table = new int[itemCount + 1][weightCapacity + 1];
    }

    void solve() {
        // s[it][w] = Math.max(s[it - 1][w], vit + s[it - 1][w - wit])
        for(int it = 1; it < itemCount + 1; ++it) {
            Item item = items.get(it);

            for(int w = 1; w < weightCapacity + 1; ++w) {
                int leaveItem = table[it - 1][w];
                int takeItem = 0;
                if(item.weight <= weightCapacity) {
                    takeItem = item.value + table[it - 1][w - item.weight];
                }

                table[it][w] = Math.max(takeItem, leaveItem);
            }
        }
    }

    private void show() {
        System.out.println("Total benefit is " + (table[itemCount] [weightCapacity]));
        for(int n = itemCount, w = weightCapacity; n > 0; --n) {
            // if benefit of current row is different than last one, take item
            if(table[n][w] != 0 && table[n][w] != table[n - 1][w]) {
                System.out.println("Taking item " + n);
                w = w - items.get(n).weight;
            }
        }
    }

    final class Item {
        private final int value;
        private final int weight;

        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }
}
