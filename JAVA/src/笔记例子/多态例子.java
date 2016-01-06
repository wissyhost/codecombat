package 笔记例子;
//父类
class Person {
	public String name;

	public Person(String name) {
		this.name = name;
	}

	public Person() {
		System.out.println("父类");
	}

	public void test() {
		System.out.println("父类的方法test");
	}

	public void test1() {
		System.out.println("父类的方法test1");
	}

}

// 子类

class Student extends Person {

	public Student(String name) {
		super(name);
	}

	public Student() {
		super();
	}
//子类重写父类方法
	public void test() {
		System.out.println("子类重写了父类的方法test");
	}
//子类自己的方法
	public void test2() {
		System.out.println("子类自己的方法test2");
	}
}

// 单例
 class AA {
	private static AA a = new AA();//2.1静态的对象，，并且私有化

	private AA() {//1.私有化构造器
		super();
	}

	public static AA getAA() {//如果第2步对象为是有的则创建公共的方法，返回这个对象。public就不用了
		return a;
	}
}

// 测试类
public class 多态例子 {

	public static void main(String[] args) {
		 Person ff= new Person();//不是多态，父类对象实例化父类
		 Student kl= new Student("kk");//不是多态，子类对象实例化子类
		Person kj = new Student();//多态：用父类的对象放子类的地址；访问范围：父类的属性和方法和子类重写的方法，优先访问子类重写的方法；
		kj.test();//父类的方法
		kj.test1();//子类重写的方法
		//以下不能运行，因为多态不能访问子类的方法；
//		kj.test2();
	}
}
