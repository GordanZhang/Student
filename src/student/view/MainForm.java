package student.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MainForm extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the frame.
	 */
	public MainForm() {
		setTitle("\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnQuery = new JButton("\u67E5\u8BE2\u5B66\u751F\u4FE1\u606F");
		btnQuery.setIcon(new ImageIcon("E:\\Programming\\\u91D1\u8776\\UI\u5207\u56FE\\\u6309\u94AE\u56FE\u6807\u53CA\u6587\u5B57\\\u5DE5\u4F5C\u754C\u9762_0002s_0000_\u7CFB\u7EDF\u56FE\u6807_press.png"));
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryForm qf=new QueryForm();
				qf.setVisible(true);
			}
		});
		btnQuery.setBounds(0, 3, 153, 27);
		contentPane.add(btnQuery);
		
		JButton btnAdd = new JButton("\u6DFB\u52A0\u5B66\u751F\u4FE1\u606F");
		btnAdd.setIcon(new ImageIcon("E:\\Programming\\\u91D1\u8776\\UI\u5207\u56FE\\\u6309\u94AE\u56FE\u6807\u53CA\u6587\u5B57\\\u5DE5\u4F5C\u754C\u9762_0000s_0001_\u5C55\u5F00\u56FE\u6807.png"));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add af=new Add(MainForm.this);
				af.setVisible(true);
			}
		});
		btnAdd.setBounds(154, 3, 153, 27);
		contentPane.add(btnAdd);
		
		JButton btnDel = new JButton("\u5220\u9664\u5B66\u751F\u4FE1\u606F");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelForm df=new DelForm(MainForm.this);
				df.setVisible(true);
			}
		});
		btnDel.setIcon(new ImageIcon("E:\\Programming\\\u91D1\u8776\\UI\u5207\u56FE\\\u6309\u94AE\u56FE\u6807\u53CA\u6587\u5B57\\\u5DE5\u4F5C\u754C\u9762_0001s_0002_\u5220\u9664\u56FE\u6807.png"));
		btnDel.setBounds(308, 3, 153, 27);
		contentPane.add(btnDel);
		
		JButton btnUpdate = new JButton("\u4FEE\u6539\u5B66\u751F\u4FE1\u606F");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpForm uf=new UpForm(MainForm.this);
				uf.setVisible(true);
			}
		});
		btnUpdate.setIcon(new ImageIcon("E:\\Programming\\\u91D1\u8776\\UI\u5207\u56FE\\\u6309\u94AE\u56FE\u6807\u53CA\u6587\u5B57\\\u5DE5\u4F5C\u754C\u9762_0002s_0003_\u5DE5\u5177\u56FE\u6807_press.png"));
		btnUpdate.setBounds(460, 3, 175, 27);
		contentPane.add(btnUpdate);
		
		JButton btnExit = new JButton("\u9000\u51FA");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(637, 3, 131, 27);
		contentPane.add(btnExit);
		
		JLabel lblPic = new JLabel("New label");
		lblPic.setIcon(new ImageIcon("E:\\Programming\\\u91D1\u8776\\UI\u5207\u56FE\\\u5DE5\u4F5C\u754C\u9762_0002s_0002_\u865A\u5316\u80CC\u666F.png"));
		lblPic.setBounds(0, 31, 782, 522);
		contentPane.add(lblPic);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("E:\\Programming\\\u91D1\u8776\\UI\u5207\u56FE\\\u5DE5\u4F5C\u754C\u9762_0002s_0009_\u5DE5\u5177\u680F\u5E95\u8272.png"));
		lblNewLabel.setBounds(0, 0, 782, 33);
		contentPane.add(lblNewLabel);
	}
}
