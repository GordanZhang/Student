package student.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;

import student.model.*;
import student.DAO.impl.*;
import student.DAO.*;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Label;
import javax.swing.JCheckBox;

public class AddForm extends JDialog {

	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldName;
	private JTextField textFieldSno;
	private JTextField textFieldGPA;
	private JTextField textFieldEmail;
	private JTextField textFieldTel;
	private JFrame iframe;
	private StudentDAOImpl stuDao;
	
	private JTable jt=null;
	private JScrollPane jsp=null;
	private DefaultTableModel dataModel;
	private PreparedStatement ps=null;  
	private Connection ct=null;  
	private ResultSet rs=null;
	
	private String sql="";
	Vector rowData,columnNames; 
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddForm frame = new AddForm();
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
	public AddForm() {
		
		 
		//super(pframe,"添加记录",true);
		//this.iframe=pframe;
		//setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("\u6DFB\u52A0\u8BB0\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 738);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		columnNames=new Vector();  
        //设置列名  
        columnNames.add("id");  
        columnNames.add("名字"); 
        columnNames.add("学号");
        columnNames.add("院系");
        columnNames.add("籍贯");  
        columnNames.add("GPA");
        columnNames.add("email");
        columnNames.add("联系电话");  
        columnNames.add("性别");  
          
        rowData = new Vector(); 
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u5317\u4EAC", "\u5929\u6D25", "\u6CB3\u5317", "\u8FBD\u5B81", "\u5409\u6797", "\u9ED1\u9F99\u6C5F", "\u5185\u8499\u53E4", "\u65B0\u7586", "\u7518\u8083", "\u9752\u6D77", "\u5B81\u590F", "\u9655\u897F", "\u5C71\u897F", "\u6CB3\u5357", "\u5C71\u4E1C", "\u6E56\u5317", "\u6E56\u5357", "\u6C5F\u82CF", "\u4E0A\u6D77", "\u5B89\u5FBD", "\u6D59\u6C5F", "\u6C5F\u897F", "\u56DB\u5DDD", "\u91CD\u5E86", "\u8D35\u5DDE", "\u4E91\u5357", "\u897F\u85CF", "\u5E7F\u897F", "\u5E7F\u4E1C", "\u6D77\u5357", "\u9999\u6E2F", "\u6FB3\u95E8"}));
		comboBox.setBounds(281, 13, 137, 24);
		contentPane.add(comboBox);
		
		JComboBox comboBoxDept = new JComboBox();
		comboBoxDept.setModel(new DefaultComboBoxModel(new String[] {"\u5E94\u7528\u79D1\u5B66\u5B66\u9662", "\u8BA1\u7B97\u673A\u5B66\u9662", "\u5916\u56FD\u8BED\u5B66\u9662", "\u7535\u5B50\u5B66\u9662", "\u673A\u68B0\u5DE5\u7A0B\u5B66\u9662", "\u6750\u6599\u5B66\u9662", "\u4F53\u80B2\u5B66\u9662", "\u4EBA\u6587\u5B66\u9662", "\u6CD5\u5B66\u9662", "\u7ECF\u7BA1\u5B66\u9662"}));
		comboBoxDept.setBounds(59, 119, 137, 24);
		contentPane.add(comboBoxDept);
		
		JComboBox comboBoxSex = new JComboBox();
		comboBoxSex.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
		comboBoxSex.setBounds(281, 140, 86, 24);
		contentPane.add(comboBoxSex);
		
		JButton btnAdd = new JButton("\u6DFB\u52A0");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(textFieldID.getText());
				String name=textFieldName.getText();
				String sno=textFieldSno.getText();
				String dept=comboBoxDept.getSelectedItem().toString();
				String hometown=comboBox.getSelectedItem().toString();
				String gpa=textFieldGPA.getText();
				String email=textFieldEmail.getText();
				String tel=textFieldTel.getText();
				String sex=comboBoxSex.getSelectedItem().toString();
				
				student stu=new student();
				stu.setId(id);
				stu.setName(name);
				stu.setSno(sno);
				stu.setDepartment(dept);
				stu.setHometown(hometown);
				stu.setMark(gpa);
				stu.setEmail(email);
				stu.setTel(tel);
				stu.setSex(sex);
				
				stuDao=new StudentDAOImpl();
				try {
					//加载驱动  
                    Class.forName("com.mysql.jdbc.Driver");  
                    //得到连接  
                    ct=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","123456");  
                      
                    ps=ct.prepareStatement("insert into student(id,name,sno,department,hometown,mark,email,tel,sex) values("+id+","+name+","+sno+","+dept+","+hometown+","+gpa+","+email+","+tel+","+sex+")");  
                      
                    rs=ps.executeQuery();
                    
                    while(rs.next()){  
                        //rowData可以存放多行  
                        Vector hang=new Vector();  
                        hang.add(rs.getInt(1));  
                        hang.add(rs.getString(2));  
                        hang.add(rs.getString(3));  
                        hang.add(rs.getString(4));  
                        hang.add(rs.getString(5));  
                        hang.add(rs.getString(6));  
                        hang.add(rs.getString(7)); 
                        hang.add(rs.getString(8));
                        hang.add(rs.getString(9));
                        //加入到rowData  
                        rowData.add(hang);  
                        getContentPane().setLayout(null);
                        //初始化Jtable  
                        dataModel = new DefaultTableModel(rowData, columnNames);
                        dataModel.fireTableDataChanged();
                        jt = new JTable();  
                        jt.setModel(dataModel);
                        jt.updateUI();  
                        //初始化 jsp  
                        jsp = new JScrollPane(jt);
                        jsp.setLayout(new ScrollPaneLayout());
                        jsp.setBounds(14, 191, 654, 274);
                        
                        //把jsp放入到jframe  
                        getContentPane().add(jsp);
                        
                    }
				
				}catch(Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(59, 171, 107, 27);
		contentPane.add(btnAdd);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(59, 13, 137, 24);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(14, 13, 31, 18);
		contentPane.add(lblId);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D");
		lblNewLabel.setBounds(14, 47, 44, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u53F7");
		lblNewLabel_1.setBounds(14, 78, 37, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u9662\u7CFB");
		lblNewLabel_2.setBounds(14, 122, 44, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u7C4D\u8D2F");
		lblNewLabel_3.setBounds(240, 16, 31, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblGpa = new JLabel("GPA");
		lblGpa.setBounds(240, 47, 31, 18);
		contentPane.add(lblGpa);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(227, 78, 44, 18);
		contentPane.add(lblEmail);
		
		JLabel lblNewLabel_4 = new JLabel("\u7535\u8BDD");
		lblNewLabel_4.setBounds(234, 109, 37, 18);
		contentPane.add(lblNewLabel_4);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(59, 44, 137, 24);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldSno = new JTextField();
		textFieldSno.setBounds(59, 75, 137, 24);
		contentPane.add(textFieldSno);
		textFieldSno.setColumns(10);
		
		
		
		textFieldGPA = new JTextField();
		textFieldGPA.setBounds(281, 44, 137, 24);
		contentPane.add(textFieldGPA);
		textFieldGPA.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(281, 75, 137, 24);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(281, 106, 137, 24);
		contentPane.add(textFieldTel);
		textFieldTel.setColumns(10);
		
		Label label = new Label("\u6027\u522B");
		label.setBounds(234, 139, 37, 25);
		contentPane.add(label);
		
		
		
		
	}
}
