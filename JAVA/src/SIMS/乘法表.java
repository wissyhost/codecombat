package SIMS;

public class 乘法表 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*for (int i = 1; i < 10; i++) {
			 for(int j = 10;j>i;j--){
				System.out.print("——");
			}
			for(int j =0;j<i*2-1;j++){
				System.out.print("*");
			}
			for(int j = 10;j>i;j--){
				System.out.print("——");
			}
			
			//for(int j= 1;j<i;j++){
			//	System.out.print("*");
			//}
			System.out.println();
		}*/
		int y=7;//设置循环次数
		for(int i=0;i<y;i++){//外层循环行数
			if(i<=(y/2)){//打印2/1的上面三角
				for(int j=0;j<i;j++){//打印空格
					System.out.print("-");
				}
				for(int j=y;j>((i*3)-(i*1));j--){//打印上面的三角
					System.out.print("+");
				}
			}else{//2/1结束
				//System.out.print("jj");
				for(int j=1;j>i;j--){//打印空格
					System.out.print("-");
				}
				for(int j=1;j<((i*3)-(i*1)-2);j++){//打印下面的三角
					System.out.print("+");
				}
			}
			System.out.println();
		}
		//for(;;);最容易的死循环
		
		}
}
