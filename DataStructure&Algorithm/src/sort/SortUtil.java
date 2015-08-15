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
	 * 快速排序算法
	 * 
	 * @param data
	 */
	public static void quickSort(DataWrap[] data) {
		System.out.println("快速排序开始：");
		subSort(data, 0, data.length - 1);
	}

	/**
	 * 对data数组中从start-end索引范围的子序列进行处理 使满足所有小于分界值得（枢轴）的放在左边，所有大于分界值的放在右边
	 * 
	 * @param data
	 * @param i
	 * @param j
	 */
	private static void subSort(DataWrap[] data, int start, int end) {
		// TODO Auto-generated method stub
		// 只有当左边的索引小于右边的索引时，才需要排序
		if (start < end) {
			// 以第一个元素作为分界值，这个分界值还有许多其他的方法可选择一个比较合适的，比如说中值
			DataWrap base = data[start];
			// 从左边开始搜索，搜索大于分界值的元素
			int i = start;
			// 从右边开始搜索，搜索小于分界值的元素
			int j = end + 1;
			while (true) {
				// 找到大于分界的元素的索引，或者i已经到了end处
				while (i < end && data[++i].compareTo(base) <= 0)
					;
				// 找到小于分界值元素的索引，或者j已经到了start处
				while (j > start && data[--j].compareTo(base) >= 0)
					;
				// 找到了大于或小于分界值的元素的索引时，如果索引没有超过
				if (i < j) {
					swap(data, i, j);
				} else {
					break;
				}
			}
			// 将分界值（这里即第一个元素）与j索引处的（此时已j<=i了）的元素值交换，
			// 交换后，j索引之前的元素都比j索引处的元素小，后面的元素都比j索引处的元素大
			swap(data, start, j);
			System.out.println(Arrays.toString(data));
			// 之后对左边的子序列（j索引之前的）递归相同的处理方法
			subSort(data, start, j - 1);
			// 之后对右边的子序列（j索引之后的）递归相同的处理方法
			subSort(data, j + 1, end);
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
			// i-1索引处的值已经比前面的所有值都大，表明已经有序，无序插入
			// i-1索引之前的数据已经是有序的，并且i-1索引处的值就是前面已排好序的最大值
			if (data[i].compareTo(data[i - 1]) < 0) {
				// 当整体后移时，保存当前比较的data[i]不会丢失
				DataWrap temp = data[i];
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
	 * 希尔排序，直接插入排序的改进
	 * 
	 * @param data
	 */
	public static void shellSort(DataWrap[] data) {
		System.out.println("希尔排序开始：");
		int arrayLength = data.length;
		// h变量保存可变增量
		int h = 1;
		// 按h*3+1得到增量序列的最大值
		while (h <= arrayLength / 3) {
			h = h * 3 + 1;
		}

		while (h > 0) {
			System.out.println("===h的值：" + h + "===");
			// i-1索引处的值已经比前面的所有值都大，表明已经有序，无序插入
			// i-1索引之前的数据已经是有序的，并且i-1索引处的值就是前面已排好序的最大值
			for (int i = h; i < arrayLength; i++) {
				if (data[i].compareTo(data[i - h]) < 0) {
					// 当整体后移时，保存当前比较的data[i]不会丢失
					DataWrap temp = data[i];
					int j = i - h;
					// ，当前面的值比当前的data[i]还大的时候，整体后移h格，
					// 空出位置给当前的temp=data[i]插入
					while (j >= 0 && data[j].compareTo(temp) > 0) {
						data[j + h] = data[j];// j+h=i,所以需要temp
						j = j - h;
					}
					// 找到前面比当前temp=data[i]小的下标后，把当前比较的temp插入到合适的位置
					data[j + h] = temp;
				}
				System.out.println(Arrays.toString(data));
			}
			// 缩小增量
			h = (h - 1) / 3;
		}
	}

	/**
	 * 归并算法排序
	 * 
	 * @param data
	 */
	public static void mergeSort(DataWrap[] data) {
		System.out.println("归并排序开始：");
		// 归并排序
		mergesort(data, 0, data.length - 1);
	}

	/**
	 * 将索引从left到right范围的数组元素进行归并排序
	 * 
	 * @param data
	 *            待排序数组
	 * @param left
	 *            待排序的数组的第一个元素索引
	 * @param right
	 *            待排序数组的最后一个元素索引
	 */
	private static void mergesort(DataWrap[] data, int left, int right) {
		// TODO Auto-generated method stub
		if (left < right) {
			// 找出中间索引
			int center = (left + right) / 2;
			// 对左边数组进行递归
			mergesort(data, left, center);
			// 对右边数组进行递归
			mergesort(data, center + 1, right);
			// 合并两个子数组
			merge(data, left, center, right);
			System.out.println(Arrays.toString(data));
		}
	}

	/**
	 * 将两个数组进行归并，归并前两个数组已经有序，归并后依然有序
	 * 
	 * @param data
	 *            数组对象
	 * @param left
	 *            左数组的第一个元素的索引
	 * @param center
	 *            左边数组的最后一个元素，center+1为右边数组的第一个元素的索引
	 * @param right
	 *            右数组的最后一个元素
	 */
	private static void merge(DataWrap[] data, int left, int center, int right) {
		// TODO Auto-generated method stub
		DataWrap[] tempArray = new DataWrap[data.length];
		// 右边数组的首元素的下标
		int second = center + 1;
		// 辅助数组tempArray的首元素下标
		int tempIndex1 = left;
		// 辅助数组tempArray的首元素下标
		int tempIndex2 = left;
		while (left <= center && second <= right) {
			// 从两个数组中取出小的放入辅助数组中
			if (data[left].compareTo(data[second]) <= 0) {
				tempArray[tempIndex1++] = data[left++];
			} else {
				tempArray[tempIndex1++] = data[second++];
			}
		}
		// 剩余部分依次放入辅助数组
		// 如果第二个数组的开始索引没超过最后一个元素的索引
		while (second <= right) {
			tempArray[tempIndex1++] = data[second++];
		}
		// 如果第一个数组的开始索引没超过最后一个元素的索引
		while (left <= center) {
			tempArray[tempIndex1++] = data[left++];
		}
		// 将辅助数组中内容复制拷贝回原数组
		// 原left-right范围的内容被复制会原来的数组
		while (tempIndex2 <= right) {
			data[tempIndex2] = tempArray[tempIndex2++];
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
