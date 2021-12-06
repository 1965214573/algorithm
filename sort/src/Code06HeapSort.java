/**
 * @author youngoo
 * @date 2021/12/6 19:44
 */
public class Code06HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 将数组所有的值进行大根堆处理
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        // 当前数比父节点大，执行交换
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            // 更新当前位置
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        // 获取左孩子下标
        int left = index * 2 + 1;

        // 当下方还有孩子的时候
        while (left < heapSize) {
            // 获取最大值的下标
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ?  left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            // 根就满足最大，那么直接返回
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            // 迭代当前根和左孩子
            index = largest;
            left = index * 2 + 1;

        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
