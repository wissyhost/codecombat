package GUI;



import javax.swing.*;
import java.awt.*;
import org.eclipse.jface.window.WindowManager;
/**
 * Created by wissy on 2015/12/13.
 */
public class Demo02 {
    public static void main(String[] args) {


        JFrame jFrame=new JFrame();
        Container cont =jFrame.getContentPane();

        jFrame.setSize(600,800);
        jFrame.setLocation(40,70);
//        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT ));
//        jFrame.setLayout(null);
        JPanel panel=new JPanel();
        JTextField jTextField=new JTextField(25);

//        jTextField.setBounds(150, 150, 50, 50);
//        panel.add(jTextField);
//
//        jFrame.add(jTextField);
        JButton jButton=new JButton("你好按钮!!");
       panel.add(jButton);
//        cont.add(panel);
    jFrame.add(panel);
//    jFrame.add(jTextField);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

    }
}
