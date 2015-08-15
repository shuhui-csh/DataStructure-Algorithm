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
	 * ѡ������
	 * 
	 * @param data
	 *            �������͵�����
	 */

	public static void selectSort(DataWrap[] data) {
		System.out.println("ѡ������ʼ");
		// ���鳤��
		int arrayLength = data.length;
		// ���ν���arrayLength-1�˱Ƚϣ���i�˱ȽϽ���i���ֵѡ������iλ����
		for (int i = 0; i < arrayLength - 1; i++) {
			// minIndex��Զ�������˱ȽϹ�������Сֵ�������������ڱ��˱ȽϽ����󽻻�
			int minIndex = i;
			// ��i������ֻ�������������ݱȽ�
			for (int j = i + 1; j < arrayLength; j++) {
				// ���minIndexλ�õ�����>jλ�õ����ݣ�����Ҫ��¼jλ�õ�����Ϊ��ǰ��minIndex
				if (data[minIndex].compareTo(data[j]) > 0) {
					// ��j��ֵ����minIndex
					minIndex = j;
				}
			}
			// ÿ�˱ȽϽ������ҵ��˸�����Сֵ������������н���
			if (minIndex != i) {
				swap(data, i, minIndex);
			}
			// ��ӡ����ǰ���˵��������
			System.out.println(Arrays.toString(data));
		}
	}

	/**
	 * �������㷨
	 * 
	 * @param data
	 */
	public static void heapSort(DataWrap[] data) {
		System.out.println("������ʼ��");
		int arrayLength = data.length;
		// ѭ�����ѣ���ѡ���Ѷ�Ԫ��
		for (int i = 0; i < arrayLength - 1; i++) {
			// ����
			buildMaxHeap(data, arrayLength - 1 - i);
			// �����Ѷ������һ��Ԫ��
			swap(data, 0, arrayLength - 1 - i);
			System.out.println(Arrays.toString(data));
		}

	}

	/**
	 * ��datas�����0��lastIndex���󶥶�
	 * 
	 * @param data
	 * @param lastIndex
	 *            ���һ��Ԫ�ص��±�
	 */
	private static void buildMaxHeap(DataWrap[] data, int lastIndex) {
		// TODO Auto-generated method stub
		// ��lastIndex���Ľ�㣨���һ����㣩�ĸ��ڵ�i��ʼ,��ǰ��������
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			// k�����ڱ��浱ǰ���ڵ��жϵĽڵ㣬Ҳ���ں���������whileѭ��
			int k = i;
			// �����ǰk�ڵ���ӽڵ����
			while (k * 2 + 1 <= lastIndex) {
				// k�ڵ�����ӽڵ������������Ϊ���ֵ��������
				int biggerIndex = 2 * k + 1;
				// ������ӽڵ������С��lastIndex,������k�ڵ�biggerIndex+1���ҽڵ����
				if (biggerIndex < lastIndex) {
					// ������ӽڵ��ֵ�ϴ�
					if (data[biggerIndex + 1].compareTo(data[biggerIndex]) > 0) {
						// biggerIndex���Ǽ�¼��ǰ�ϴ��ӽڵ������
						biggerIndex = biggerIndex + 1;
					}
				}
				// �����ж�k�ڵ�������ӽڵ�Ĵ�С,���k�ڵ�С�����ڵ�
				if (data[k].compareTo(data[biggerIndex]) < 0) {
					// ��������
					swap(data, k, biggerIndex);
					// ��biggerIndex����k,��������whileѭ������ʼ��һ��forѭ��
					k = biggerIndex;
				} else {
					// �����k�ڵ��������ӽڵ㣬��������ǰwhileѭ��
					break;
				}
			}
		}
	}

	/**
	 * ð�������㷨
	 * 
	 * @param data
	 */
	public static void bubbleSort(DataWrap[] data) {
		System.out.println("ð������ʼ��");
		int arrayLength = data.length;
		for (int i = 0; i < arrayLength - 1; i++) {
			// �����жϸ�����û�������ݽ�����true�����У�false����û�У���ʱӦ����������ѭ��
			boolean flag = false;
			for (int j = 0; j < arrayLength - 1 - i; j++) {
				// ���j��������Ԫ�ش���j+1��������Ԫ��
				if (data[j].compareTo(data[j + 1]) > 0) {
					// ��������
					swap(data, j, j + 1);
					flag = true;
				}
			}
			System.out.println(Arrays.toString(data));
			if (flag == false) {
				// ���ĳ��û�з��������������ȫ���Ѵ�������״̬����ʱӦ���˳����ѭ��
				break;
			}
		}
	}

	/**
	 * ��������
	 * 
	 * @param data
	 */
	public static void insertSort(DataWrap[] data) {
		System.out.println("�������򷨿�ʼ��");
		int arrayLength = data.length;
		for (int i = 1; i < arrayLength; i++) {
			// ���������ʱ�����浱ǰ�Ƚϵ�data[i]���ᶪʧ
			DataWrap temp = data[i];
			// i-1��������ֵ�Ѿ���ǰ�������ֵ���󣬱����Ѿ������������
			// i-1����֮ǰ�������Ѿ�������ģ�����i-1��������ֵ����ǰ�����ź�������ֵ
			if (data[i].compareTo(data[i - 1]) < 0) {
				int j = i - 1;
				// ����ǰ���ֵ�ȵ�ǰ��data[i]�����ʱ���������һ��
				// �ճ�λ�ø���ǰ��temp=data[i]����
				while (j >= 0 && data[j].compareTo(temp) > 0) {
					data[j + 1] = data[j];// j+1��Ϊ��ǰi��λ��
					j--;
				}
				// �ҵ�ǰ��ȵ�ǰtemp=data[i]С���±�󣬰ѵ�ǰ�Ƚϵ�temp���뵽���ʵ�λ��
				data[j + 1] = temp;
			}
			// ��ӡ����ǰ���������������������
			System.out.println(Arrays.toString(data));
		}
	}

	/**
	 * ��������
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
