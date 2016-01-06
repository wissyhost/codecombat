package SIMS;

import java.util.Scanner;

public class 猜拳游戏 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int xueze = 0;
		String[] aa = new String[] { "1.石头", "2.剪刀", "3.布" };// 定义类型数组,方便以后调用
		System.out
				.println("-----------------猜拳游戏开始------------------\n1.石头\t2.剪刀\t3.布\n请选择:");

		if (input.hasNextInt() && (xueze == 1 || xueze == 2 || xueze == 3)) {// 进行数字判断.如果用户输入的不是数字,则提示
			xueze = input.nextInt();
			int random = (int) (Math.random() * 3 + 1);// 0-2
			if (xueze == 1 && random == 2 || xueze == 2 && random == 3
					|| xueze == 3 && random == 1) {// 赢得方法
				System.out.println("你贏了" + xueze + random);
			} else if (xueze == random) {// 平局方法
				System.out.println("平局!" + xueze + random);
			} else {// 输了
				System.out.println("你输了！" + xueze + random);
			}
			System.out.println("你输入的是" + aa[xueze - 1] + "系统出的是"
					+ aa[random - 1]);
		} else {// 如果系统输入的不是1-3则提示错误
			System.out.println("无法识别");
		}
	}

}
