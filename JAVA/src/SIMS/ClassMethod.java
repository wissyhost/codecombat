package SIMS;

public class ClassMethod {
	int Class;
	float socer;
	int classnumber;
	public ClassMethod(int newClass,float newsocer,int newclassnumber){
		int Class = newClass;
		float socer = newsocer;
		int classnumber = newclassnumber;
		System.out.println("有参的构造方法执行了\n"+Class+"\t"+socer+"\t"+classnumber);
	}	
}
