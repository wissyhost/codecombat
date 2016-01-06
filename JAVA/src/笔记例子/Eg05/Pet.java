package 笔记例子.Eg05;

public abstract class Pet {
	private String name;//只读属性
	private int health;//读写属性
	private int love;//读写属性
	public Pet(String name,int health,int love){
		this.name=name;
		this.health=health;
		this.love=love;
	}
	public void  print(){
		System.out.println("宠物的自白:");
		System.out.print("我的名字叫:"+this.name+"健康值:"+this.health+"亲密度"+this.love);
	}
	public String getName(){//只读属性
		return name;
	}
	public int getLove(){
		return love;
	}
	public void setLove(int love){
		if(love>=0&&love<=100){
			this.love=love;
		}else{
			System.out.println("输入爱心值在0-100之间");
		}
	}
	
	public int getHealth(){
		return health;
	}
	public void setHealth(int health){
		if(health>=0&&health<=100){
			this.health=health;
		}else{
			System.out.println("输入健康值在0-100之间");
		}
	}
	abstract public void jj();

	
}
