public class MergeSort {
    private static int compareCount = 0;

    public static void sort(int[] array) {
        compareCount = 0;
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = (low + high) / 2;
        sort(array, low, middle);
        sort(array, middle + 1, high);
        merge(array, low, middle, high);
    }

    private static void merge(int[] array, int low, int middle, int high) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = middle + 1;
        int index = 0;

        while (left <= middle && right <= high) {
            compareCount++;
            if (array[left] <= array[right]) {
                temp[index++] = array[left++];
            } else {
                temp[index++] = array[right++];
            }
        }
        while (left <= middle) {
            temp[index++] = array[left++];
        }
        while (right <= high) {
            temp[index++] = array[right++];
        }
        for (int i = 0; i < temp.length; i++) {
            array[low + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {6, 3, 8, 2, 9, 1, 19, 29};
        System.out.print("排序前数组：");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();

        sort(array);

        System.out.print("排序后数组：");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println("合并比较次数：" + compareCount);
    }
}
