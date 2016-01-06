package GUI;

import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;

public class Demo03 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(600, 800);
        frame.setLocation(20, 80);
//		frame.setLayout(new BorderLayout());
        frame.setLayout(new FlowLayout());
//		 JTextField textFieldA = new HintTextField("A hint here");
//		 JTextField textFieldB = new HintTextField("Another hint here");
        JTextField textFieldA =new JTextField(25);
        JTextField textFieldB =new JTextField(25);
        frame.add(textFieldA);
        frame.add(textFieldB);

//		JButton btnGetText = new JButton("Get text");
//		btnGetText.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String message = String.format("textFieldA='%s', textFieldB='%s'", textFieldA.getText(),
//						textFieldB.getText());
//				JOptionPane.showMessageDialog(frame, message);
//			}
//		});
//		frame.add(btnGetText, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
}

//class HintTextField extends JTextField implements FocusListener {
//	private final String hint;
//	private boolean showingHint;
//
//	public HintTextField(final String hint) {
//		super(hint);
//		this.hint = hint;
//		this.showingHint = true;
//		super.addFocusListener(this);
//	}
//
//	@Override
//	public void focusGained(FocusEvent e) {
//		if (this.getText().isEmpty()) {
//			super.setText("");
//			showingHint = false;
//		}
//	}
//
//	@Override
//	public void focusLost(FocusEvent e) {
//		if (this.getText().isEmpty()) {
//			super.setText(hint);
//			showingHint = true;
//		}
//	}
//
//	@Override
//	public String getText() {
//		return showingHint ? "" : super.getText();
//	}
//}
