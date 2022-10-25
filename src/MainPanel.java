package passwordGen;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import java.util.*;



public class MainPanel extends JPanel {
	
	protected JSpinner numChoice = new JSpinner();
	protected JTextArea textArea = new JTextArea();
	private final Action genBtn = new genBtnClick();
	
	public MainPanel() {
		setBackground(Color.GRAY);
		setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(380, 22, 10, 10);
		add(panel);
		
		JLabel lblNewLabel = new JLabel("Password Generator\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(108, 28, 456, 31);
		add(lblNewLabel);
		
		JLabel numLabel = new JLabel("Number of Characters: ");
		numLabel.setBounds(10, 105, 152, 14);
		add(numLabel);
		
		
		textArea.setBounds(138, 268, 411, 79);
		add(textArea);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPassword.setBounds(277, 243, 123, 14);
		add(lblNewPassword);
		
		JButton btnNewButton = new JButton("Generate");
		btnNewButton.setEnabled(false);
		btnNewButton.setAction(genBtn);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(460, 101, 89, 23);
		add(btnNewButton);
		
		
		
		numChoice.setBounds(159, 102, 44, 20);
		add(numChoice);
		
	}
	
	private class genBtnClick extends AbstractAction {
		public genBtnClick() {
			putValue(NAME, "Generate");
		}
		public void actionPerformed(ActionEvent e) {
			int num = (Integer)numChoice.getValue();
			String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()";
			String pass = "";
			Random rand = new Random();
			
			if(num < 3) {
				textArea.setText("");
				textArea.setText("Invalid number of characters chosen. Must be at least 3 characters long!");
			}
			else {
				textArea.setText("");
				for (int i = 0; i < num; i++) {
					pass += chars.charAt(rand.nextInt(70));
				}
				textArea.setText(pass);
			}
			
		}
		
	}
}
