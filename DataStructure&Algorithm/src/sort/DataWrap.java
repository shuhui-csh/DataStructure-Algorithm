package sort;

/**
 * @author CSH ����һ�����ݰ�װ�� ������ʵ�ʿ����У�������Ҫ����ĳ����Ա������ֵ����������Ļ��������ø���ʵ��Comparable�ӿڣ�
 */
public class DataWrap implements Comparable<DataWrap> {
	int data;
	String flag;

	public DataWrap(int data, String flag) {
		super();
		this.data = data;
		this.flag = flag;
	}

	/**
	 * ����data��������������datawrap����Ĵ�С
	 */
	@Override
	public int compareTo(DataWrap dw) {
		// TODO Auto-generated method stub
		return this.data > dw.data ? 1 : (this.data == dw.data ? 0 : -1);
	}

	@Override
	public String toString() {
		return data + flag;
	}

}
