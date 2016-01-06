package 笔记例子.Eg05;

public class Dog extends Pet {
	private String strin; 
	public Dog(String name,int health,int love,String strain) {
		super(name,health,love);
		this.strin=strain;
	}
	@Override
	public void print(){
		super.toString();
		super.print();
		System.out.println("血统:"+this.getStrin());
	}
	@Override
	public void jj() {
		// TODO Auto-generated method stub
		
	}

	public String getStrin() {
		return strin;
	}	
}
