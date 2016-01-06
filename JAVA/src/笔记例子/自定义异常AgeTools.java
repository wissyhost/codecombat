package 笔记例子;
import java.io.IOException;



public class 自定义异常AgeTools {
	public boolean isAge(int Age) throws 自定义异常AgeOutOfBoundException{
		boolean ret =true;
		if(Age<0||Age>=150){
			ret =false;
			 throw new  自定义异常AgeOutOfBoundException();
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println("开始自定义异常抛出");
		自定义异常AgeTools  oo= new 自定义异常AgeTools();
		int Age = 155;
		try {
			System.out.println(oo.isAge(Age));
		} catch (自定义异常AgeOutOfBoundException e) {
			System.out.println("catch成功捕获正在处理........");
			Age =150;
			e.printStackTrace();
			Runtime rn=Runtime.getRuntime();
					try {
						rn.exec("C:\\Program Files (x86)\\Tencent\\QQ\\Bin\\QQ.exe");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			System.gc();
		}
		System.out.println("自定义异常处理完毕");
	}

}
