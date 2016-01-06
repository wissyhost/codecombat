package SIMS;

public class 冒泡互换 {
	// 定义属性
	int[] shuzhu;

	/**
	 * @param args
	 * @author wissy
	 * @data 2015,10,11
	 */
	// 定义方法
	@Deprecated
	public void show(int[] kk) {
		// int a[] = new int[] { 1, 8, 6, 8, 32, 56, };//定义一个数组
		for (int j = 0; j < shuzhu.length; j++) {// 从0开始循环一直到最大长度
			for (int i = 0; i < shuzhu.length - 1; i++) {
				if (shuzhu[i] < shuzhu[i + 1]) {
					int temp = 0;
					temp = shuzhu[i];
					shuzhu[i] = shuzhu[i + 1];
					shuzhu[i + 1] = temp;
				}
			}
		}
		for (int i = 0; i < shuzhu.length; i++) {// 循环输出
			System.out.print(shuzhu[i] + "\t");
		}
		System.out.println();
		for (int j = 0; j < kk.length; j++) {// 从0开始循环一直到最大长度
			for (int i = 0; i < kk.length - 1; i++) {
				if (kk[i] < kk[i + 1]) {
					int temp = 0;
					temp = kk[i];
					kk[i] = kk[i + 1];
					kk[i + 1] = temp;
				}
			}
		}
		for (int i = 0; i < kk.length; i++) {// 循环输出
			System.out.print(kk[i] + "\t");
		}
	}

	// 调用
	public static void main(String[] args) {
		// 替换属性
		冒泡互换 jj = new 冒泡互换();
		jj.shuzhu = new int[] { 2, 4, 889, 5, 65, 323 };
		// 调用方法
		jj.show(new int[] { 1, 8585, 554, 556, 4564, 555, });
	}

}
