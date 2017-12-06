package student.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import student.util.DBCon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DelForm extends JDialog {

	private JPanel contentPane;
	
	private DBCon conn;
	private Connection ct=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private String sql="";
	private JTextField textFieldID;
	private JTextField textFieldName;
	private JTextField textFieldSno;
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DelForm frame = new DelForm();
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
	public DelForm(MainForm mf) {
		super(mf,"删除记录",true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDel = new JButton("\u5220\u9664");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(textFieldID.getText());
				String name=textFieldName.getText();
				String sno=textFieldSno.getText();
				conn=new DBCon();
				sql="delete from student where name='"+name+"' and sno='"+sno+"'";
				try {
					
					ct= (Connection) conn.getConn();
					int res=conn.update(sql);
					if(res!=-1) {
						JOptionPane.showMessageDialog(null, "删除成功");
					}
					else {
						JOptionPane.showMessageDialog(null, "删除失败，表中不存在相关记录");
					}
				}catch(Exception ee) {
					ee.printStackTrace();
				}finally {
					conn.closeConn();
				}
			}
		});
		btnDel.setBounds(83, 214, 111, 27);
		contentPane.add(btnDel);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(33, 75, 36, 18);
		contentPane.add(lblId);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(83, 72, 147, 24);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		JLabel label = new JLabel("\u59D3\u540D");
		label.setBounds(28, 120, 41, 18);
		contentPane.add(label);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(83, 117, 147, 24);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5B66\u53F7");
		label_1.setBounds(33, 168, 36, 18);
		contentPane.add(label_1);
		
		textFieldSno = new JTextField();
		textFieldSno.setBounds(83, 162, 147, 24);
		contentPane.add(textFieldSno);
		textFieldSno.setColumns(10);
	}

}
