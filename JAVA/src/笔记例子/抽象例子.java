package 笔记例子;
/**
 *abstract：抽象实验的测试
 * @author root
 *结果：不能用抽象类创建实例化自己，只能是其不是抽象的子类
 */
//父类
abstract  class AAA {
	/**
	 * 抽象类。。。。不能实例化自己，只能实例化自己；
	 */

	public abstract void testAbstract();

}
//子类
 class BBB extends AAA {
	/**
	 * 如果子类没有实现抽象方法，则该子类也没抽象类
	 */
	//抽象方法的实现
	public void testAbstract(){
		System.out.println("抽象方法的实现方法");
	}

}
//测试类
public class 抽象例子{
	public static void main(String[] args) {
		//以下报错不能实例化父类，因为有未实现的抽象方法
		//A a=new A();
		AAA a=new BBB();//用到多态
		a.testAbstract();
	}

}

