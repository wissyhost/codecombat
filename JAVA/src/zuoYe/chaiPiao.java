package zuoYe;
import java.util.*;
public class chaiPiao {

	/**
	 * @application Name:六合彩判断系统
	 * @author wissy
	 * @param args
	 * @date:2015.09.25
	 */
	public static void caipp(String[] args) {
		Scanner input = new Scanner(System.in);
		//Random rr=new Random(); //定义新的产生随机数对象
		int[] randomNumber = new int[6];//随机数组
//调试 	int[] randomNumber = {1,2,3,4,5,6};
		int[] inputNumber = new int[6];//输入数组
		int[] prizeNumber = new int[6];//保存中奖数字
		int num = 0;//定义中奖个数并初始为0
		int tempNumber;//缓存数字
		//生成随机数
		for(int i=0;i< randomNumber.length;i++){//指定输出数组全部的数字
			 //tempNumber = rr.nextInt(36);//通过对象产生随机数
			tempNumber = (int)(Math.random()*35+1);//通过类产生
			randomNumber[i] = tempNumber;
		}
		//接受用户输入并保存在数组
		System.out.println("请此次输入您的号码");
		for(int i=0;i<6;i++){
			 tempNumber = input.nextInt(); 
			 inputNumber[i] = tempNumber;
		}
		//判断是否有对的，若有将中奖号保存在新数组
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				if(randomNumber[i] == inputNumber[j]){
					prizeNumber[num] = randomNumber[i];
					num++;//有一个中奖，num+1
				}
				
			}
		}
		//调试判断
		System.out.println("\n输入的号码：");
		for(int i =0;i<inputNumber.length;i++){
			//Arrays.sort(inputNumber+"\t");//排序
		System.out.print(inputNumber[i]+"\t");
		}
		System.out.println("\n随机的号码：");
		for(int i =0;i<randomNumber.length;i++){
			//Arrays.sort(randomNumber+"\t");//排序
			System.out.print(randomNumber[i]+"\t");
			}
		//调试判断
		//进行输出
		if(num > 0){
			System.out.println("\n\n\n\t\t\t****恭喜您*中奖啦****\n中奖号码为:\n");
			for(int i =0;i<num;i++){
				//Arrays.sort(prizeNumber+"\t");//排序
			System.out.print(prizeNumber[i]+"\t");
			}
			//for(int i =0;i<randomNumber.length;i++){
			//	//Arrays.sort(randomNumber+"\t");//排序
			//	System.out.print("\n"+randomNumber[i]);
			//	}
		}else if(num == 6){
			System.out.println("\n你的人品爆发了");
		}else{
			System.out.println("\n你没有中奖");
		}
		
	}

}
