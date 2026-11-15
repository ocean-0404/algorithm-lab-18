import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    private static int checkCount = 0;

    public static List<String> generate(int n) {
        List<String> codes = new ArrayList<>();
        if (n == 1) {
            codes.add("0");
            codes.add("1");
            return codes;
        }
        List<String> lowerCodes = generate(n - 1);
        for (String code : lowerCodes) {
            codes.add("0" + code);
        }
        for (int i = lowerCodes.size() - 1; i >= 0; i--) {
            codes.add("1" + lowerCodes.get(i));
        }
        return codes;
    }

    private static boolean isAdjacent(String first, String second) {
        int differenceCount = 0;
        for (int i = 0; i < first.length(); i++) {
            checkCount++;
            if (first.charAt(i) != second.charAt(i)) {
                differenceCount++;
            }
        }
        return differenceCount == 1;
    }

    public static void printCodes(int n) {
        List<String> codes = generate(n);
        System.out.println(n + " 位格雷码共 " + codes.size() + " 个：");
        for (int i = 0; i < codes.size(); i++) {
            System.out.println((i + 1) + " : " + codes.get(i));
        }
        checkCount = 0;
        boolean allAdjacent = true;
        for (int i = 0; i < codes.size() - 1; i++) {
            if (!isAdjacent(codes.get(i), codes.get(i + 1))) {
                allAdjacent = false;
            }
        }
        System.out.println("相邻校验：" + (allAdjacent ? "通过" : "失败"));
        System.out.println("逐位比较次数：" + checkCount);
        System.out.println();
    }

    public static void main(String[] args) {
        printCodes(3);
        printCodes(4);
    }
}
