package 笔记例子;

public class Annote {
	/**
	 * 定义数据的数据叫做元数据 
	 * 注解对元数据的注释.需要编译器检查 
	 * 1.系统提供的注解有
	 * 		@Override:方法重写
	 * 		@Deprecated:不建议使用
	 * 		@Supppresscated:压制警告
	 * 		@Document:注解的文档注释
	 */
	/**
	 * 元数据:方法,属性,类 注解对元数据进行注释
	 */
	public static void main(String[] args) {

	}

}
class A1{
	public void a(){
		
	}
}
class B1 extends A1 {
	@Override
	public void a(){
		//@SuppressWarnings(value = { "unused" })
		@SuppressWarnings("unused")
		int a;
		System.out.println("此方法被重写");
	}
	@Deprecated
	public void b(){
		System.out.println("已过时的方法");
	}

	
}
