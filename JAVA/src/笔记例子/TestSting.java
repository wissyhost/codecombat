package 笔记例子;

public class TestSting {
	public void testCreatString() {
		String str = "abc";
		String str1 = "abc";
		String str3 = new String("abc");
		String str4 = new String("abc");
		System.out.println(str == str1);// t
		System.out.println(str1 == str3);// f
		System.out.println(str3 == str4);// f
		System.out.println(str3.equals(str4));// t
	}

	public void testConcat() {
		String str = "abc";
		str.concat("123");
		System.out.println(str);// ab
		String str1 = str.concat("123");
		System.out.println(str + str1);// abc 123
	}

	public void testRepelace() {
		String str = "aaaaaabc";
		String str1 = str.replace("a", "5");// 将a全部替换成5
		System.out.println(str1);
	}

	public void testSubString() {
		String str = "aaabc";
		String str1 = str.substring(0, 2);// 返回从0到2的字符串
		System.out.println(str1);
	}

	public void testToLowCase() {
		String str = "AAAAAAAggggg";
		String str1 = str.toLowerCase();// 转换成小写
		System.out.println(str1);
	}

	public void testToUpcase() {
		String str = "aaabc";
		String str1 = str.toUpperCase();// 转换为大写
		System.out.println(str1);
	}

	public void testTrim() {
		String str = "  aa  ab  c  ";
		String str1 = str.trim();// 忽略前后空格
		System.out.println(str1);
	}

	public void testToString() {
		String str = "  a  aa  bc";
		String str1 = str.toString();// 返回字符串
		System.out.println(str1);
	}

	// 查询功能
	public void testStartwith() {
		String str = "hhhhhbc";
		System.out.println(str.startsWith("hhh"));
	}

	public void testEndwith() {
		String str = "hhhhhbc.bccc";
		System.out.println(str.endsWith(".bccc"));
	}

	public void testIndexOf() {
		String str = "hhhhhbc";
		System.out.println(str.indexOf("b"));
	}

	public void testLastIndexOf() {
		String str = "hhhhhbclkmkkb";
		System.out.println(str.lastIndexOf("b"));
	}

	// 比较功能
	public void testEquals() {
		String str = "hhhhhbclkmkkb";
		System.out.println(str.equals("b"));
	}

	public void testEqualsIgnoreCse() {
		String str = "hhhhhbklkmkkb";
		System.out.println(str.equalsIgnoreCase("BK"));
	}

	public void testCompareTo() {
		String str = "abdc";
		System.out.println(str.compareTo("ab"));// str在字符串之前返回负数
	}

	public void testCompareToIgnore() {
		String str = "GGGBBBHH";
		System.out.println(str.equals("gggc"));// false
	}

	// 其他方法
	public void testCharAt() {
		String str = "GGGBBBHH";
		System.out.println(str.charAt(5));// 查询5位置的字符
	}

	public void testLength() {
		String str = "GGGBBBHH";
		System.out.println(str.length());// 返回字符串的长度
	}

	public void testSqlit() {
		String str = "GGGBBBHH";
		String[] str1 = str.split("B");// 从参数切开
		for (String string : str1) {
			System.out.print(string+"\t");
		}
	}

	public static void main(String[] args) {
		// new TestSting().testSubString();
		// new TestSting().testToLowCase();
		// new TestSting().testToString();
		// new TestSting().testToUpcase();
		// new TestSting().testTrim();
		// new TestSting().testRepelace();
		// new TestSting().testStartwith();
		// new TestSting().testEndwith();
		// new TestSting().testIndexOf();
		// new TestSting().testLastIndexOf();
		// new TestSting().testEquals();
		// new TestSting().testEqualsIgnoreCse();
		// new TestSting().testCompareTo();
		// new TestSting().testCompareToIgnore();
		new TestSting().testCharAt();
		new TestSting().testLength();
		new TestSting().testSqlit();
	}
}
