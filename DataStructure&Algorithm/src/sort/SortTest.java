/**
 * 
 */
package sort;

import java.util.Arrays;

/**
 * @author CSH
 * 
 */
public class SortTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataWrap[] data = { new DataWrap(21, ""), new DataWrap(30, ""),
				new DataWrap(49, ""), new DataWrap(30, "*"),
				new DataWrap(16, ""), new DataWrap(9, ""),
				new DataWrap(-16, ""), new DataWrap(21, "*"),
				new DataWrap(-49, "") };
		// System.out.println("选择排序之前:");
		// System.out.println(Arrays.toString(data));
		// // 选择选择排序算法进行排序
		// SortUtil.selectSort(data);
		// System.out.println("选择排序之后:");
		// System.out.println(Arrays.toString(data));

		// System.out.println("堆排序之前:");
		// System.out.println(Arrays.toString(data));
		// // 选择堆排序算法进行排序
		// SortUtil.heapSort(data);
		// System.out.println("堆排序之后:");
		// System.out.println(Arrays.toString(data));

		// DataWrap[] data = { new DataWrap(1, ""), new DataWrap(-49, ""),
		// new DataWrap(2, ""), new DataWrap(3, "*"), new DataWrap(3, ""),
		// new DataWrap(4, ""), new DataWrap(10, ""),
		// new DataWrap(30, "*"), new DataWrap(21, "") };
		// System.out.println("冒泡排序之前:");
		// System.out.println(Arrays.toString(data));
		// // 选择冒泡排序算法进行排序
		// SortUtil.bubbleSort(data);
		// System.out.println("冒泡排序之后:");
		// System.out.println(Arrays.toString(data));

		// System.out.println("快速排序之前:");
		// System.out.println(Arrays.toString(data));
		// // 选择快速排序算法进行排序
		// SortUtil.quickSort(data);
		// System.out.println("快速排序之后:");
		// System.out.println(Arrays.toString(data));

		// System.out.println("插入排序之前:");
		// System.out.println(Arrays.toString(data));
		// // 选择插入排序算法进行排序
		// SortUtil.insertSort(data);
		// System.out.println("插入排序之后:");
		// System.out.println(Arrays.toString(data));

		// System.out.println("希尔排序之前:");
		// System.out.println(Arrays.toString(data));
		// // 选择快速排序算法进行排序
		// SortUtil.shellSort(data);
		// System.out.println("希尔排序之后:");
		// System.out.println(Arrays.toString(data));

		System.out.println("归并排序之前:");
		System.out.println(Arrays.toString(data));
		// 选择快速排序算法进行排序
		SortUtil.mergeSort(data);
		System.out.println("归并排序之后:");
		System.out.println(Arrays.toString(data));
	}
}
