package 笔记例子.Eg04;

public class Cat extends Animal implements IEat {

	private int a;
	private int b;
	//默认调用父类的无参构造器.想使用,也没有无参的咋办??......必须使用super();显示调用
//	public Cat() {
//		System.out.println("Cat的构造器执行了");
//	}
	
	public Cat(int a) {
		super(a);//有效代码第一行,即一个构造器不能同时有this()和super()
	}
	public Cat(){
		this(1);//
	}
	public int getA() {
		System.out.println("读取a的方法");
		return a;
	}

	public void setA(int a) {
		System.out.println("写入a方法");
		if (a > 0) {
			this.a = a;
		} else {
			System.out.println("必须大于0");
		}
	}

	public int getB() {
		System.out.println("读取b方法");
		return b;
	}

	public void setB(int b) {
		System.out.println("写入b方法");
		this.b = b;
	}


	public void eat() {// 方法重写&&接口方法
		System.out.println("猫具有吃肉的功能");
	}

	public void run() {// 接口方法
		System.out.println("猫具有跑的能力");

	}

	// 用于显示所有的方法和属性,用到super和this
	public void all() {
		System.out.println("子类数据有:" + this.a + this.age + this.name + this.b
				+ "父类" + + super.age +super.name);
	}
}
