package 笔记例子;

public class 泛型2 implements Cloneable {
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
		
		泛型2 k=new 泛型2();
		k.setAge(25);
		k.setName("555");
		k.setSex(true);
		try {
		泛型2 j=(泛型2) k.clone();
		System.out.println(j.getName()+j.getAge()+j.isSex());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

	}

	
}
