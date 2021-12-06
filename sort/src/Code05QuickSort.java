/**
 * @author youngoo
 * @date 2021/12/6 20:17
 */
public class Code05QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            // 将随机的中间值跟最后一个数做交换
            swap(arr, l + (int)(Math.random() * (r - l + 1)), r);
            // 找到中间 = 区的边界
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        // < 区右边界
        int less = l - 1;
        // > 区左边界
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if ( arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        // 将最后一个标准值跟第一个 > 区的数做交换
        swap(arr, more, r);
        return new int[] {less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
