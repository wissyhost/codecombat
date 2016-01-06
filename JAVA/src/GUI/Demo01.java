package GUI;
import javax.swing.*;


/**
 * Created by wissy on 2015/12/13.
 */

/**
 * GUI编程类
 *  AWT Swing Swt Jface
 *   Awt 是用c语言写的相对比其他快一点,但是功能不够用完善 swing是基于AWT扩展而来的其损失速度来扩展功能,idea就是使用了Swing
 *   SWT是IBM对awt的一个优化项目,Jface是基于SWT的一个扩展,Eclipse就是使用了Jface,
 *
 *   一般吧GUI组件分为2大
 *      1.容器组件,就是可以放其他组件的组件,如:Windows,
 *      2.非容器组件 只能放在容器中运行的组件 如:Button
 *   所有的Gui组件都是继承与Component,
 *
 */
public class Demo01 extends JFrame {
    public Demo01()  {
        super("Demo01");
        setSize(600,400);
        setLocation(200,200);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pan= new JPanel();
        JTabbedPane top= new JTabbedPane(JTabbedPane.TOP);
        JButton ok=new JButton("OK");
        JButton canel=new JButton("Canel");
        JButton canel1=new JButton("取消");
//        JTextField jTextField=new JTextField(25);

//        DefaultComboBoxModel dcm=new DefaultComboBoxModel();
//        JComboBox<String> jcom=new JComboBox(dcm);
//        JCheckBoxMenuItem jCheckBoxMenuItem=new JCheckBoxMenuItem("jCheckBoxMenuItem");
        JCheckBox jCheckBox=new JCheckBox("kk");
        JComboBox jComboBox=new JComboBox();
        pan.add(jComboBox);
        pan.add(jCheckBox);
//        pan.add(jcom);
//        pan.add(jCheckBoxMenuItem);
//        add(pan);
        pan.add(ok);
        pan.add(canel);
//        pan.add(jTextField);
        top.add("OK",pan);
        top.add("取消",canel1);
        add(top);

    }
    public void aVoid(){
//        FlowLayout flowLayout=new FlowLayout();
//        setLayout(flowLayout);



//        setBackground(Color.green);
//        Container container=this.getContentPane();
//        container.setBackground(Color.green);





//        JCheckBox jCheckBox=new JCheckBox("jCheckBox");
////        add(jCheckBox);
//
////        add(jComboBox);
//

//        JToolBar jToolBar=new JToolBar("文件");
//        this.add(jToolBar);
//        this.add(top);
//        JMenu jMenu=new JMenu("文件");
//        JMenuItem jMenuItem=new JMenuItem("编辑");
//        JMenuBar jMenuBar=new JMenuBar();
//        jMenu.add(jMenuItem);
//        jMenuBar.add(jMenu);
//        this.add(jMenuBar);
//        button.setSize(100,100);
//        button.setLocation(50,50);
//        button1.setSize(100,100);
//        button1.setLocation(50,50);
//        button2.setSize(100,100);
//        button2.setLocation(50,50);
//        button3.setSize(100,100);
//        button3.setLocation(50,50);
//        button4.setSize(100,100);
//        button4.setLocation(50,50);
//        add(button, BorderLayout.NORTH);
//        add(button1, BorderLayout.EAST);
//        add(button2, BorderLayout.WEST);
//        add(button3, BorderLayout.SOUTH);
//        add(button4, BorderLayout.CENTER);
//        add(button);
//        add(button1);
//        add(button2);
//        add(button3);
//        add(button4);

    }

    public static void main(String[] args) {
//        new Demo01().aVoid();
        new Demo01();

    }

}
