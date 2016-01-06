package 笔记例子;

public class 自定义异常AgeOutOfBoundException extends Exception {

	public 自定义异常AgeOutOfBoundException() {
		super("年龄超出界限异常");
	}

	public 自定义异常AgeOutOfBoundException(String messsing) {
		super(messsing);
	}
	
}
