package student.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import student.DAO.impl.AdminDAO;
import student.util.DBCon;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldID;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		setTitle("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 30));
		label.setBounds(117, 35, 190, 34);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setBounds(61, 98, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setBounds(61, 162, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(128, 95, 179, 24);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(128, 159, 179, 24);
		contentPane.add(passwordField);
		
		JButton button = new JButton("\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id=textFieldID.getText();
				String pwd=passwordField.getText();
				check(id,pwd);
			}

			
		});
		button.setBounds(155, 196, 136, 44);
		contentPane.add(button);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("E:\\Programming\\\u91D1\u8776\\UI\u5207\u56FE\\\u5DE5\u4F5C\u754C\u9762_0003s_0002_\u865A\u5316\u80CC\u666F.png"));
		lblNewLabel_2.setBounds(0, 0, 432, 253);
		contentPane.add(lblNewLabel_2);
	}
	public void check(String id,String pwd) {
		// TODO Auto-generated method stub
		AdminDAO admin=new AdminDAO();
		if(admin.compare(id, pwd)) {
			JOptionPane.showMessageDialog(null, "µÇÂ¼³É¹¦");
			this.dispose();
			MainForm mf=new MainForm();
			mf.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "µÇÂ¼Ê§°Ü");
		}
	}
}
