package sort;

/**
 * @author CSH 定义一个数据包装类 （若是实际开发中，遇到需要根据某个成员变量的值来进行排序的话，可以让该类实现Comparable接口）
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
	 * 根据data变量来决定两个datawrap对象的大小
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
