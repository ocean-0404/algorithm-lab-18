import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TopologicalSort {
    private static boolean[] visited;
    private static List<Integer> order;
    private static int visitCount = 0;

    public static List<Integer> sortByDfs(List<List<Integer>> graph) {
        int vertexCount = graph.size();
        visited = new boolean[vertexCount];
        order = new ArrayList<>();
        visitCount = 0;

        for (int v = 0; v < vertexCount; v++) {
            if (!visited[v]) {
                dfsVisit(graph, v);
            }
        }

        System.out.print("拓扑排序结果：");
        for (int i = 0; i < order.size(); i++) {
            System.out.print(order.get(i));
            if (i < order.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
        System.out.println("顶点访问次数：" + visitCount);
        return order;
    }

    private static void dfsVisit(List<List<Integer>> graph, int v) {
        visited[v] = true;
        visitCount++;
        for (int neighbor : graph.get(v)) {
            if (!visited[neighbor]) {
                dfsVisit(graph, neighbor);
            }
        }
        order.add(0, v);
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(Arrays.asList(1, 2));
        graph.add(Arrays.asList(3));
        graph.add(Arrays.asList(3, 4));
        graph.add(Arrays.asList(5));
        graph.add(Arrays.asList(5));
        graph.add(Collections.emptyList());

        sortByDfs(graph);
    }
}
