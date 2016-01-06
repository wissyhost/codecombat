package 笔记例子;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


class 学生{
	private String name;
	private int age;
	private boolean sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public 学生(String name, int age, boolean sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
}

public class 学生集合 {
	private Collection std=new ArrayList();
		学生[] aa=new 学生[31];
		public void initStd(){
				for (int i = 0; i < aa.length; i++) {
					aa[i]=new 学生("第"+i+"个学生", i+1, ((i%2)==0)?true:false);
					std.add(aa[i]);
				}
//				for (int j = 0; j < aa.length; j++) {
//					std.add(aa[i]);
//				}
		}
		public void showStd(){
			Iterator it = std.iterator();
			for (int i = 0; i < aa.length; i++) {
				if(it.hasNext()){
					学生 b= (学生) it.next();
					System.out.println(b.getName()+b.getAge()+b.isSex());
				}
			}
		}

	public static void main(String[] args) {
		学生集合 j=new 学生集合();
		j.initStd();
		j.showStd();

	}

}
