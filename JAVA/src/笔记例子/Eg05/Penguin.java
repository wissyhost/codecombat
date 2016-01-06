package 笔记例子.Eg05;

public  class Penguin extends Pet {
	public Penguin(String name, int health, int love,String sex) {
		super(name, health, love);
		this.sex=sex;
	}
	@Override
	public void print(){
		super.print();
		System.out.println("性别:"+getSex());
	}
	private String sex; 
	public String getSex(){
		return sex;
	}
	public void jj() {
		System.out.println("抽象的方法jj");
		
	}

}
