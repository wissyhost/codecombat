package GUI.LayOut;

/**
 * Created by wissy on 2015/12/13.
 */

/**
 * BorderLayout
 布置容器的边框布局，可以对容器组件进行安排，并调整其大小，
 使其符合五个区域：北、南、东、西、中。每个区域最多只能包含一个组件，
 并通过相应的常量进行标识：NORTH、SOUTH、EAST、WEST、CENTER，若只有一个组件，
 默认位置为Center，是Window、Frame和Dialog的默认布局管理器。
 实例：
 */
import java.awt.*;
import java.awt.event.*;
public class BorderLayoutTest{
    public static void main(String[] args)
    {
        //创建一个框架
        Frame f=new Frame("Test");
        //设置窗体大小
        f.setSize(800,600);
        //设置窗体显示位置
        f.setLocation(100,100);
        Button btn1=new Button("Button1"); //创建按钮对象
        f.setBackground(Color.BLUE); //窗体背景色
        f.setVisible(true);    //窗体可见
        Button btn2=new Button("Button2");
        Button btn3=new Button("Button3");
        Button btn4=new Button("Button4");
        Button btn5=new Button("Button5");
        f.add(btn1,"Center"); //将按钮添加到窗体中，并设置显示位置
        f.add(btn2,"North");
        f.add(btn3,"West");
        f.add(btn4,"South");
        f.add(btn5,"East");
    }
}
