package zuoYe;
import java.util.Scanner;
public class WanNianLi2 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入年份");
		int year=input.nextInt();
		System.out.println("请输入月份");
		int yue=input.nextInt();
		System.out.println("请输入日期");
		int day=input.nextInt();
		int maxDay=0;
    	if(yue==1||yue==3||yue==5||yue==7||yue==8||yue==10||yue==12){
			maxDay=31;
		}else if(yue==4||yue==6||yue==9||yue==11){
			maxDay=30;
		}else{
			if(year%4==0&&year%100!=0||year%400==0){//判斷是否是閏年
				maxDay=29;
			}else{
				maxDay=28;
			}
	}
		int sumDay=0;
		for(int Year=1900;Year<year;Year++){
			if(Year%4==0&&Year%100!=0||Year%400==0){
				sumDay=sumDay+366;
			}else{
				sumDay=sumDay+365;
			}
		}
		//年的总天数
		for(int Yue=1;Yue<yue;Yue++){
			if(Yue==1||Yue==3||Yue==5||Yue==7||Yue==8||Yue==10||Yue==12){
				sumDay=sumDay+31;
			}else if(Yue==4||Yue==6||Yue==9||Yue==11){
				sumDay=sumDay+30;
			}else{
				if(year%4==0&&year%100!=0||year%400==0){//判斷是否是閏年
					sumDay=sumDay+29;
				}else{
					sumDay=sumDay+28;
				}
		}
		}
		sumDay=sumDay+day;
		System.out.println("从1900年1月1日到"+year+"年"+yue+"月"+day+"日 共"+sumDay);
		int i=(sumDay%7);
		System.out.println(year+"年"+yue+"月"+day+"日是星期"+i);
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		for(int k=1;k<=i;k++){
			System.out.print("\t");
		}
		for(int k=1;k<=maxDay;k++){
			if(sumDay%7==6){
				System.out.print(k+"\n");
			}else{
				System.out.print(k+"\t");
			}
			sumDay++;
		}		
	}
}

