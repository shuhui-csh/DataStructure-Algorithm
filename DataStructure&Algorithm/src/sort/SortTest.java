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
		// System.out.println("ѡ������֮ǰ:");
		// System.out.println(Arrays.toString(data));
		// // ѡ��ѡ�������㷨��������
		// SortUtil.selectSort(data);
		// System.out.println("ѡ������֮��:");
		// System.out.println(Arrays.toString(data));

		// System.out.println("������֮ǰ:");
		// System.out.println(Arrays.toString(data));
		// // ѡ��������㷨��������
		// SortUtil.heapSort(data);
		// System.out.println("������֮��:");
		// System.out.println(Arrays.toString(data));

		// DataWrap[] data = { new DataWrap(1, ""), new DataWrap(-49, ""),
		// new DataWrap(2, ""), new DataWrap(3, "*"), new DataWrap(3, ""),
		// new DataWrap(4, ""), new DataWrap(10, ""),
		// new DataWrap(30, "*"), new DataWrap(21, "") };
		// System.out.println("ð������֮ǰ:");
		// System.out.println(Arrays.toString(data));
		// // ѡ��ð�������㷨��������
		// SortUtil.bubbleSort(data);
		// System.out.println("ð������֮��:");
		// System.out.println(Arrays.toString(data));

		// System.out.println("��������֮ǰ:");
		// System.out.println(Arrays.toString(data));
		// // ѡ����������㷨��������
		// SortUtil.quickSort(data);
		// System.out.println("��������֮��:");
		// System.out.println(Arrays.toString(data));

		// System.out.println("��������֮ǰ:");
		// System.out.println(Arrays.toString(data));
		// // ѡ����������㷨��������
		// SortUtil.insertSort(data);
		// System.out.println("��������֮��:");
		// System.out.println(Arrays.toString(data));

		// System.out.println("ϣ������֮ǰ:");
		// System.out.println(Arrays.toString(data));
		// // ѡ����������㷨��������
		// SortUtil.shellSort(data);
		// System.out.println("ϣ������֮��:");
		// System.out.println(Arrays.toString(data));

		System.out.println("�鲢����֮ǰ:");
		System.out.println(Arrays.toString(data));
		// ѡ����������㷨��������
		SortUtil.mergeSort(data);
		System.out.println("�鲢����֮��:");
		System.out.println(Arrays.toString(data));
	}
}
