/**
 * 
 */
package 笔记例子;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wissy
 *
 */
@Retention(RetentionPolicy.RUNTIME)
//元素类型				方法				属性						构造器					方法参数					局部变量					包
@Target(value={ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.PARAMETER,ElementType.LOCAL_VARIABLE,ElementType.PACKAGE})
@Documented
@Inherited
public @interface MyAnnotation1 {
	  public String name()default "tom";
	    public int age();
	    public boolean sex();
	    public String value();
}
