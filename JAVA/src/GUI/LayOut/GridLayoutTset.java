package GUI.LayOut;

/**
 * Created by wissy on 2015/12/13.
 */

import java.awt.*;

/**
 * GridLayout
 将容器分成网格，在创建GridLayout布局管理器对象的时候需要传递两个参数，一个代表行另一个代表列。
 实例：
 分析：
 布局后的版面就如同表格一样整齐有序，加入的组件按顺序由左至右、由上至下摆放，所以无法直接指定要摆放的区域，同时，组件放入后变成了方形。
 */
public class GridLayoutTset {
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
        //f.setLayout(new FlowLayout());//设置浮动布局方式
        f.setLayout(new GridLayout(3,1,10,10));//设置布局方式并设置组件间间隙
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
