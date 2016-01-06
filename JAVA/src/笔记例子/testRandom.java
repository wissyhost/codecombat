package 笔记例子;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class DoubleBoll {
	private Set redBoll;
	private int blueBoll;

	public Set getRedBoll() {
		return redBoll;
	}

	private void setRedBoll(Set redBoll) {
		this.redBoll = redBoll;
	}

	public int getBlueBoll() {
		return blueBoll;
	}

	private void setBlueBoll(int blueBoll) {
		this.blueBoll = blueBoll;
	}

	public DoubleBoll getDoubleBoll() {
		DoubleBoll ret = new DoubleBoll();
		Set<Integer> set1 = new HashSet<Integer>();
		Random ran = new Random();
		while (set1.size() != 6) {
			int m = ran.nextInt(33) + 1;
			set1.add(m);
		}
		ret.setRedBoll(set1);
		ret.setBlueBoll(ran.nextInt(16) + 1);
		return ret;
	}
}

public class testRandom {

	/**
	 * 定义一个大小为6的红球数组,定义一个蓝球变量 创建对象 生成数据过程分两部分 1.为红球的数组判断不重复并且将set放满, 2.为篮球生成一个数
	 * 数据调用并验证
	 */

	public static void main(String[] args) {
		DoubleBoll dboll = new DoubleBoll();
		DoubleBoll lk = dboll.getDoubleBoll();
		Set a = lk.getRedBoll();
		int b = lk.getBlueBoll();
		System.out.println(a + "\t\t" + b);

	}
}
