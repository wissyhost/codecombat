package Reflection;

/**
 * Created by wissy on 2015/11/30.
 */

import java.io.IOException;
import java.lang.reflect.*;
import java.util.*;

/**
 * 反射:在程序运行中(在类加载过程中),动态的知道类的信息(包.类,对象,属性,方法,构造器...etc)
 *      这就是反射机制
 *与构造器有关的常见应用
 * Class
 *      方法:
 *      1.getConstructors();获取类中的所有public构造器Constructor[]
 *      2.getDeclaredConstructors();获取类中的所有构造器Constructor[]
 *      3.getConstructor(Class ...)获取一个构造器Constructor
 * Constructor:表示构造器
 *      newInstance(Class ...) 通过构造器创建对象
 *      -------------------------------
 *      与方法有关的常见应用
 * Method
 *      方法:
 *      1.getMethods();获取类中的所有public方法(包括父类)Method[]
 *      2.getDeclaredMethods();获取类中的所有方法(只是自己的方法)Method[]
 *      3.getDeclaredMethod(Class ...)获取一个指定方法method
 * Method:表示构造器
 *      invoke(,Object,Class ...) 执行指定对象的对应方法
 *      ----------------------------------
 *           与属性有关的常见应用
 * Field
 *      方法:
 *      1.getFields();获取类中的所有public属性Field[]
 *      2.getDeclaredFields();获取类中的所有属性Field[]
 *      3.getDeclaredField(Class ...)获取一个指定属性Field
 *Field:表示属性
 *  set(Object  ,Object Value....)给对象属性赋值
 *  get(Object)获取指定对象的指定属性
 */

class  AA{
    public AA(int a, int b, int c){
        System.out.println(a+b+c);
    }
    public AA(String a, String b, int c){
        System.out.println(a+b+c);
    }
    private AA(String a, String b, String c){
        System.out.println(a+b+c);
    }
}

class Animal{
    private void testAprivate(){
        System.out.println("testAprivate");
    }
    void testADefault(){
        System.out.println("testADefault");
    }
    protected void testAProtected(){
        System.out.println("testAProtected");
    }
    public void testAPublic(){
        System.out.println("testAPublic");
    }
}
class Cat extends Animal{
    private void testBprivate(){
        System.out.println("testBprivate");
    }
    void testBDefault(){
        System.out.println("testBDefault");
    }
    protected void testBProtected(){
        System.out.println("testBProtected");
    }
    public void testBPublic(){
        System.out.println("testBPublic");
    }
    public int print(int a,int b){
        System.out.println(a+b);
        return a+b;
    }
}
class TestMethod{
    //方法调用
    public void testMethod(String s) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //Load class invoke调用
        Class c=Class.forName(s);
        Object o=c.newInstance();
        //Find method
        Class p1=int.class;
        Class p2=int.class;
        Method method=c.getMethod("print",p1,p2);
        //execu method
       Object a= method.invoke(o,3,8);
        System.out.println(a);
    }
    //获取方法
    public void showAllMethod(String s) throws ClassNotFoundException {
        //Load class
        Class c=Class.forName(s);
        //Get class all public methods(include super class method && son class....until Object)But only public method
        Method[] ms=c.getMethods();
        System.out.println(Arrays.toString(ms));
        //Get class class myself all method(include class myself private .... But not include super  )
        Method[] ms1=c.getDeclaredMethods();
        System.out.println(Arrays.toString(ms1));
    }
}
//Fields 属性
class C{
    private int a;
    int b;
    protected int c;
    public int d;
    public void showFields(String s) throws ClassNotFoundException {
        Class c=Class.forName(s);
        //Get All public Fields
        Field[] fields=c.getFields();
        //Get All Decleared Fielsa
        Field[] fields1=c.getDeclaredFields();

        //Print
        System.out.println(Arrays.toString(fields));
        System.out.println(Arrays.toString(fields1));

    }
    public void testField(String s) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //Load class
        Class c=Class.forName(s);
        //Create object
        Object o=c.newInstance();
        //Assignment to field
        Field field=c.getField("d");
        field.set(o,123);
        //Pull field value
        Object rt=field.get(o);
        System.out.println(rt);


       /* D d= new D();
        d.cd=123;
        int ret=d.cd;*/

    }
}
public class Reflection1 {
    public void getInstanceTest(String currol) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        Class a=Class.forName(currol);
//        Object o=a.newInstance();
//
//        Date date=new Date();
//        System.out.println(o);
//        System.out.println(date);

        //one. load class
        Class c=Class.forName(currol);
        //looked all Declared(已声明的) public constructors
        Constructor[] constructor=c.getConstructors();
        //looed all Declared constructors
        Constructor[] constructor1=c.getDeclaredConstructors();
        //two. call hava argument construct
        Class p1=int.class;
        Class p2=int.class;
        Class p3=int.class;
        //Appoint type of argument from construct
        Constructor constructor2=c.getConstructor(p1,p2,p3);
       //create object
        Object o=constructor2.newInstance(45,45,78);

        System.out.println(Arrays.toString(constructor));
        System.out.println(Arrays.toString(constructor));
        System.out.println(o);
        //------------------------------------
        Class p4=String.class;
        Class p5=String.class;
        Class p6=int.class;
        Constructor constructor3=c.getConstructor(p4,p5,p6);

        Object o1= constructor3.newInstance("s","s",25);
        System.out.println(o1);
        //---------------------------------------
    }
    public static void main(String[] args) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
//        Properties properties = new Properties();
//        properties.load(new FileInputStream("test.properties"));
//        String ClassName="A";
//        Class.forName(ClassName);
//        Class.forName(properties.getProperty("className"));

        /**get Class  more paths
         * 1.ClassName.class
         * 2.Object.getclass
         */
      /*  String className1="java.lang.String";
        Class one=Class.forName(className1);
        Class two=String.class;
        Class three="abc".getClass();
        Class four=int.class;
        Class five=Void.class;
        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
        System.out.println(four);
        System.out.println(five);*/

//        new Reflection1().getInstanceTest("Reflection.AA");
//        new TestMethod().testMethod("Reflection.Cat");
        new C().testField("Reflection.C");
    }
}
