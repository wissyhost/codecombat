package SIMS;

public class 两个数互换 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 利用另外一个变量实现互换
		int a = 10;
		int b = 20;
		// 开始
		int temp = 0;
		temp = a;
		a=b;
		b=temp;
		System.out.println(a+"\t"+b);
		//利用两个变量对数值相加减
		int x = 11;
		int y = 22;
		x = x + y;
		y = x - y;
		x = x - y;
		System.out.println(x+"\t"+y);
		//利用指数运算
		//3.位移运算交换

		int xx = 10;
		int yy = 20;
		xx = xx ^ yy;
		yy = xx ^ yy;
		xx = xx ^ yy;
		System.out.println(xx+"\t"+yy);
	}

}
