package 笔记例子;
/**
 * 枚举类
 	1.是一个特殊的类,它的的实例是长量
 	2.所有的枚举都继承自Enum类
 	3.枚举类实例是固定的
 		默认都是public static final
 		只能放在枚举类的第一行,最后一个";"可以省略
 	4.枚举类默认是final
 	5.枚举类可以有静态成员可非静态成员(属性和方法)
 	6.枚举类可以有构造器;默认是private
 			调用在枚举实例后面(实参)调用
 	7.枚举类可以有抽象方法.抽象方法的实现在具体实例后面,以匿名名类的方式实现
 	8.枚举类不能继承其他类,因为它已经继承了Enum类,但是可以实现接口,实现方法同上
 	9.枚举类不能用new创建对象
 	10.枚举和switch同用很好
 		switch里面可以有byte short char int jdk1.7以后有 String (enum)枚举
 
 */
 enum Enum1{
	 nan("男"){//对象(形参)
		 public void test(){//nan自己的test方法
			 System.out.println(name);
		 }
	 },nv("女"){
		 public void test(){//nv自己的test方法
			 System.out.println(name);
		 }
	 };
	 public String name;//公共变量
	 public void test(){//公共的测试方法
		 System.out.println(name);
	 }
	 private Enum1 (String name){//构造器
		 this.name=name;
	 }
 }
public class 枚举{
	public static void main(String[] args) {
		Enum1[] en=Enum1.values();//values是返回枚举对象数组
		for (int i = 0; i < en.length; i++) {
			System.out.println(en[i].name());
		}
		Enum1.nan.test();//nan自己的方法
	}
}
