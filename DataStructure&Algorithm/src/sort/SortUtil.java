/**
 * 
 */
package sort;

import java.util.Arrays;

/**
 * @author CSH
 * 
 */
public class SortUtil {
	/**
	 * 选择排序
	 * 
	 * @param data
	 *            数组类型的数据
	 */

	public static void selectSort(DataWrap[] data) {
		System.out.println("选择排序开始");
		// 数组长度
		int arrayLength = data.length;
		// 依次进行arrayLength-1趟比较，第i趟比较将第i大的值选出放在i位置上
		for (int i = 0; i < arrayLength - 1; i++) {
			// minIndex永远保留本趟比较过程中最小值的索引，用于在本趟比较结束后交换
			int minIndex = i;
			// 第i个数据只需和它后面的数据比较
			for (int j = i + 1; j < arrayLength; j++) {
				// 如果minIndex位置的数据>j位置的数据，即需要记录j位置的索引为当前的minIndex
				if (data[minIndex].compareTo(data[j]) > 0) {
					// 将j的值赋给minIndex
					minIndex = j;
				}
			}
			// 每趟比较结束后，找到了该趟最小值的索引，则进行交换
			if (minIndex != i) {
				swap(data, i, minIndex);
			}
			// 打印出当前该趟的排序情况
			System.out.println(Arrays.toString(data));
		}
	}

	/**
	 * 堆排序算法
	 * 
	 * @param data
	 */
	public static void heapSort(DataWrap[] data) {
		System.out.println("堆排序开始：");
		int arrayLength = data.length;
		// 循环建堆，并选出堆顶元素
		for (int i = 0; i < arrayLength - 1; i++) {
			// 建堆
			buildMaxHeap(data, arrayLength - 1 - i);
			// 交换堆顶和最后一个元素
			swap(data, 0, arrayLength - 1 - i);
			System.out.println(Arrays.toString(data));
		}

	}

	/**
	 * 对datas数组从0到lastIndex建大顶堆
	 * 
	 * @param data
	 * @param lastIndex
	 *            最后一个元素的下标
	 */
	private static void buildMaxHeap(DataWrap[] data, int lastIndex) {
		// TODO Auto-generated method stub
		// 从lastIndex处的结点（最后一个结点）的父节点i开始,向前遍历建堆
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			// k用用于保存当前正在的判断的节点，也用于后面能跳出while循环
			int k = i;
			// 如果当前k节点的子节点存在
			while (k * 2 + 1 <= lastIndex) {
				// k节点的左子节点的索引，假设为最大值的索引先
				int biggerIndex = 2 * k + 1;
				// 如果左子节点的索引小于lastIndex,即代表k节点biggerIndex+1的右节点存在
				if (biggerIndex < lastIndex) {
					// 如果右子节点的值较大
					if (data[biggerIndex + 1].compareTo(data[biggerIndex]) > 0) {
						// biggerIndex总是记录当前较大子节点的索引
						biggerIndex = biggerIndex + 1;
					}
				}
				// 再来判断k节点与最大子节点的大小,如果k节点小于最大节点
				if (data[k].compareTo(data[biggerIndex]) < 0) {
					// 交换他们
					swap(data, k, biggerIndex);
					// 将biggerIndex赋给k,以能跳出while循环，开始下一次for循环
					k = biggerIndex;
				} else {
					// 如果是k节点大于最大子节点，则跳出当前while循环
					break;
				}
			}
		}
	}

	/**
	 * 冒泡排序算法
	 * 
	 * @param data
	 */
	public static void bubbleSort(DataWrap[] data) {
		System.out.println("冒泡排序开始：");
		int arrayLength = data.length;
		for (int i = 0; i < arrayLength - 1; i++) {
			// 用来判断该趟有没发生数据交换，true代表有，false代表没有，此时应该跳出所有循环
			boolean flag = false;
			for (int j = 0; j < arrayLength - 1 - i; j++) {
				// 如果j索引处的元素大于j+1索引处的元素
				if (data[j].compareTo(data[j + 1]) > 0) {
					// 交换他们
					swap(data, j, j + 1);
					flag = true;
				}
			}
			System.out.println(Arrays.toString(data));
			if (flag == false) {
				// 如果某趟没有发生交换，则表明全部已处于有序状态，这时应该退出外层循环
				break;
			}
		}
	}

	/**
	 * 插入排序法
	 * 
	 * @param data
	 */
	public static void insertSort(DataWrap[] data) {
		System.out.println("插入排序法开始：");
		int arrayLength = data.length;
		for (int i = 1; i < arrayLength; i++) {
			// 当整体后移时，保存当前比较的data[i]不会丢失
			DataWrap temp = data[i];
			// i-1索引处的值已经比前面的所有值都大，表明已经有序，无序插入
			// i-1索引之前的数据已经是有序的，并且i-1索引处的值就是前面已排好序的最大值
			if (data[i].compareTo(data[i - 1]) < 0) {
				int j = i - 1;
				// ，当前面的值比当前的data[i]还大的时候，整体后移一格，
				// 空出位置给当前的temp=data[i]插入
				while (j >= 0 && data[j].compareTo(temp) > 0) {
					data[j + 1] = data[j];// j+1即为当前i的位置
					j--;
				}
				// 找到前面比当前temp=data[i]小的下标后，把当前比较的temp插入到合适的位置
				data[j + 1] = temp;
			}
			// 打印出当前该趟排序后的数据排列情况
			System.out.println(Arrays.toString(data));
		}
	}

	/**
	 * 交换操作
	 * 
	 * @param data
	 * @param i
	 * @param j
	 */
	private static void swap(DataWrap[] data, int i, int j) {
		// TODO Auto-generated method stub
		DataWrap temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}
