package 笔记例子;

import java.util.ArrayList;
import java.util.List;
/**
 * 泛型:广泛的类型,类似于C++中的的模板,从jdk1.5开始
 * 1.应用于类,在类的右面用<E>表示,E就是泛型,在类定义时不确定类型
 * 		在类创建时,指定类型
 * 2.应用于集合,在集合类型后面用<E>表示,E就是集合元素类型,
 * 3.应用于Map,在Map右面用<E,F>表示,E就是key的类型,F代表value的类型
 * 4.应用于集合,方法参数.
 * 		通配符:
 * 			?表示所有类型
 * 			? extends B 表示B类与B类的子类
 * 			? super B 表示B类与B类的父类
 * 泛型好处:
 * 	1.重要性,类似于模板,提高代码重用
 * 	2.安全性.提供集合的安全类型检查
 * 		
 *  
 */

class A{
}
class B extends A{
	
}
class C extends B{
	
}
public class 泛型1 {
public  void testMain(List<? extends A> list){
	
}
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();

	//new test().testMain(list);//报错必须是A的父类
		new 泛型1().testMain(new ArrayList<B>());
	}

}
