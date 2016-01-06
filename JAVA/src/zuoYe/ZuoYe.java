package zuoYe;
import java.util.*;
public class ZuoYe {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("可以输入10个数");
		int cardCode = (int)(Math.random()*10);//产生一个0-1的随机数并*10
		int  random  = input.nextInt();
		int test = (random/1000%10)+(random/100%10)+(random/10%10)+(random%10);
		System.out.println(test);
		boolean parzeUser= ((random/1000%10)+(random/100%10)+(random/10%10)+(random%10))> 20;
		if(parzeUser == true ){
			System.out.println("您是一级幸运客户");
		}else if(parzeUser == true &&(int)cardCode*10000 == random%10){
			System.out.println("您二级幸运客户");
		}else if(parzeUser == true &&(int)cardCode*10000 == random%10&&(int)cardCode*1000 == random/10%10){
			System.out.println("您是三级幸运客户");
		}else if(parzeUser == true &&(int)cardCode*10000 == random%10&&(int)cardCode*1000 == random/10%10 &&(int)cardCode*100 == random%10){
			System.out.println("您是四级幸运客户");
		}else if(parzeUser == true &&(int)cardCode*10000 == random%10&&(int)cardCode*1000 == random/10%10 &&(int)cardCode*100 == random%10&&(int)cardCode*10 == random/1000%10){
			System.out.println("您是五级幸运客户");
		}else{
			System.out.println("您不是幸运客户");
		}
	}

}

