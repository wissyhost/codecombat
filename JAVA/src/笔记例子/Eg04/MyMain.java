package 笔记例子.Eg04;

public class MyMain {
	public static void main(String[] args) {
		Animal f=new Animal(2);//创建父类的父类实例化对象
		Animal z=new Cat(3);//多态   //创建父类的子类实例化对象
		IEat i= new Cat(4);//接口    //创建cat的接口实例化对象
		f.age=75;//父类的属性
		z.age=15;//子类的属性
		f.ect();//父类的方法
		z.ect();//子类的方法
		i.eat();//接口对象不能访问接口所没有的方法
		i.run();//接口方法
		Cat zz=new Cat(5);//多态只能访问父类所共有的,不能访问父类没有的
		/*
		 * z.setA(2);
		 * z.getA();
		 * z.setB(25);		都是错的 z是父类对象的子类
		 * z.getB();
		 */
		zz.setA(2);
		zz.getA();
		zz.setB(25);
		zz.getB();
	}

}
