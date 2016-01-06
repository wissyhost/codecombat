package GUI;

import javax.swing.*;

/**
 * Created by wissy on 2015/12/13.
 */
public class Demo05 extends JFrame {
    private JCheckBox checkBox1= new JCheckBox("多选框1");
    private JPanel panel1=new JPanel();
    private JCheckBox checkBox2=new JCheckBox("多选框2");
    private JTextField textField1=new JTextField("用户名");
    private JList list1=new JList();
    private JCheckBox checkBox3=new JCheckBox("多选框3");
    Demo05(){
        super("Demo05");
        setSize(1600,800);
        setLocation(20,80);

    }
    public void aVoid(){


        panel1.add(checkBox1);
        panel1.add(checkBox2);
        panel1.add(checkBox3);
        panel1.add(textField1);
        panel1.add(list1);
        add(panel1);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
       new Demo05().aVoid();
    }
}
