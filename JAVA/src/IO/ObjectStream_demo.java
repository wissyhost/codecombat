package IO;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by wissy on 2015/11/18.
 */
class Animal implements Serializable{
    private String name;
    private int age;
    private boolean sex;

    public Animal() {
    }

    public Animal(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class ObjectStream_demo{
    public ArrayList<Animal> InitialAmimal(){
        System.out.println("准备数据");
        ArrayList<Animal> list= new ArrayList<Animal>();
        list.add(new Animal("aaa",55,true));
        list.add(new Animal("bbb",451,true));
        list.add(new Animal("vch",26,false));
        list.add(new Animal("hhj",02,true));
        list.add(new Animal("hjh",56,false));
        System.out.println("数据已准备");
        return  list;
    }
    public void objectStream(ArrayList<Animal> animalArrayList,String fileName) throws IOException, ClassNotFoundException {
        System.out.println("准备写入对象..");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
        oos.writeObject(animalArrayList);
        System.out.println("已写入"+fileName);
        oos.flush();
        System.out.println("刷新写入");
        oos.close();
        System.out.println("准备读取对象..");
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fileName));
        ArrayList<Animal> animalArrayList1= (ArrayList<Animal>) ois.readObject();
        System.out.println("从"+fileName+"中成功取出");
        ois.close();
        System.out.println("数据打印--------------------------");
        for (int i = 0; i < animalArrayList1.size(); i++) {
            Animal animal= animalArrayList1.get(i);
            System.out.println(animal.getName()+"\t"+animal.getAge()+"\t"+animal.isSex());
        }
    }
}

