package GUI.LayOut;

/**
 * Created by wissy on 2015/12/13.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * CardLayout
 容器中虽然有多个组件，但是我们只会看到最上面的组件，组件在重叠起来的就像重叠起来的扑克牌，每次只能看到最上面的那张。
 分析：
 在按下按钮（Change）后，出现上面运行结果，看似只有一个组件，其实可能蕴藏了很多个组件。
 */
public class CardLayoutTest {
    private static JPanel p;
    public static void main(String[] args) {
        JFrame f=new JFrame("CardLayout");
        p=new JPanel();
        //将JPanel p的LayoutManager设置为CardLayout
        p.setLayout(new CardLayout());

        //新建两个JPanel
        JPanel p1=new JPanel();
        JPanel p2=new JPanel();
        JLabel lb=new JLabel("first panel");
        p1.add(lb);
        lb=new JLabel("second panel");
        p2.add(lb);

        //将新建的两个JPanel p1,p2添加到p中
        p.add(p1,"frist");
        p.add(p2,"second");

        //设置默认显示first所对应的JPanel p1
        ((CardLayout)p.getLayout()).show(p, "frist");

        JButton cbtn=new JButton("Change");
        cbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                //当按下Change按钮时，显示second 对应的JPanel p2
                ((CardLayout)p.getLayout()).show(p, "second");
            }
        });

        f.add(cbtn,BorderLayout.NORTH);
        f.add(p,BorderLayout.CENTER);
        f.setSize(400,150);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
