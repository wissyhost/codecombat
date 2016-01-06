package 笔记例子;

import java.io.Serializable;
 interface MyInterface1 extends MyInterface2,MyInterface3 {//接口与接口之间是多继承的
	public void myinterface1();

}

interface MyInterface2 {
	public String name2="name2";//默认public static final
	public void  myinterface2();//默认是public abstract

}
interface MyInterface3 {
	public void myinterface3();

}


abstract class Myclass1 implements MyInterface1{//继承了接口但是没有实现方法，所以为abstract修饰的，若全部实现则不用
	public void myinterface1(){

	}
}
 public abstract class   接口例子 extends A implements MyInterface1,Serializable{
//, MyInterface2, MyInterface3 {// 可以继承一个父类和多个接口，用逗号分割
	@Override
	public void myinterface3() {//方法实现
			System.out.println("3");
	}

	@Override
	public void myinterface2() {
		System.out.println("2");
	}
	public void myinterface1(){
		System.out.println("1");
	}
	public static void main(String[] args) {
//		MyInterface1 m1 = new MyInterface1() ;
//		MyInterface2 m2 = new MyInterface1() ;
//		MyInterface3 m3 = new MyInterface1() ;//多态
//		m1.myinterface1();//方法调用
//		m1.myinterface2();
//		m1.myinterface3();
//		m2.myinterface2();
//		m3.myinterface3();

	}

	

	
}
