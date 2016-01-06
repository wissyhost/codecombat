package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by wissy on 2015/12/13.
 */


public class Demo06 extends JFrame {
    int[][] map = new int[][]{
            {1, 2, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 0, 1, 1},
            {1, 1, 1, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 3, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    public static int WALL = 1;
    public static int ROAD = 0;
    public static int ENTER = 3;
    public static int EXIT = 2;
    JPanel jPanel = new JPanel();
    JButton button = new JButton("开始");
    JMenuBar jMenuBar = new JMenuBar();
    JMenu jMenu = new JMenu("文件");
    JMenuItem jMenuItem = new JMenuItem("编辑");
    JTextField jTextField=new JTextField(25);
    public  void initLister(){
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null,"HELLO WORLD");
                String string=jTextField.getText();
                setTitle(string);
            }
        });
        jTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTitle(jTextField.getText());
            }
        });
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
//                super.mouseEntered(e);
                jTextField.setBackground(Color.black);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jTextField.setBackground(Color.white);
            }
        });
        jTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getExtendedKeyCode()==KeyEvent.VK_F4)
                    System.exit(0);
            }
        });
    }

    public void aVoid() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1600, 800);
        setLocation(20, 80);
        initLister();

        jMenu.add(jMenuItem);
        jMenuBar.add(jMenu);
        jPanel.add(jTextField);
        jPanel.add(jMenuBar,LEFT_ALIGNMENT);
        jPanel.add(button);
        add(jPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Demo06().aVoid();
    }
}
