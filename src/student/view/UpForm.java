package student.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import student.util.DBCon;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class UpForm extends JDialog {

	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldName;
	private JTextField textFieldSno;
	private JTextField textFieldGPA;
	private JTextField textFieldEmail;
	private JTextField textFieldTel;

	private DBCon conn;
	private Connection ct=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private String sql="";
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpForm frame = new UpForm();
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
	public UpForm(MainForm mf) {
		super(mf,"修改记录",true);
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(14, 13, 662, 190);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("\u8F93\u5165id");
		lblId.setBounds(14, 13, 57, 18);
		panel.add(lblId);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(68, 10, 130, 24);
		panel.add(textFieldID);
		textFieldID.setColumns(10);
		
		JLabel label = new JLabel("\u59D3\u540D");
		label.setBounds(14, 44, 40, 18);
		panel.add(label);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(68, 41, 130, 24);
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		JButton btnUpdName = new JButton("\u4FEE\u6539\u59D3\u540D");
		btnUpdName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(textFieldID.getText());
				String name=textFieldName.getText();
				conn=new DBCon();
				sql="update student set name='"+name+"' where id='"+id+"'";
				try {
					
					ct= (Connection) conn.getConn();
					int res=conn.update(sql);
					if(res!=-1) {
						JOptionPane.showMessageDialog(null, "修改成功");
					}
					else {
						JOptionPane.showMessageDialog(null, "修改失败");
					}
				}catch(Exception ee) {
					ee.printStackTrace();
				}finally {
					conn.closeConn();
				}
			}
		});
		btnUpdName.setBounds(212, 40, 99, 27);
		panel.add(btnUpdName);
		
		JLabel label_1 = new JLabel("\u5B66\u53F7");
		label_1.setBounds(14, 75, 38, 18);
		panel.add(label_1);
		
		textFieldSno = new JTextField();
		textFieldSno.setBounds(66, 72, 132, 24);
		panel.add(textFieldSno);
		textFieldSno.setColumns(10);
		
		JButton btnUpdSno = new JButton("\u4FEE\u6539\u5B66\u53F7");
		btnUpdSno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(textFieldID.getText());
				String sno=textFieldSno.getText();
				conn=new DBCon();
				sql="update student set sno='"+sno+"' where id='"+id+"'";
				try {
					
					ct= (Connection) conn.getConn();
					int res=conn.update(sql);
					if(res!=-1) {
						JOptionPane.showMessageDialog(null, "修改成功");
					}
					else {
						JOptionPane.showMessageDialog(null, "修改失败");
					}
				}catch(Exception ee) {
					ee.printStackTrace();
				}finally {
					conn.closeConn();
				}
			}
		});
		btnUpdSno.setBounds(212, 71, 99, 27);
		panel.add(btnUpdSno);
		
		JLabel label_2 = new JLabel("\u9662\u7CFB");
		label_2.setBounds(14, 106, 40, 18);
		panel.add(label_2);
		
		JComboBox comboBoxDept = new JComboBox();
		comboBoxDept.setModel(new DefaultComboBoxModel(new String[] {"\u5E94\u7528\u79D1\u5B66\u5B66\u9662", "\u8BA1\u7B97\u673A\u5B66\u9662", "\u5916\u56FD\u8BED\u5B66\u9662", "\u7535\u5B50\u5B66\u9662", "\u673A\u68B0\u5DE5\u7A0B\u5B66\u9662", "\u6750\u6599\u5B66\u9662", "\u4F53\u80B2\u5B66\u9662", "\u4EBA\u6587\u5B66\u9662", "\u6CD5\u5B66\u9662", "\u7ECF\u7BA1\u5B66\u9662"}));
		comboBoxDept.setBounds(68, 103, 130, 24);
		panel.add(comboBoxDept);
		
		JButton btnUpdDept = new JButton("\u4FEE\u6539\u9662\u7CFB");
		btnUpdDept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(textFieldID.getText());
				String dept=comboBoxDept.getSelectedItem().toString();
				conn=new DBCon();
				sql="update student set department='"+dept+"' where id='"+id+"'";
				try {
					
					ct= (Connection) conn.getConn();
					int res=conn.update(sql);
					if(res!=-1) {
						JOptionPane.showMessageDialog(null, "修改成功");
					}
					else {
						JOptionPane.showMessageDialog(null, "修改失败");
					}
				}catch(Exception ee) {
					ee.printStackTrace();
				}finally {
					conn.closeConn();
				}
			}
		});
		btnUpdDept.setBounds(212, 102, 99, 27);
		panel.add(btnUpdDept);
		
		JLabel label_3 = new JLabel("\u7C4D\u8D2F");
		label_3.setBounds(335, 44, 40, 18);
		panel.add(label_3);
		
		JComboBox comboBoxHome = new JComboBox();
		comboBoxHome.setModel(new DefaultComboBoxModel(new String[] {"\u5317\u4EAC", "\u5929\u6D25", "\u6CB3\u5317", "\u8FBD\u5B81", "\u5409\u6797", "\u9ED1\u9F99\u6C5F", "\u5185\u8499\u53E4", "\u65B0\u7586", "\u7518\u8083", "\u9752\u6D77", "\u5B81\u590F", "\u9655\u897F", "\u5C71\u897F", "\u6CB3\u5357", "\u5C71\u4E1C", "\u6E56\u5317", "\u6E56\u5357", "\u6C5F\u82CF", "\u4E0A\u6D77", "\u5B89\u5FBD", "\u6D59\u6C5F", "\u6C5F\u897F", "\u56DB\u5DDD", "\u91CD\u5E86", "\u8D35\u5DDE", "\u4E91\u5357", "\u897F\u85CF", "\u5E7F\u897F", "\u5E7F\u4E1C", "\u6D77\u5357", "\u9999\u6E2F", "\u6FB3\u95E8"}));
		comboBoxHome.setBounds(389, 41, 113, 24);
		panel.add(comboBoxHome);
		
		JButton btnUpdHome = new JButton("\u4FEE\u6539\u7C4D\u8D2F");
		btnUpdHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(textFieldID.getText());
				String home=comboBoxHome.getSelectedItem().toString();
				conn=new DBCon();
				sql="update student set hometown='"+home+"' where id='"+id+"'";
				try {
					
					ct= (Connection) conn.getConn();
					int res=conn.update(sql);
					if(res!=-1) {
						JOptionPane.showMessageDialog(null, "修改成功");
					}
					else {
						JOptionPane.showMessageDialog(null, "修改失败");
					}
				}catch(Exception ee) {
					ee.printStackTrace();
				}finally {
					conn.closeConn();
				}
			}
		});
		btnUpdHome.setBounds(530, 40, 104, 27);
		panel.add(btnUpdHome);
		
		JLabel lblGpa = new JLabel("GPA");
		lblGpa.setBounds(337, 75, 38, 18);
		panel.add(lblGpa);
		
		JButton btnUpdGpa = new JButton("\u4FEE\u6539GPA");
		btnUpdGpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(textFieldID.getText());
				String gpa=textFieldGPA.getText();
				conn=new DBCon();
				sql="update student set mark='"+gpa+"' where id='"+id+"'";
				try {
					
					ct= (Connection) conn.getConn();
					int res=conn.update(sql);
					if(res!=-1) {
						JOptionPane.showMessageDialog(null, "修改成功");
					}
					else {
						JOptionPane.showMessageDialog(null, "修改失败");
					}
				}catch(Exception ee) {
					ee.printStackTrace();
				}finally {
					conn.closeConn();
				}
			}
		});
		btnUpdGpa.setBounds(530, 71, 104, 27);
		panel.add(btnUpdGpa);
		
		textFieldGPA = new JTextField();
		textFieldGPA.setBounds(389, 74, 113, 24);
		panel.add(textFieldGPA);
		textFieldGPA.setColumns(10);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(335, 106, 46, 18);
		panel.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(389, 103, 113, 24);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JButton btnUpdEmail = new JButton("\u4FEE\u6539email");
		btnUpdEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(textFieldID.getText());
				String email=textFieldEmail.getText();
				conn=new DBCon();
				sql="update student set email='"+email+"' where id='"+id+"'";
				try {
					
					ct= (Connection) conn.getConn();
					int res=conn.update(sql);
					if(res!=-1) {
						JOptionPane.showMessageDialog(null, "修改成功");
					}
					else {
						JOptionPane.showMessageDialog(null, "修改失败");
					}
				}catch(Exception ee) {
					ee.printStackTrace();
				}finally {
					conn.closeConn();
				}
			}
		});
		btnUpdEmail.setBounds(530, 102, 104, 27);
		panel.add(btnUpdEmail);
		
		JLabel label_4 = new JLabel("\u6027\u522B");
		label_4.setBounds(14, 148, 40, 18);
		panel.add(label_4);
		
		JComboBox comboBoxSex = new JComboBox();
		comboBoxSex.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
		comboBoxSex.setBounds(68, 145, 130, 24);
		panel.add(comboBoxSex);
		
		JLabel label_5 = new JLabel("\u8054\u7CFB\u7535\u8BDD");
		label_5.setBounds(313, 148, 67, 18);
		panel.add(label_5);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(389, 145, 113, 24);
		panel.add(textFieldTel);
		textFieldTel.setColumns(10);
		
		JButton btnUpdTel = new JButton("\u4FEE\u6539\u7535\u8BDD");
		btnUpdTel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(textFieldID.getText());
				String tel=textFieldTel.getText();
				conn=new DBCon();
				sql="update student set tel='"+tel+"' where id='"+id+"'";
				try {
					
					ct= (Connection) conn.getConn();
					int res=conn.update(sql);
					if(res!=-1) {
						JOptionPane.showMessageDialog(null, "修改成功");
					}
					else {
						JOptionPane.showMessageDialog(null, "修改失败");
					}
				}catch(Exception ee) {
					ee.printStackTrace();
				}finally {
					conn.closeConn();
				}
			}
		});
		btnUpdTel.setBounds(530, 144, 104, 27);
		panel.add(btnUpdTel);
		
		JButton btnUpdSex = new JButton("\u4FEE\u6539\u6027\u522B");
		btnUpdSex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(textFieldID.getText());
				String sex=comboBoxSex.getSelectedItem().toString();
				conn=new DBCon();
				sql="update student set sex='"+sex+"' where id='"+id+"'";
				try {
					
					ct= (Connection) conn.getConn();
					int res=conn.update(sql);
					if(res!=-1) {
						JOptionPane.showMessageDialog(null, "修改成功");
					}
					else {
						JOptionPane.showMessageDialog(null, "修改失败");
					}
				}catch(Exception ee) {
					ee.printStackTrace();
				}finally {
					conn.closeConn();
				}
			}
		});
		btnUpdSex.setBounds(212, 142, 99, 27);
		panel.add(btnUpdSex);
	}

}
