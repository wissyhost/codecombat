package SIMS;
import java.util.*;
public class 打折{
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("登录菜单>>\n1.登录系统\n2.退出");
		if(input.hasNextInt()){
		int i = input.nextInt();//选择一级菜单
		switch(i){
		case 1:
			System.out.println("登录菜单>>\n1.客户信息管理\n2.购物结算\n3.真情回馈\n4.注销");
			int ii=input.nextInt();
			switch(ii){//选择二级菜单
			case 1:
				System.out.println("登录菜单>>客户信息管理>>\n1.显示所有客户信息\n2.添加客户信息\n3.修改客户信息\n4.查询客户信息");
				int iii =input.nextInt();
				switch(iii){//选择三级菜单
				default:
					System.out.println("没有了选一选别的吧.");
					break;
				}
				break;
			case 2:
				System.out.println("登录菜单>>购物结算>>\n无");
				break;
			case 3:
				System.out.println("登录菜单>>真情回馈>>\n1.幸运大放送\n2.幸运抽奖(六合彩)\n3.生日问候\n4.商品换购");
				iii = input.nextInt();
				switch(iii){//抽奖
				case 3:
					System.out.println("开始抽奖");
					int[] randomNumber = new int[6];//随机数组
					//调试 	int[] randomNumber = {1,2,3,4,5,6};
							int[] inputNumber = new int[6];//输入数组
							int[] prizeNumber = new int[6];//保存中奖数字
							int num = 0;//定义中奖个数并初始为0
							int tempNumber;//缓存数字
							//生成随机数
							for(int ai=0;ai< randomNumber.length;ai++){//指定输出数组全部的数字
								 //tempNumber = rr.nextInt(36);//通过对象产生随机数
								tempNumber = (int)(Math.random()*35+1);//通过类产生
								randomNumber[ai] = tempNumber;
							}
							//接受用户输入并保存在数组
							System.out.println("请此次输入您的号码");
							for(int ai=0;ai<6;ai++){
								 tempNumber = input.nextInt(); 
								 inputNumber[ai] = tempNumber;
							}
							//判断是否有对的，若有将中奖号保存在新数组
							for(int ai=0;ai<6;ai++){
								for(int j=0;j<6;j++){
									if(randomNumber[i] == inputNumber[j]){
										prizeNumber[num] = randomNumber[i];
										num++;//有一个中奖，num+1
									}
									
								}
							}
							//调试判断
							System.out.println("\n输入的号码：");
							for(int ai =0;ai<inputNumber.length;ai++){
								//Arrays.sort(inputNumber+"\t");//排序
							System.out.print(inputNumber[ai]+"\t");
							}
							System.out.println("\n随机的号码：");
							for(int ai =0;ai<randomNumber.length;ai++){
								//Arrays.sort(randomNumber+"\t");//排序
								System.out.print(randomNumber[ai]+"\t");
								}
							//调试判断
							//进行输出
							if(num > 0){
								System.out.println("\n\n\n\t\t\t****恭喜您*中奖啦****\n中奖号码为:\n");
								for(int ai =0;ai<num;ai++){
									//Arrays.sort(prizeNumber+"\t");//排序
								System.out.print(prizeNumber[ai]+"\t");
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
					break;
				case 4:
					System.out.println("欢迎进入商品换购系统\n请输入消费金额");
					int paymoney=input.nextInt();
					System.out.println("是否参加商品换购活动\n1.满50元,加2元换购百事可乐一瓶\n2.满100元,加3元换购500ml可乐一瓶\n满100元,加10元换购5公斤面粉\n3.满200元,加10元换购一个苏泊尔炒菜锅\n5.满200元,加20元换购欧莱雅爽肤水\n0.不换购");
					int iiii = input.nextInt();
					switch(iiii){
					case 1:
						if(paymoney>=50){
							System.out.println("成功换购百事可乐一瓶\n总消费金额:"+(paymoney+2));
							break;
						}else{
							System.out.println("消费金额不足50");
						}
						break;
					case 2:
						if(paymoney>=100){
							System.out.println("成功换购500ml可乐一瓶\n总消费金额:"+(paymoney+3));
							break;
						}else{
							System.out.println("消费金额不足100");
						}
						break;
					case 3:
						if(paymoney>=100){
							System.out.println("成功换购5公斤面粉一袋\n总消费金额:"+(paymoney+10));
							break;
						}else{
							System.out.println("消费金额不足100");
						}
						break;
					case 4:
						if(paymoney>=200){
							System.out.println("成功换购苏泊尔炒菜锅一个\n总消费金额:"+(paymoney+10));
							break;
						}else{
							System.out.println("消费金额不足200");
						}
						break;
					case 5:
						if(paymoney>=200){
							System.out.println("成功换购欧莱雅爽肤水一瓶\n总消费金额:"+(paymoney+20));
							break;
						}else{
							System.out.println("消费金额不足200");
						}
						break;
					case 0:
						System.out.println("退出");
						break;
					}
				}
				
				break;
			case 4://注销
				i = 0;
				ii = 0;
				iii = 0;
				System.out.println("注销");
				break;
			}
			break;
		case 2://退出
			System.out.println("退出");
		}
		}else{//判断数字
			System.out.println("输入数字");
		}
	}
}
