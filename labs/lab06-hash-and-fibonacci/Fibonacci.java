public class Fibonacci {
    private static int multiplyCount = 0;

    public static long fibonacciLogN(int n) {
        multiplyCount = 0;
        if (n == 0) {
            return 0;
        }
        long[][] result = {{1, 0}, {0, 1}};
        long[][] base = {{1, 1}, {1, 0}};
        int exponent = n;

        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = matrixMultiply(result, base);
            }
            exponent >>= 1;
            if (exponent > 0) {
                base = matrixMultiply(base, base);
            }
        }
        return result[0][1];
    }

    private static long[][] matrixMultiply(long[][] first, long[][] second) {
        multiplyCount++;
        long[][] product = new long[2][2];
        for (int row = 0; row < 2; row++) {
            for (int column = 0; column < 2; column++) {
                product[row][column] = first[row][0] * second[0][column]
                        + first[row][1] * second[1][column];
            }
        }
        return product;
    }

    public static long fibonacciIterative(int n) {
        if (n == 0) {
            return 0;
        }
        long previous = 0;
        long current = 1;
        for (int i = 2; i <= n; i++) {
            long next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }

    public static long fibonacciNaive(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacciNaive(n - 1) + fibonacciNaive(n - 2);
    }

    public static void main(String[] args) {
        int[] testValues = {10, 20, 50, 90};
        for (int n : testValues) {
            long result = fibonacciLogN(n);
            System.out.println("F(" + n + ") = " + result + "，矩阵乘法次数：" + multiplyCount);
        }

        long naiveStart = System.nanoTime();
        long naiveResult = fibonacciNaive(30);
        long naiveTime = System.nanoTime() - naiveStart;

        long iterativeStart = System.nanoTime();
        long iterativeResult = fibonacciIterative(30);
        long iterativeTime = System.nanoTime() - iterativeStart;

        long matrixStart = System.nanoTime();
        long matrixResult = fibonacciLogN(30);
        long matrixTime = System.nanoTime() - matrixStart;

        System.out.println("F(30) 朴素递归：" + naiveResult + "，耗时 " + naiveTime / 1000000.0 + " ms");
        System.out.println("F(30) 迭代：" + iterativeResult + "，耗时 " + iterativeTime / 1000000.0 + " ms");
        System.out.println("F(30) 矩阵快速幂：" + matrixResult + "，耗时 " + matrixTime / 1000000.0 + " ms");
    }
}
