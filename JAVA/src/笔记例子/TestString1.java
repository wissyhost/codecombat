package 笔记例子;



public class TestString1 {
	public void testString(){
		long t1=System.currentTimeMillis();
		String str = "abc";
		for (int i = 0; i < 100000; i++) {			
			str=str.concat("a"+i+"");
		}
		System.out.println(t1-(System.currentTimeMillis()));
	}
	public void testStringBuffer(){
		long t1=System.currentTimeMillis();
		String str1 = "abc";
		StringBuffer str=new StringBuffer(str1);
		for (int i = 0; i < 100000; i++) {			
			str=str.append("a"+i+"");
		}
		System.out.println(t1-(System.currentTimeMillis()));
	}
	public void testStringBuilder(){
		long t1=System.currentTimeMillis();
		String str1 = "abc";
		StringBuilder str=new StringBuilder(str1);
		for (int i = 0; i < 100000; i++) {			
			str=str.append("a"+i+"");
		}
		System.out.println(t1-(System.currentTimeMillis()));
	}
	public static void main(String[] args) {
		TestString1 jj=new TestString1();
		jj.testString();
		jj.testStringBuffer();
		jj.testStringBuilder();

	}

}
