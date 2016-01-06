package SIMS;
	import java.util.Scanner;
public class xxx {

		/**
		 * @param args
		 */
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			double[] a={199.9,250.5,300,499,100};
			Scanner scan=new Scanner(System.in);
			double sum=0;
			
			System.out.println("请输入本月的消费记录");
			
			for (int g=0;g<a.length;g++){
				System.out.print("请输入第"+(g+1)+"购物金额");
				double t=scan.nextDouble();
				a[g]=t;
			}	System.out.println("序号"+"\t"+"金额(元)");
				for	(int g=0;g<a.length;g++){
					System.out.println(g+1+"\t"+a[g]);
				sum=sum+a[g];
			}
				System.out.println("总金额"+"\t"+sum);
		
	}

}
