package 笔记例子;


public class 异常02 {
	/**
	 * throws:
	 * 写在方法声明中,在参数后面,在方法体前面
	 * 2.throws 后接异常类型,多个异常用","号隔开
	 * 3.方法抛出异常后,这个异常叫由调用者进行处理
	 * 	如果方法的调用者,不处理,可以继续往外抛异常
	 * 	直到代码处理为止,否则程序退出 
	 * throw和throws的区别
	 * 		1.throw后面接异常对象,而且只能接一个对象
	 * 		2.throws后面接的是异常类型,可以是多个类型,多个类型之间用","号分割
	 * 		3.throws 在方法体内进行书写,表示手动抛出异常.throes在方法申明处填写
	 * 表示方法需要捕获到的异常类型
	 * 
	 */
	public void kk() throws ArithmeticException{
		int l=45/0;
		
	}

	
	public static void main(String[] args) {
		异常02 k=new 异常02();
		try {
				k.kk();
		} catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println("外异常处理完毕");
		}
	
	}

}
