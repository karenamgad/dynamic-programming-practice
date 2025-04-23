/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package knapsackdp;

/**
 *
 * @author Karen Amgad
 */
public class KnapsackDP {


    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;

        // Create DP table
        int[][] dp = new int[n + 1][capacity + 1];

        // Build table in bottom-up manner
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                  
                    dp[i][w] = Math.max(
                        values[i - 1] + dp[i - 1][w - weights[i - 1]],
                        dp[i - 1][w]
                    );
                } else {
                    // Cannot include the item
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }


        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {1, 3, 4, 5};
        int[] values = {1500, 2000, 3000, 3500};
        int capacity = 7;

        int maxValue = knapsack(weights, values, capacity);
        System.out.println("Maximum value in knapsack: " + maxValue);
    }
}
