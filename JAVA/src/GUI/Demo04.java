package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

/**
 * Created by wissy on 2015/12/13.
 */
public class Demo04 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("我的第一个GUI程序");
        JPanel jPanel = new JPanel();
        jFrame.setSize(800, 600);
        jFrame.setLocation(20, 80);
//        jFrame.setLocale(Locale.CHINA);
        JTextField jTextField = new JTextField("输入用户名", 25);
        JPasswordField jPasswordField = new JPasswordField("输入密码", 25);
        JCheckBox jCheckBox = new JCheckBox("多选框",true);

//        ComboBoxModel comboBoxModel=new
        JComboBox jComboBox=new JComboBox();
        jComboBox.addItem("张三");
        JCheckBoxMenuItem jCheckBoxMenuItem = new JCheckBoxMenuItem("多选框",true);
        Button button = new Button("按钮");
        button.setFont(new Font("宋体", 20, 22));



        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jComboBox.addItem(jTextField.getText());
            }
        });

        JOptionPane.showMessageDialog(jFrame.getContentPane(),
                "弹出的是消息提示框!", "系统信息", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(jFrame.getContentPane(),
                "弹出的是警告提示框!", "系统信息", JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(jFrame.getContentPane(),
                "弹出的是错误提示框!", "系统信息", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(jFrame.getContentPane(),
                "弹出的是询问提示框!", "系统信息", JOptionPane.QUESTION_MESSAGE);

        int option = JOptionPane.showConfirmDialog(null,
                "文件已修改，是否保存？", "保存文件？", JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE, null);
        switch (option) {
            case JOptionPane.YES_NO_OPTION: {
//                saveAsFile();
                break;
            }
            case JOptionPane.NO_OPTION:
                System.exit(0);

        }

        jPanel.add(jCheckBox);
        jPanel.add(jComboBox);
        jPanel.add(jCheckBoxMenuItem);
        jPanel.add(jTextField);
        jPanel.add(jPasswordField);
        jPanel.add(button);


        jFrame.add(jPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.setVisible(true);
//        jFrame.pack();
    }
}

