package SIMS;

import java.util.Scanner;

public class 二维数组 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[][] shuzu = new int[4][5];
		for (int i = 0; i < shuzu.length; i++) {
			System.out.println("第"+i+"行,按");
			for (int j = 0; j < shuzu[i].length; j++) {
				shuzu[i][j] = input.nextInt();
			}
		}
		for (int i = 0; i < shuzu.length; i++) {
			for (int j = 0; j < shuzu[i].length; j++) {
				System.out.print(shuzu[i][j]+"\t");
			}
			System.out.println();
		}

	}
}
