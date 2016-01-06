package 笔记例子;

public class Eg03 {
	/*
	 * 单例的4个步骤
	 */



	private static Eg03 eg03 =new Eg03();//2.)私有的对象
	private Eg03(){//1.)私有的构造器
	}
	public static Eg03 Eg03Instdence(){//3.)通过共有的方法返回对象
		return eg03;
	}
	
	public static void main(String[] args) {
		Eg03 eg003=Eg03.Eg03Instdence();//4.)通过类名.静态方法访问
		Eg03 eg004=Eg03.Eg03Instdence();
		System.out.println(eg003);//两个地址一样说明,是同一类
		System.out.println(eg004);
	}
}
