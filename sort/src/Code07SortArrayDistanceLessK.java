import java.util.PriorityQueue;

/**
 * @author youngoo
 * @date 2021/12/6 20:55
 */
public class Code07SortArrayDistanceLessK {

   public static void sortedArrDistanceLessK(int[] arr, int k) {
       PriorityQueue<Integer> heap = new PriorityQueue<>();
       int index = 0;
       // 初始化小根堆的前k个数据
       for (; index < Math.min(arr.length, k); index++) {
           heap.add(arr[index]);
       }

       int i = 0;
       for (; index < arr.length; i++, index++) {
           heap.add(arr[index]);
           arr[i] = heap.poll();
       }
       while (!heap.isEmpty()) {
           arr[i++] = heap.poll();
       }
   }
}
