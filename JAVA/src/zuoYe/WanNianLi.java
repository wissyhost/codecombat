package zuoYe;

//import java.util.Scanner;

public class WanNianLi {

	/**
	 * @param args
	 * @author wissy
	 * @date 2015,10,12
	 * int year,int month;用于显示输入年月的日历
	 */
	  //闰年:能被4整除不能被100整除,或者能被400整除; 1. 先计算输入的是否是闰年
	public void wanNianLi(int year, int month) {
		// Scanner input = new Scanner(System.in);
		// System.out.println("请输入年份");
		// int year = input.nextInt();
		// System.out.println("请输入月份");
		// int month = input.nextInt();
		/*
		 * 计算输入年月份拒1900年有多少天
		 */
		// int[] shuZu = new int[12];
		// int[] yueDay = new int[12];
		boolean runNian = false;// 定义闰年保存并所判断的年份是否是闰年
		int maxDayNumber = 0; // 距1900年1月最大天数
		/*
		 * 判断输入得年份是否是闰年
		 */
		if (year % 3200 == 0 || year % 400 == 0
				|| (year % 4 == 0 && year % 100 != 0)) {
			runNian = true;
		}
		for (int i = 1900; i < year; i++) {
			// 从1900到输入的年份如果是闰年就加366不是就加365
			if ((i % 3200 == 0 || i % 400 == 0 || i % 4 == 0 && i % 100 != 0)) {
				maxDayNumber += 366;
				// System.out.println(year + "是闰年");
			} else {
				maxDayNumber += 365;
				// System.out.println(year + "是平年");
			}
		}
		// 计算输入到那年月有多少天
		// for (int j = 1; j < month; j++) {// 判断本年距本月份有多少天
		// if (j == 1 || j == 3 || j == 5 || j == 7// 31天的月份
		// || j == 8 || j == 10) {
		// maxDayNumber += 31;
		// } else if (j == 4 || j == 6 || j == 9 // 30天的月份
		// || j == 11) {
		// maxDayNumber += 30;
		// } else {
		// if (runNian = true) {
		// maxDayNumber += 29; // 闰年29天
		// // System.out.println(year + "是闰年");
		// } else { // 平年28天
		// maxDayNumber += 28;
		// // System.out.println(year + "是平年");
		// }
		//
		// }
		// }
		int bengYueNumber;
		// String exit = "0";
		// do {
		int[] monthMaxDay = { 31, runNian ? 29 : 28, 31, 30, 31, 30, 31, 31,
				30, 31, 30 };// 定义数组对月份进行运算
		for (int j = 1; j < month; j++) {
			maxDayNumber = monthMaxDay[j - 1];
		}
		/*
		 * 计算本月有多少天
		 */
		bengYueNumber = monthMaxDay[month];
		// if (month == 1 || month == 3 || month == 5 || month == 7//
		// 31天的月份
		// || month == 8 || month == 10 || month == 12) {
		// bengYueNumber = 31;
		// } else if (month == 4 || month == 6 || month == 9 // 30天的月份
		// || month == 11) {
		// bengYueNumber = 30;
		// } else {
		// if (runNian == true) {
		// bengYueNumber = 29; // 闰年29天
		// System.out.println(year + "是闰年");
		// } else { // 平年28天
		// bengYueNumber = 28;
		// }
		// }
		/*
		 * 本月结束
		 */
		int week = maxDayNumber % 7; // 计算这个月开始是星期几
		int[] shuchu = new int[37]; // 用数组保存本月的日历
		for (int i = 1; i <= week; i++) { // 对本月以前的星期用0来标记
			shuchu[i - 1] = 0; // 空格
		}
		for (int i = week, n = 1; n <= bengYueNumber; i++, n++) { // 逐个累加一直加到本月最大长度
			shuchu[i] = n;
		}
		System.out.println("年份是:" + year + "月份是" + month + "月,\t距1900年1月有"
				+ (month - 1900) + "年" + month + "月" + "总计" + maxDayNumber
				+ "天");
		System.out.println("星期一\t星期二\t星期三\t星期四\t星期五\t星期六\t星期日");
		/*
		 * 对数值输出
		 */
		shuchu.toString();
		for (int i = 0; i < shuchu.length; i++) {
			if (0 == shuchu[i]) {
				System.out.print("\t");
			} else {

				if ((i + 1) % 7 == 0) {
					System.out.println(shuchu[i]);
				} else {
					System.out.print(shuchu[i] + "\t");
				}
			}

			/*
			 * 输出结束
			 */
		}
		// System.out.println();
		// month += 1;
		// maxDayNumber += bengYueNumber;
		// System.out.println("按任意键显示下一个月,按e退出");
		// exit = input.next();
		// } while (!"e".equals(exit));
		// System.out.println("退出");
	}
}
