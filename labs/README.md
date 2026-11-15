# algorithm-lab-18

与课程大纲逐题对齐的算法实验代码库，每道题一个可独立编译运行的 Java 文件。

## 环境要求

- JDK 11 及以上
- 无需第三方依赖

## 目录结构

```
labs/lab01-topological-sort    DFS 拓扑排序
labs/lab02-permutation        Johnson-Trotter 全排列
labs/lab03-gray-code          二进制反射格雷码
labs/lab04-merge-sort         合并排序（统计比较次数）
labs/lab05-knapsack           记忆化自顶向下背包
labs/lab06-hash-and-fibonacci 开散列哈希表、矩阵快速幂斐波那契
```

## 快速开始

```bash
git clone https://github.com/ocean-0404/algorithm-lab-18.git
cd algorithm-lab-18/labs/lab01-topological-sort
javac -encoding UTF-8 *.java
java TopologicalSort
```

预期输出：

```
拓扑排序结果：0 -> 2 -> 4 -> 1 -> 3 -> 5
顶点访问次数：6
```

## 各实验预期输出

| 实验 | 运行类 | 预期结果 |
| --- | --- | --- |
| lab01 | TopologicalSort | 0 -> 2 -> 4 -> 1 -> 3 -> 5，访问 6 次 |
| lab02 | Permutation | 24 个排列，23 次相邻交换 |
| lab03 | GrayCode | 3 位 8 个、4 位 16 个，相邻校验通过 |
| lab04 | MergeSort | 1 2 3 6 8 9 19 29，比较 14 次 |
| lab05 | Knapsack | 最大价值 179，计算 109 / 225 个状态 |
| lab06 | HashTable、Fibonacci | Found / Not Found / Found；F(90)=2880067194370816120 |

## 许可证

MIT License
