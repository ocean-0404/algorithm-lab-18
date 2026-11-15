import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable {
    private final List<LinkedList<Integer>> buckets;
    private final int bucketCount;

    public HashTable(int bucketCount) {
        this.bucketCount = bucketCount;
        this.buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    private int hash(int key) {
        return key % bucketCount;
    }

    public void insert(int key) {
        LinkedList<Integer> bucket = buckets.get(hash(key));
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    public void delete(int key) {
        buckets.get(hash(key)).remove(Integer.valueOf(key));
    }

    public boolean search(int key) {
        return buckets.get(hash(key)).contains(key);
    }

    public void printTable() {
        for (int i = 0; i < bucketCount; i++) {
            if (!buckets.get(i).isEmpty()) {
                System.out.println("桶 " + i + "：" + buckets.get(i));
            }
        }
    }

    public static void main(String[] args) {
        HashTable table = new HashTable(11);
        String[] operations = {
                "Insert 5", "Insert 15", "Search 5", "Delete 5", "Search 5",
                "Insert 25", "Insert 55", "Insert 65", "Search 55"
        };

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            String command = parts[0];
            int key = Integer.parseInt(parts[1]);

            if ("Insert".equals(command)) {
                table.insert(key);
            } else if ("Delete".equals(command)) {
                table.delete(key);
            } else if ("Search".equals(command)) {
                System.out.println(table.search(key) ? "Found" : "Not Found");
            }
        }

        System.out.println("内部结构：");
        table.printTable();
    }
}
