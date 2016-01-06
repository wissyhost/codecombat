package SIMS;

//import java.text.DecimalFormat;//对数字进行格式化输出
import java.util.Scanner;

public class 数组 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// DecimalFormat df = new DecimalFormat( "0.0 ");
		double[] money = new double[5];
		double sum = 0.0;
		System.out.println("请输入会员本月的消费金额记录");
		for (int i = 0; i < money.length; i++) {
			System.out.printf("请输入第%d笔购物金额", (i + 1));
			float a = input.nextFloat();
			money[i] = a;
			sum = sum + a;
		}
		System.out.println("序号\t\t\t金额(元)");
		for (int i = 0; i < money.length; i++) {
			// System.out.println(i+1+"\t\t\t"+df.format(money[i]));
			System.out.println(i + 1 + "\t\t\t" + money[i]);
		}
		// System.out.print("总金额:"+df.format(sum));
		System.out.print("总金额:" + sum);
	}

}
