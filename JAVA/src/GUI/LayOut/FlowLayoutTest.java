package GUI.LayOut;

/**
 * Created by wissy on 2015/12/13.
 */

/**
 *    在上篇博客Java之GUI编程（一）中我已经对GUI编程的组件和事件做了简单介绍了，
 *    现在来看看另外一部分关于组件在各个平台是如何做到仍能保持自己合理的位置大小以及外观的。
 已经说了Java是跨平台运行的，但是不同的平台对于点及坐标的定义不完全相同。
 而且屏幕的解析度分辨率不同也会造成位置的变化，为了确保每个组件的相对位置和大小以及外观，java就设计了布局管理器。
 布局管理器是对容器中的元素进行管理，按照一定的规则排放容器里面的元素。它控制了组件的摆放。
 布局管理器分类：
 FlowLayout：浮动布局管理器
 BorderLayout：边框布局管理器
 GridLayout：网格布局管理器
 CardLayout：卡片布局管理器
 GridBagLayout：网格包布局管理器
 FlowLayout
 是Panel容器的默认管理器，其组件浮动在容器中，它的放置规律是从上到下，从左到右。
 实例：
 分析：
 在上面的程序中，可以看到在创建Frame后必须设置位置参数，才能成功显示出来，其实Frame的设置并不只有这些，详看可以查阅Java帮助文档。
 */
import java.awt.*;
import java.awt.event.*;
public class FlowLayoutTest{
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
        f.setLayout(new FlowLayout());//设置浮动布局方式
        Button btn2=new Button("Button2");
        Button btn3=new Button("Button3");
        Button btn4=new Button("Button4");
        Button btn5=new Button("Button5");
        f.add(btn1);
        f.add(btn2);
        f.add(btn3);
        f.add(btn4);
        f.add(btn5);
    }
}
/**
 当我改变窗口的大小，相应的组件的位置也会发生改变，由图一的显示方式变成图二的显示方式。
 对于FlowLayout还提供了按钮的对齐方式，比如说f.setLayout(new FlowLayout(FlowLayout.LEFT))，
 就设置了左对齐的方式，这些按钮将会从左边依次摆放。
 */