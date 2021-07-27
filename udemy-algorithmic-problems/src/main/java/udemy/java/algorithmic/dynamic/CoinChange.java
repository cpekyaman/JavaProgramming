package udemy.java.algorithmic.dynamic;

class CoinChange {
    void solveDynamic(int totalAmount, int[] coins) {
        int[][] table = new int[coins.length + 1][totalAmount + 1];

        // if totalAmount is zero, we have solution : not taking any coin
        for(int row = 0; row < coins.length + 1;++row) {
            table[row][0] = 1;
        }

        for(int coin = 0; coin < coins.length;++coin) {
            for(int amount = 1; amount < totalAmount + 1;++amount) {
                //TODO: logic not clear
                if(coins[coin] <= amount) {
                    table[coin + 1][amount] = table[coin][amount] + table[coin + 1][amount - coins[coin]];
                } else {
                    table[coin + 1][amount] = table[coin][amount];
                }
            }
        }

        System.out.println(table[coins.length][totalAmount]);
    }

    int solveRecursive(int totalAmount, int[] coins, int index) {
        if (totalAmount <= 1) {
            return totalAmount;
        }

        if (coins.length == index) {
            return 0;
        }

        // take to current coin or go for next coin
        return solveRecursive(totalAmount - coins[index], coins, index) + solveRecursive(totalAmount, coins, index + 1);
    }
}
