package 笔记例子;
class Animal {
	private void sound(Animal a) {
		System.out.println(a+"唱歌唱的好");
	}
}
class Cat extends Animal{
	public void Eat(){
		System.out.println("猫吃肉");
	}
}
class Dog extends Animal{
	public void Eat(){
		System.out.println("狗啃骨头");
	}
}
public class Instanceof {
	/**instanceof :关系运算符
	 * 用来判断对象是不是类的实例
	 * 语法: 对象 instanceof 类   	结果返回true和false
	 * 要求:有父子关系.
	 */
	public Animal animal(Animal an){//方法
		if( an instanceof Cat){
			Cat cat =(Cat)an;
			cat.Eat();
		}
		if(an instanceof Dog){
			Dog dog =(Dog)an;
			dog.Eat();
		}
		return an;
	}
	public static void main(String[] args) {
		Instanceof i= new Instanceof();
		Cat mm=new Cat();
		Animal gg= new Dog();//多态对象
		Animal a =new Animal();
		i.animal(a);//调用方法
	}
	

}
