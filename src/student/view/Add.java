package student.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import student.DAO.impl.StudentDAOImpl;
import student.model.student;

import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.DefaultComboBoxModel;

public class Add extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldID;
	private JTextField textFieldName;
	private JTextField textFieldSno;
	private JTextField textFieldGPA;
	private JTextField textFieldEmail;
	private JTextField textFieldTel;
	private StudentDAOImpl stuDao;
	
	private JTable jt=null;
	private JScrollPane jsp=null;
	private DefaultTableModel dataModel;
	private PreparedStatement ps=null;  
	private Connection ct=null;  
	private ResultSet rs=null;
	
	private String sql="";
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			Add dialog = new Add();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the dialog.
	 */
	public Add(MainForm mf) {
		super(mf,"添加记录",true);
		
		setBounds(100, 100, 849, 655);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblId = new JLabel("ID");
			lblId.setBounds(14, 13, 27, 18);
			contentPanel.add(lblId);
		}
		
			JLabel lblNewLabel = new JLabel("\u59D3\u540D");
			lblNewLabel.setBounds(14, 44, 40, 18);
			contentPanel.add(lblNewLabel);
		
		{
			JLabel lblNewLabel_1 = new JLabel("\u5B66\u53F7");
			lblNewLabel_1.setBounds(14, 93, 40, 18);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("\u9662\u7CFB");
			lblNewLabel_2.setBounds(14, 124, 40, 18);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("\u7C4D\u8D2F");
			lblNewLabel_3.setBounds(200, 13, 40, 18);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("GPA");
			lblNewLabel_4.setBounds(200, 44, 40, 18);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("email");
			lblNewLabel_5.setBounds(200, 93, 46, 18);
			contentPanel.add(lblNewLabel_5);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("\u7535\u8BDD");
			lblNewLabel_6.setBounds(200, 124, 40, 18);
			contentPanel.add(lblNewLabel_6);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("\u6027\u522B");
			lblNewLabel_7.setBounds(14, 163, 40, 18);
			contentPanel.add(lblNewLabel_7);
		}
		
			JComboBox comboBoxDept = new JComboBox();
			comboBoxDept.setModel(new DefaultComboBoxModel(new String[] {"\u5E94\u7528\u79D1\u5B66\u5B66\u9662", "\u8BA1\u7B97\u673A\u5B66\u9662", "\u5916\u56FD\u8BED\u5B66\u9662", "\u7535\u5B50\u5B66\u9662", "\u673A\u68B0\u5DE5\u7A0B\u5B66\u9662", "\u6750\u6599\u5B66\u9662", "\u4F53\u80B2\u5B66\u9662", "\u4EBA\u6587\u5B66\u9662", "\u6CD5\u5B66\u9662", "\u7ECF\u7BA1\u5B66\u9662"}));
			comboBoxDept.setBounds(68, 121, 118, 24);
			contentPanel.add(comboBoxDept);
		
		
			JComboBox comboBoxHome = new JComboBox();
			comboBoxHome.setModel(new DefaultComboBoxModel(new String[] {"\u5317\u4EAC", "\u5929\u6D25", "\u6CB3\u5317", "\u8FBD\u5B81", "\u5409\u6797", "\u9ED1\u9F99\u6C5F", "\u5185\u8499\u53E4", "\u65B0\u7586", "\u7518\u8083", "\u9752\u6D77", "\u5B81\u590F", "\u9655\u897F", "\u5C71\u897F", "\u6CB3\u5357", "\u5C71\u4E1C", "\u6E56\u5317", "\u6E56\u5357", "\u6C5F\u82CF", "\u4E0A\u6D77", "\u5B89\u5FBD", "\u6D59\u6C5F", "\u6C5F\u897F", "\u56DB\u5DDD", "\u91CD\u5E86", "\u8D35\u5DDE", "\u4E91\u5357", "\u897F\u85CF", "\u5E7F\u897F", "\u5E7F\u4E1C", "\u6D77\u5357", "\u9999\u6E2F", "\u6FB3\u95E8"}));
			comboBoxHome.setBounds(254, 10, 118, 24);
			contentPanel.add(comboBoxHome);
		
		{
			textFieldID = new JTextField();
			textFieldID.setBounds(67, 10, 118, 24);
			contentPanel.add(textFieldID);
			textFieldID.setColumns(10);
		}
		{
			textFieldName = new JTextField();
			textFieldName.setBounds(68, 44, 118, 24);
			contentPanel.add(textFieldName);
			textFieldName.setColumns(10);
		}
		{
			textFieldSno = new JTextField();
			textFieldSno.setBounds(67, 90, 119, 24);
			contentPanel.add(textFieldSno);
			textFieldSno.setColumns(10);
		}
		{
			textFieldGPA = new JTextField();
			textFieldGPA.setBounds(254, 41, 118, 24);
			contentPanel.add(textFieldGPA);
			textFieldGPA.setColumns(10);
		}
		{
			textFieldEmail = new JTextField();
			textFieldEmail.setBounds(254, 90, 118, 24);
			contentPanel.add(textFieldEmail);
			textFieldEmail.setColumns(10);
		}
		{
			textFieldTel = new JTextField();
			textFieldTel.setBounds(254, 121, 118, 24);
			contentPanel.add(textFieldTel);
			textFieldTel.setColumns(10);
		}
		
			JComboBox comboBoxSex = new JComboBox();
			comboBoxSex.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
			comboBoxSex.setBounds(68, 160, 72, 24);
			contentPanel.add(comboBoxSex);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int id=Integer.parseInt(textFieldID.getText());
						String name=textFieldName.getText();
						String sno=textFieldSno.getText();
						String dept=comboBoxDept.getSelectedItem().toString();
						String hometown=comboBoxHome.getSelectedItem().toString();
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
		                    boolean res=stuDao.add(stu);  
		                    
		                    
		                    if(res==true){  
		                        //rowData可以存放多行  
		                    	JOptionPane.showMessageDialog(null, "添加成功");
		                    }
		                    else JOptionPane.showMessageDialog(null, "添加失败");
						
						}catch(Exception ee) {
							ee.printStackTrace();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
