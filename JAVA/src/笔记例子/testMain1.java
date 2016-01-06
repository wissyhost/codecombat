package 笔记例子;

public class testMain1 implements Cloneable {
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

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public static void main(String[] args) {
		
		testMain1 k=new testMain1();
		k.setAge(25);
		k.setName("555");
		k.setSex(true);
		try {
		testMain1 j=(testMain1) k.clone();
		System.out.println(j.getName()+j.getAge()+j.isSex());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

	}

	
}
