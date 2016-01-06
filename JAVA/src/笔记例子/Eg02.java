package 笔记例子;
/*
* java方法和构造器的重载可有多种不同的方法(即名字相同,参数列表不同)
 * 是否是同一个,看(顺序,个数,类型)
*/
public class Eg02 {
	int a;
	int b;
	public Eg02(){
		System.out.println("无参构造器");
	}
	public Eg02(int a){
		System.out.println("有参构造器1");
	}
	public Eg02(String a){
		System.out.println("有参参构造器2");
	}
	//.......等等可有有许多种,
	public void Method(int a){
		System.out.println("int参方法1");
	}
	public void Method(String b,int a){
		System.out.println("int&&String参方法1");
	}
	public int Method(){
		System.out.println("无参int返回值方法1");
		return 12;
	}
	public static void main(String[] args) {
		Eg02 eg02=new Eg02();
		Eg02 eg021=new Eg02("12");
		Eg02 eg022=new Eg02("ll");
		eg022.Method();
		eg022.Method(12);
		eg022.Method("ll",12);
		//等等都可以调用
	}
	
}
