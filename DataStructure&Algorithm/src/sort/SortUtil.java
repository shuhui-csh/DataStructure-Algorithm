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
	 * ���������㷨
	 * 
	 * @param data
	 */
	public static void quickSort(DataWrap[] data) {
		System.out.println("��������ʼ��");
		subSort(data, 0, data.length - 1);
	}

	/**
	 * ��data�����д�start-end������Χ�������н��д��� ʹ��������С�ڷֽ�ֵ�ã����ᣩ�ķ�����ߣ����д��ڷֽ�ֵ�ķ����ұ�
	 * 
	 * @param data
	 * @param i
	 * @param j
	 */
	private static void subSort(DataWrap[] data, int start, int end) {
		// TODO Auto-generated method stub
		// ֻ�е���ߵ�����С���ұߵ�����ʱ������Ҫ����
		if (start < end) {
			// �Ե�һ��Ԫ����Ϊ�ֽ�ֵ������ֽ�ֵ������������ķ�����ѡ��һ���ȽϺ��ʵģ�����˵��ֵ
			DataWrap base = data[start];
			// ����߿�ʼ�������������ڷֽ�ֵ��Ԫ��
			int i = start;
			// ���ұ߿�ʼ����������С�ڷֽ�ֵ��Ԫ��
			int j = end + 1;
			while (true) {
				// �ҵ����ڷֽ��Ԫ�ص�����������i�Ѿ�����end��
				while (i < end && data[++i].compareTo(base) <= 0)
					;
				// �ҵ�С�ڷֽ�ֵԪ�ص�����������j�Ѿ�����start��
				while (j > start && data[--j].compareTo(base) >= 0)
					;
				// �ҵ��˴��ڻ�С�ڷֽ�ֵ��Ԫ�ص�����ʱ���������û�г���
				if (i < j) {
					swap(data, i, j);
				} else {
					break;
				}
			}
			// ���ֽ�ֵ�����Ｔ��һ��Ԫ�أ���j�������ģ���ʱ��j<=i�ˣ���Ԫ��ֵ������
			// ������j����֮ǰ��Ԫ�ض���j��������Ԫ��С�������Ԫ�ض���j��������Ԫ�ش�
			swap(data, start, j);
			System.out.println(Arrays.toString(data));
			// ֮�����ߵ������У�j����֮ǰ�ģ��ݹ���ͬ�Ĵ�����
			subSort(data, start, j - 1);
			// ֮����ұߵ������У�j����֮��ģ��ݹ���ͬ�Ĵ�����
			subSort(data, j + 1, end);
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
			// i-1��������ֵ�Ѿ���ǰ�������ֵ���󣬱����Ѿ������������
			// i-1����֮ǰ�������Ѿ�������ģ�����i-1��������ֵ����ǰ�����ź�������ֵ
			if (data[i].compareTo(data[i - 1]) < 0) {
				// ���������ʱ�����浱ǰ�Ƚϵ�data[i]���ᶪʧ
				DataWrap temp = data[i];
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
	 * ϣ������ֱ�Ӳ�������ĸĽ�
	 * 
	 * @param data
	 */
	public static void shellSort(DataWrap[] data) {
		System.out.println("ϣ������ʼ��");
		int arrayLength = data.length;
		// h��������ɱ�����
		int h = 1;
		// ��h*3+1�õ��������е����ֵ
		while (h <= arrayLength / 3) {
			h = h * 3 + 1;
		}

		while (h > 0) {
			System.out.println("===h��ֵ��" + h + "===");
			// i-1��������ֵ�Ѿ���ǰ�������ֵ���󣬱����Ѿ������������
			// i-1����֮ǰ�������Ѿ�������ģ�����i-1��������ֵ����ǰ�����ź�������ֵ
			for (int i = h; i < arrayLength; i++) {
				if (data[i].compareTo(data[i - h]) < 0) {
					// ���������ʱ�����浱ǰ�Ƚϵ�data[i]���ᶪʧ
					DataWrap temp = data[i];
					int j = i - h;
					// ����ǰ���ֵ�ȵ�ǰ��data[i]�����ʱ���������h��
					// �ճ�λ�ø���ǰ��temp=data[i]����
					while (j >= 0 && data[j].compareTo(temp) > 0) {
						data[j + h] = data[j];// j+h=i,������Ҫtemp
						j = j - h;
					}
					// �ҵ�ǰ��ȵ�ǰtemp=data[i]С���±�󣬰ѵ�ǰ�Ƚϵ�temp���뵽���ʵ�λ��
					data[j + h] = temp;
				}
				System.out.println(Arrays.toString(data));
			}
			// ��С����
			h = (h - 1) / 3;
		}
	}

	/**
	 * �鲢�㷨����
	 * 
	 * @param data
	 */
	public static void mergeSort(DataWrap[] data) {
		System.out.println("�鲢����ʼ��");
		// �鲢����
		mergesort(data, 0, data.length - 1);
	}

	/**
	 * ��������left��right��Χ������Ԫ�ؽ��й鲢����
	 * 
	 * @param data
	 *            ����������
	 * @param left
	 *            �����������ĵ�һ��Ԫ������
	 * @param right
	 *            ��������������һ��Ԫ������
	 */
	private static void mergesort(DataWrap[] data, int left, int right) {
		// TODO Auto-generated method stub
		if (left < right) {
			// �ҳ��м�����
			int center = (left + right) / 2;
			// �����������еݹ�
			mergesort(data, left, center);
			// ���ұ�������еݹ�
			mergesort(data, center + 1, right);
			// �ϲ�����������
			merge(data, left, center, right);
			System.out.println(Arrays.toString(data));
		}
	}

	/**
	 * ������������й鲢���鲢ǰ���������Ѿ����򣬹鲢����Ȼ����
	 * 
	 * @param data
	 *            �������
	 * @param left
	 *            ������ĵ�һ��Ԫ�ص�����
	 * @param center
	 *            �����������һ��Ԫ�أ�center+1Ϊ�ұ�����ĵ�һ��Ԫ�ص�����
	 * @param right
	 *            ����������һ��Ԫ��
	 */
	private static void merge(DataWrap[] data, int left, int center, int right) {
		// TODO Auto-generated method stub
		DataWrap[] tempArray = new DataWrap[data.length];
		// �ұ��������Ԫ�ص��±�
		int second = center + 1;
		// ��������tempArray����Ԫ���±�
		int tempIndex1 = left;
		// ��������tempArray����Ԫ���±�
		int tempIndex2 = left;
		while (left <= center && second <= right) {
			// ������������ȡ��С�ķ��븨��������
			if (data[left].compareTo(data[second]) <= 0) {
				tempArray[tempIndex1++] = data[left++];
			} else {
				tempArray[tempIndex1++] = data[second++];
			}
		}
		// ʣ�ಿ�����η��븨������
		// ����ڶ�������Ŀ�ʼ����û�������һ��Ԫ�ص�����
		while (second <= right) {
			tempArray[tempIndex1++] = data[second++];
		}
		// �����һ������Ŀ�ʼ����û�������һ��Ԫ�ص�����
		while (left <= center) {
			tempArray[tempIndex1++] = data[left++];
		}
		// ���������������ݸ��ƿ�����ԭ����
		// ԭleft-right��Χ�����ݱ����ƻ�ԭ��������
		while (tempIndex2 <= right) {
			data[tempIndex2] = tempArray[tempIndex2++];
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
