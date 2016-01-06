package SIMS;
import zuoYe.WanNianLi;

public class Animal {
	/*
	 * @author wissy
	 * @date 2015,10,13
	 */
	//定义属性
	String name;
	boolean sex;
	int age;
	//定义方法
	public void show(){
		System.out.println("name:"+name+"sex:"+sex+"age:"+age);
	}
	public static void main(String[] args) {
		Animal i = new Animal();//创建对象
		//给属性辅值
		i.name = "jjjjj";
		i.age = 14;
		i.sex= true;
		//调用方法
		i.show();
		WanNianLi jj = new WanNianLi();
		jj.wanNianLi(1900, 2);
	}
}
