package GUI.LayOut;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JButton;
/**
 * Created by wissy on 2015/12/13.
 */

/**
 * GridBagLayout
 是所有AWT布局管理器当中最复杂的，功能也是最强大的。这是因为它所提供了很多的可配置选项，
 几乎可以完全地控制容器的布局方式。尽管复杂，理解了基本思想，还是很容易。
 实例：
 分析：
 它同GridLayout一样,在容器中以网格形式来管理组件，只是功能比GridLayout强大。
 GridBagLayout管理的所有行和列可以大小不同。 GridLayout把每个组件限制到一个单元格，
 而GridBagLayout并不这样，其组件在容器中可以占据任意大小的矩形位置。
 总结
 GUI编程注重界面美观，满足用户的视觉享受，J2se中现有的布局管理器，让java界面更好的跨平台使用。
 而我仅仅是将一些我当前学到的这几种布局管理器进行了总结，其实，所有的布局管理器都要实现一个接口，
 即LayoutManager Inerface或者是它的一个子接口LayoutManager2 Interface
 （适用于更复杂的布局管理），由此，是不是也可以通过实现这个接口，编写适合自己需要的布局管理器。。。。
 */
public class GridBagLayoutTest {
        public static void main(String[] args) {
            JFrame f=new JFrame("GridBagLayout");
            f.setLayout(new GridBagLayout());
            JButton btn=new JButton("Button1");
            GridBagConstraints gbc=new GridBagConstraints();
            //设定第一个单元格的属性值
            gbc.gridx=0;  //横坐标
            gbc.gridy=0;  //纵坐标
            gbc.gridwidth=1;  //组件宽
            gbc.gridheight=1;  //组件高
            gbc.weightx=0;  //行的权重，通过这个属性来决定如何分配行的剩余空间
            gbc.weighty=0;
            gbc.anchor=GridBagConstraints.NORTHWEST;
            //当组件在格内而不能撑满其格时，通过fill的值来设定填充方式，有四个值
            gbc.fill=GridBagConstraints.NONE;
            gbc.insets=new Insets(0,0,0,0);
            gbc.ipadx=0;  //组件间的横向间距
            gbc.ipady=0;  //组件间的纵向间距
            f.add(btn,gbc);

            //设定第二个单元格属性值
            gbc.gridx=1;
            gbc.gridy=0;
            gbc.gridwidth=GridBagConstraints.REMAINDER;
            gbc.gridheight=1;
            gbc.weightx=1;
            gbc.weighty=0;
            // 当组件小于其显示区域时，用于确定将组件置于何处（在显示区域中）
            gbc.anchor=GridBagConstraints.CENTER;
            gbc.fill=GridBagConstraints.HORIZONTAL;
            gbc.insets=new Insets(5,5,5,5);  //设置组件之间彼此的间距
            gbc.ipadx=0;
            gbc.ipady=0;
            btn=new JButton("Button2");
            f.add(btn,gbc);

            //设定第三个单元格属性值
            gbc.gridx=0;
            gbc.gridy=1;
            gbc.gridwidth=1;
            gbc.gridheight=GridBagConstraints.REMAINDER;
            gbc.weightx=0;
            gbc.weighty=1;
            gbc.anchor=GridBagConstraints.CENTER;
            gbc.fill=GridBagConstraints.VERTICAL;
            gbc.insets=new Insets(0,0,0,0);
            gbc.ipadx=10;
            gbc.ipady=10;
            btn=new JButton("Button3");
            f.add(btn,gbc);
            f.pack();
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    }
