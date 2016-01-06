package 笔记例子;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class mathTest {
	public void jjk(){
		Date oj= new Date();
		System.out.println(oj.toString());
		long tt= oj.getTime();
		System.out.println(tt);
	}
	public void format(){
		SimpleDateFormat jk= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(jk.format(new Date()));
		String nk="2015-12-5 12:25:14";
		try {
			System.out.println(jk.parse(nk));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar mm=Calendar.getInstance();
		mm.add(Calendar.YEAR, 1);
		mm.set(Calendar.MONTH,mm.get(Calendar.MONTH)+3);
		System.out.println(mm);
	}
	public void kk(){
		try {
			Process process = Runtime.getRuntime().exec("notepad.exe");
			Thread.sleep(20000);
			process.destroy();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(Math.floor(1.225));
System.out.println(Math.ceil(1.225));
System.out.println(Math.pow(2, 4));
System.out.println(Math.round(2.33365));
System.out.println(Math.sqrt(16));
//new mathTest().kk();
new mathTest().jjk();
new mathTest().format();
	}

}
