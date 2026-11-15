import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    private static int[] weights;
    private static int[] values;
    private static int[][] table;
    private static int computedCount = 0;

    public static int mfKnapsack(int i, int j) {
        if (table[i][j] < 0) {
            computedCount++;
            int value;
            if (j < weights[i]) {
                value = mfKnapsack(i - 1, j);
            } else {
                value = Math.max(mfKnapsack(i - 1, j),
                        values[i] + mfKnapsack(i - 1, j - weights[i]));
            }
            table[i][j] = value;
        }
        return table[i][j];
    }

    public static void main(String[] args) {
        weights = new int[]{0, 7, 3, 4, 5, 6, 2, 8, 4, 6};
        values = new int[]{0, 42, 12, 40, 25, 30, 19, 50, 28, 35};
        int itemCount = 9;
        int capacity = 25;

        table = new int[itemCount + 1][capacity + 1];
        for (int row = 0; row <= itemCount; row++) {
            for (int column = 0; column <= capacity; column++) {
                if (row == 0 || column == 0) {
                    table[row][column] = 0;
                } else {
                    table[row][column] = -1;
                }
            }
        }

        int maxValue = mfKnapsack(itemCount, capacity);
        System.out.println("物品数量：" + itemCount + "，背包容量：" + capacity);
        System.out.println("最大价值：" + maxValue);

        List<Integer> chosenItems = new ArrayList<>();
        int i = itemCount;
        int j = capacity;
        int totalWeight = 0;
        while (i > 0 && j > 0) {
            if (table[i][j] != table[i - 1][j]) {
                chosenItems.add(i);
                totalWeight += weights[i];
                j -= weights[i];
            }
            i--;
        }
        System.out.print("选中物品编号：");
        for (int index = chosenItems.size() - 1; index >= 0; index--) {
            System.out.print(chosenItems.get(index) + " ");
        }
        System.out.println();
        System.out.println("选中总重量：" + totalWeight);
        System.out.println("已计算状态数：" + computedCount + " / " + (itemCount * capacity));
    }
}
