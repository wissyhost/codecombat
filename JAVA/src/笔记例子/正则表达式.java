package 笔记例子;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/** 正则表达式：
* 		验证字符串是不是符合指定的格式
*      * 	：零到任意多个字符
*      . 	: 一个任意字符
*      {n}	 ：n个字符
*      ^ 	:表示以什么字符开始
*      $ 	：表示以什么字符结束
* 	字符类型：
* 		[abc] 		a、b 或 c（简单类） 
		[^abc] 		任何字符，除了 a、b 或 c（否定） 
		[a-zA-Z] 	a 到 z 或 A 到 Z，两头的字母包括在内（范围） 
		[a-d[m-p]] 	a 到 d 或 m 到 p：[a-dm-p]（并集） 
		[a-z&&[def]] d、e 或 f（交集） 
		[a-z&&[^bc]] a 到 z，除了 b 和 c：[ad-z]（减去） 
		[a-z&&[^m-p]] a 到 z，而非 m 到 p：[a-lq-z]（减去） 
		. 			任何字符（与行结束符可能匹配也可能不匹配） 
		\d 			数字：[0-9] 
		\D 			非数字： [^0-9] 
		\s 			空白字符：[ \t\n\x0B\f\r] 
		\S 			非空白字符：[^\s] 
		\w 			单词字符：[a-zA-Z_0-9] 
		\W 			非单词字符：[^\w] 
*/

public class 正则表达式 {

	public void test(){
		Pattern pa= Pattern.compile("a*b");//表示0到任意多的a和一个b
		Matcher m=pa.matcher("aaaaaaaaaaaaaab");//true
		Matcher m1=pa.matcher("a11b");//false
		System.out.println(m.matches()+"\t"+m1.matches());
		System.out.println(Pattern.matches("a*b", "aaaab"));
	}
	public static void main(String[] args) {
		new 正则表达式().test();
	}

}
