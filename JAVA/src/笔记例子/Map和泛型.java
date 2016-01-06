package 笔记例子;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * HashMap与HashTable
 * 1.HashMap不安全,但效率快,key可为null
 * 2.HashTable安全,但效率低,key不为null
 * 泛型:通常用在集合中用<>表示
 * 
 *
 */
class fanxing{
	public void fx(){
		Set<Integer> set = new HashSet<Integer>();
		set.add(4444);
		//set.add("555");报错因为指定了集合的类型
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());//不用强转
		}
}
	public void fx2(){
	Map<Integer, String> jj = new HashMap<Integer,String>();	
	jj.put(12, "lgg");
	Set<Integer> mm=jj.keySet();
	Iterator<Integer> it = mm.iterator();
	while(it.hasNext()){
		int xx=it.next();
		System.out.println(jj.get(xx));
	}
	}
}
class lalala<AS,QS>{//类的参数
	AS mm;
	QS jj;
	public void ls(){
		System.out.println(mm.toString()+jj.toString());
		System.out.println(""+mm+jj);
	}
	public AS getMm() {
		return mm;
	}
	public void setMm(AS mm) {
		this.mm = mm;
	}
	public QS getJj() {
		return jj;
	}
	public void setJj(QS jj) {
		this.jj = jj;
	}
}
class testlalala{
	lalala<Integer,Integer> jj = new lalala<Integer,Integer>();
}
class Students {
	public int getXh() {
		return xh;
	}

	public void setXh(int xh) {
		this.xh = xh;
	}

	private String name;
	private boolean sex;
	private int age;
	private int xh;

	public Students() {
		super();
	}

	public Students(String name, boolean sex, int age, int xh) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.xh = xh;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

public class Map和泛型 {
	public static void main(String[] args) {
//		Map sm = new TreeMap();
//		Students[] students = new Students[31];
//		for (int i = 0; i < students.length; i++) {
//			students[i] = new Students("王" + i, i % 2 == 0 ? true : false, i + 17, 15091 + i);// 准备数据
//			sm.put(students[i].getXh(), students[i]);// 放入数据
//		}
//		Set stu = sm.keySet();// 接收key集合
//		Iterator it = stu.iterator();// 获取迭代
//		while (it.hasNext()) {// 判断下一个是否为空
//			// int stu1=(Integer)it.next();//取下一个学号
//			// Students temp=(Students)sm.get(stu1);//
//			Students temp = (Students) sm.get((Integer) it.next());// 获取下一个学号并从map中获取对象
//			System.out.println("姓名:" + temp.getName() + "\t年龄:" + temp.getAge() + "\t性别:" + (temp.isSex() ? "男" : "女")
//					+ "\t学号:" + temp.getXh());
//
//		}
		new fanxing().fx2();
	}

}
