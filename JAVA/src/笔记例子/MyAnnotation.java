
package 笔记例子;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//注解的注解
/**
* Retention:   表示注解影响范围
* RetentionPolicy.RUNTIME  :运行时级别
* RetentionPolicy.SOURCE   :源代码级别
* RetentionPolicy.CLASS    :类级别   
* Target					:目标,可以注解在那些地方
* Documented				:注解文档
* Inherited				:注解支持子类继承
* --->Target
*	ElementType.METHOD		:方法
*	ElementType.FIELD		:属性
*	ElementType.CONSTRUCTOR	:构造器
*	ElementType.PARAMETER	:方法参数
*	ElementType.LOCAL_VARIABLE:局部变量
*	ElementType.PACKAGE		:包
*	ElementType.TYPE		:类或接口
*/
@Retention(RetentionPolicy.CLASS)
//	元素类型				方法				属性						构造器					方法参数					局部变量					包				类或接口
@Target(value={ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.PARAMETER,ElementType.LOCAL_VARIABLE,ElementType.PACKAGE,ElementType.TYPE})
//@Documented
//@Inherited
public @interface MyAnnotation {
    public String name()default "tom";
    public int age();
    public boolean sex();
    public String value();
    
}
