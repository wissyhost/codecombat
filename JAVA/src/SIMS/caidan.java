package SIMS;
import java.util.Scanner;

public class caidan{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//String pause;
		int x, y, xuanze = 0, money = 0;// 循环使用
		int prize[] = { 38, 58, 48, 38, 28, 28, 28, 38, 38, 38 };
		String nm1[]={"烧烤类***1: 盐烤大虾","2: 三文鱼","3: 碳烤生蚝","\n \t4: 牛仔骨","\n\t5: 李公主寿司","6: 鳗鱼寿司","7: 三文鱼寿司","\n\t8: 水煮鱼","9: 干锅牛蛙","10: 松子鱼"};
		System.out
				.println("*********************************************************************************");
		for (x = 0; x < 11; x++) {// 最多点10道菜
			for(y=0;y>=0&&y<10;y++){
				System.out.print(nm1[y]+"\t"+prize[y]+"元\t");
			}
			System.out.println("\n输入0保存并退出,输入0");
			xuanze = input.nextInt();
			if ((xuanze >= 0) && (xuanze < 11)) {
				if (xuanze == 0 && x == 0) {// 用于第一次进入不点菜,退出
					System.out.println("退出!");
					break;
				} //if(xuanze == 00 ){
					//money = 0;
					//System.out.println("成功清空输入,按任意键继续");
					//pause = input.next();//按任意键继续 
					//continue;
				//}else {
					if (xuanze != 0) {// 选择不等于0就加起来
						money += prize[xuanze - 1];//从数组0位加起
					} else {//点完菜输入0,程序正常退出
						System.out.println("总金额:" + money);
						System.out.println("谢谢惠顾!!");
						break;
					//}
				}
			}
		}

	}

}
