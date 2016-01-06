package 笔记例子;

import java.util.Scanner;

class Dog2 {
	private String name;
	private int body = 60;
	private String type;
	private String pinzhong;

	// public Dog() {
	// Scanner input = new Scanner(System.in);
	// String temp = input.next();
	// System.out.println("欢迎来到宠物店！");
	// System.out.println("请输入要领养宠物的名字");
	// setName(input.next());
	// System.out.println("请选择要领养的宠物类型：1)狗狗 2)企鹅");
	// setType(input.next());
	// System.out.print("请选择" + gettype() + "的品种");
	// if (gettype().equals("狗狗")) {
	// System.out.print("\t1)聪明的拉布拉多犬");
	// System.out.print("\t2)酷酷的雪纳瑞");
	// }
	// if (gettype().equals("企鹅")) {
	// System.out.println("聪明的拉布拉多企鹅");
	// System.out.println("酷酷的雪纳瑞企鹅");
	// }
	// setPinZhong(input.next());
	// body = 60;
	// }

	// 封装
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setBody(int body) {
		if (body > 0 && body <= 100) {
			this.body = body;
		} else {
			System.out.println("输入生命值有误在1-100之间");
		}

	}

	public int getBody() {
		return body;
	}

	public void setType(String type) {
		if (type.equals("1")) {
			this.type = "狗狗";
			return;
		}
		if (type.equals("2")) {
			this.type = "企鹅";
			return;
		} else {
			System.out.println();
		}
	}

	public String gettype() {
		return type;
	}

	public void setPinZhong(String pinzhong) {
		if (type.equals("狗狗")) {
			if (pinzhong.equals("1")) {
				this.pinzhong = "聪明的拉布拉多犬";
			} else if (pinzhong.equals("2")) {
				this.pinzhong = "酷酷的雪纳瑞";
			} else {
				System.out.println("输入1有误");
			}
		} else {
			if (pinzhong.equals("1")) {
				this.pinzhong = "聪明的拉布拉多企鹅";
			} else if (pinzhong.equals("2")) {
				this.pinzhong = "酷酷的雪纳瑞企鹅";
			} else {
				System.out.println("输入2有误");
			}
		}
	}

	public String getPinZhong() {
		return pinzhong;
	}

	// 显示细节
	public void detail() {
		// System.out.println(dog);
		System.out.println("宠物的自白：");
		System.out.println("我叫：" + getName() + "  类型：" + gettype() + "   品种："
				+ getPinZhong() + "  生命值：" + getBody());
	}

	// 领养
	public static Dog2 lingyang() {
		Scanner input = new Scanner(System.in);
		Dog2 dog = new Dog2();
		System.out.println("欢迎来到宠物店！");
		System.out.println("请输入要领养宠物的名字");
		dog.setName(input.next());
		System.out.println("请选择要领养的宠物类型：1)狗狗 2)企鹅");
		dog.setType(input.next());
		System.out.print("请选择" + dog.gettype() + "的品种");
		if (dog.gettype().equals("狗狗")) {
			System.out.print("\t1)聪明的拉布拉多犬");
			System.out.print("\t2)酷酷的雪纳瑞");
		}
		if (dog.gettype().equals("企鹅")) {
			System.out.println("聪明的拉布拉多企鹅");
			System.out.println("酷酷的雪纳瑞企鹅");
		}
		dog.setPinZhong(input.next());
		return dog;// 如果为别的返回值以下接收时会找不到返回值
	}
}

public class Eg01 {
	public static void main(String[] args) {
		// Scanner input=new Scanner(System.in);
		Dog2 dog1 = Dog2.lingyang();// 将lingyang返回值接收并更名为dog1实际还为dog对象
		dog1.detail();// 通过dog返回值得对象对象访问
		// 以上两句相当于Dog2.lingyang().detail();

	}

}
