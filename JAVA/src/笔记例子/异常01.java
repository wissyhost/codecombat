package 笔记例子;
import java.io.FileInputStream;


public class 异常01 {
	/**
	 * Throwable:可抛出的类
	 * 有两个子类:Error ,Exception
	 * 1.Error一旦发生,系统一定会退出,Exception一旦发生可以处理	
	 * 1.程序员主要关注Exception,对Error无能为力
	 * Exception:异常
	 * 分类:RuntimeException运行时异常CheckException检查异常
	 * 1.运行时异常可以不显示的写try,catch检查异常必须写try,catch
	 * 2.检查异常发生在编译期,运行异常发生在解析执行期
	 * RuntimeException:
	 *	//运行异常
	 	* ArithmeticException
		 * ClassCastException
		 * 	IllegalAccessException
		 * IndexOutOfBoundsException
		 *  NullPointerException
	 *  //检查异常
	 * 		类没找到异常,IOException文件输入输出异常,没有这个方法异常NoSuchMethodException,
	 * 		数据库异常sqlException,
	 * 异常抛出:
	 * 		JAVA程序在运行过程中,发现异常,会产生一个异常对象
	 * 		把这个对象抛出给JAVA的运行时系统,这个过程称之为异常抛出
	 * 异常捕获:
	 * 		抛出的异常,JAVA运行时系统对其捕获,接收.如果接收到这个异常
	 * 		就称之为异常捕获到.如果没有捕获到.系统就停止运行
	 * 		运行时抛出的异常给catch块的参数赋值
	 * 		多catch块,如果异常具有父子类关系时,则子类放在上面,父类放下面
	 * 异常处理:
	 * 		对于捕获到的异常.进行处理.称之为异常处理
	 * finally:无论代码块有没有异常,它都会执行
	 * final,finally,finallize
	 * 1,final是修饰符,表示最终的,可以修饰类,方法,变量
	 * 		修饰类,表示类没有子类,修饰方法.表示方法不能被覆盖
	 * 		修饰变量,变量变常量
	 * 2.finally,表示异常处理的最后一个快,无论try产生不产生异常都会被执行
	 * 3.finallize,是Object类的方法,表示对象垃圾回收方法
	 * 
	 */
	public static void main(String[] args) {
		try {
			//System.out.println(1/0);
			int[] a= new int[12];
			a[0]=2;
			//FileInputStream fils=new FileInputStream("d://aa.txt");
		} catch (Exception e) {
			System.out.println("程序抛异常了");
			e.printStackTrace();
		//}
		}finally{
			System.out.println("异常处理完了");
		}
		System.out.println("程序没有异常了,走起~~~~~~");
	}

}
