package 笔记例子;

/**
 * 
 * 工厂模式:
 * 1.有一个接口,或抽象类.
 * 2.实体类实现这个接口
 * 3.在业务类中定以一个工厂方法,参数是String(放的是类的信息),返回对应实体类的对象
 *	我自己想的:抽象父类不实现或接口,子类去实现这个方法..
 *		分为简单工厂模式和抽象工厂模式,区别在于抽象工厂模式创建对象时占用内存小,不利于用于创建单个对象.
 *		简单工厂模式是只创建一个对象,具有创建时的复杂性,
 * @param <Sleep>
 * @param <Mood>
 */
abstract class Sound<Sleep, Mood>{
	public abstract Mood jjj();
	public abstract Sleep jjn();
}
class kk<Sleep, Mood> extends Sound<Sleep, Mood>{
	public Mood jjj(){
		System.out.println("jjjj");
		return null;
	}
	public Sleep jjn() {
		System.out.println("jjn");
		return null;
	}
}
interface Phone{
	String music();
}
class IPhone implements Phone{//类继承接口
	public String toString(){//重写父类的toString方法
		return "苹果";
	}
	public  String music(){//实现接口的方法
		System.out.println("苹果就能听音乐");
		return null;
	}
}
class xiaomi implements Phone{
	public String toString(){
		return "小米";
	}

	@Override
	public String music() {
		System.out.println("小米就有音乐功能");
		return null;
	}
}

class das implements Phone{
	public String toString(){
		return "大神";
	}

	@Override
	public String music() {
		// TODO Auto-generated method stub
		System.out.println("大神也可以听歌哦");
		return null;
	}
}

public class  工厂模式 {
	public Phone creatPhone(String Phonename){//Phone是接口,通过接口去创建对象
		if("xiaomi".equals(Phonename)){
			return new xiaomi();
		}
		if("das".equals(Phonename)){
			return new das();
		}
		return null;
	}
	public static void main(String[] args) {
		工厂模式 jj=new 工厂模式();
		Phone phone =jj.creatPhone("xiaomi");//多态
		System.out.println(phone.music());
		//System.out.println(jj.creatPhone("xiaomi").music());
	}

}
