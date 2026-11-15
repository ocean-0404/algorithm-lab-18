import java.util.ArrayList;
import java.util.List;

public class Permutation {
    private static int permutationCount = 0;
    private static int operationCount = 0;

    public static void generate(int n) {
        permutationCount = 0;
        operationCount = 0;
        int[] value = new int[n];
        int[] direction = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = i + 1;
            direction[i] = -1;
        }
        printPermutation(value);

        while (true) {
            int mobileIndex = findLargestMobile(value, direction);
            if (mobileIndex == -1) {
                break;
            }
            int targetIndex = mobileIndex + direction[mobileIndex];
            swap(value, mobileIndex, targetIndex);
            swap(direction, mobileIndex, targetIndex);
            operationCount++;

            int movedValue = value[targetIndex];
            for (int i = 0; i < n; i++) {
                if (value[i] > movedValue) {
                    direction[i] = -direction[i];
                }
            }
            printPermutation(value);
        }
        System.out.println("总排列数：" + permutationCount);
        System.out.println("相邻交换次数：" + operationCount);
    }

    private static int findLargestMobile(int[] value, int[] direction) {
        int largestIndex = -1;
        for (int i = 0; i < value.length; i++) {
            int targetIndex = i + direction[i];
            if (targetIndex < 0 || targetIndex >= value.length) {
                continue;
            }
            if (value[targetIndex] < value[i]) {
                if (largestIndex == -1 || value[i] > value[largestIndex]) {
                    largestIndex = i;
                }
            }
        }
        return largestIndex;
    }

    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    private static void printPermutation(int[] value) {
        permutationCount++;
        System.out.print("第 " + permutationCount + " 个排列：");
        for (int i = 0; i < value.length; i++) {
            System.out.print(value[i]);
            if (i < value.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        generate(4);
    }
}
