package student.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import student.util.DBCon;

import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;

public class QueryForm extends JFrame{
	private JTextField textFieldSno;
	private JTextField textFieldName;
	
	private JTable jt=null;
	private JScrollPane jsp=null;
	private DefaultTableModel dataModel;
	private PreparedStatement ps=null;  
	private Connection ct=null;  
	private ResultSet rs=null;
	
	private String sql="";
	boolean flag=false;
	Vector rowData,columnNames; 
	public QueryForm() {
		setResizable(false);
		
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
        
		
		setTitle("\u67E5\u8BE2");
		setBounds(0,0,700,600);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(14, 13, 654, 205);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton buttonQueryAll = new JButton("\u67E5\u8BE2\u6240\u6709\u8BB0\u5F55");
		buttonQueryAll.setBounds(26, 13, 132, 27);
		panel.add(buttonQueryAll);
		
		JButton btnQueryBySno = new JButton("\u901A\u8FC7\u5B66\u53F7\u67E5\u8BE2");
		btnQueryBySno.setBounds(26, 72, 132, 27);
		panel.add(btnQueryBySno);
		
		JButton btnQueryByName = new JButton("\u901A\u8FC7\u59D3\u540D\u67E5\u8BE2");
		btnQueryByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name=textFieldName.getText();
				try {
					
					//加载驱动  
                    Class.forName("com.mysql.jdbc.Driver");  
                    //得到连接  
                    ct=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","123456");  
                      
                    ps=ct.prepareStatement("select * from student where name='"+name+"'");  
                      
                    rs=ps.executeQuery();  
                      
                    if(rs.next()){  
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
                        jt.repaint();
                        jt.setModel(dataModel); 
                        //初始化 jsp  
                        jsp = new JScrollPane(jt);
                        jsp.setLayout(new ScrollPaneLayout());
                        jsp.setBounds(14, 191, 654, 274);
                        
                        //把jsp放入到jframe  
                        getContentPane().add(jsp);
                        
                        //reset();
                    	}
                    else {
                    	JOptionPane.showMessageDialog(null, "查询不到相关记录");
                    }
                    
            } catch (Exception e) {  
                e.printStackTrace();  
            } finally{  
                  
                    try {  
                        if(rs!=null){  
                        rs.close();  
                        }  
                        if(ps!=null){  
                            ps.close();  
                        }  
                        if(ct!=null){  
                            ct.close();  
                        }  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                    }  
            }
			}
		});
		btnQueryByName.setBounds(26, 139, 132, 27);
		panel.add(btnQueryByName);
		
		textFieldSno = new JTextField();
		textFieldSno.setBounds(173, 72, 158, 27);
		panel.add(textFieldSno);
		textFieldSno.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(173, 140, 158, 24);
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		JComboBox comboBoxDept = new JComboBox<String>();
		comboBoxDept.setBounds(491, 73, 132, 24);
		panel.add(comboBoxDept);
		comboBoxDept.setModel(new DefaultComboBoxModel(new String[] {"\u5E94\u7528\u79D1\u5B66\u5B66\u9662", "\u8BA1\u7B97\u673A\u79D1\u5B66\u4E0E\u6280\u672F\u5B66\u9662", "\u5916\u56FD\u8BED\u5B66\u9662"}));
		
		JButton btnQueryByDepartment = new JButton("\u901A\u8FC7\u9662\u7CFB\u67E5\u8BE2");
		btnQueryByDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dept="";
				if(comboBoxDept.getSelectedItem()!=null) {
					 dept=(String) comboBoxDept.getSelectedItem();
				}
				try {
					
					//加载驱动  
                    Class.forName("com.mysql.jdbc.Driver");  
                    //得到连接  
                    ct=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","123456");  
                      
                    ps=ct.prepareStatement("select * from student where department='"+dept+"'");  
                      
                    rs=ps.executeQuery();  
                      
                    if(rs.next()){  
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
                        jt.repaint();
                        jt.setModel(dataModel); 
                        //初始化 jsp  
                        jsp = new JScrollPane(jt);
                        jsp.setLayout(new ScrollPaneLayout());
                        jsp.setBounds(14, 191, 654, 274);
                        
                        //把jsp放入到jframe  
                        getContentPane().add(jsp);
                        
                        //reset();
                    }
                    else {
                    	JOptionPane.showMessageDialog(null, "查询不到相关记录");
                    }
                 
            } catch (Exception ee) {  
                ee.printStackTrace();  
            } finally{  
                  
                    try {  
                        if(rs!=null){  
                        rs.close();  
                        }  
                        if(ps!=null){  
                            ps.close();  
                        }  
                        if(ct!=null){  
                            ct.close();  
                        }  
                    } catch (SQLException sqe) {  
                        sqe.printStackTrace();  
                    }  
            }
			}
		});
		btnQueryByDepartment.setBounds(345, 72, 132, 27);
		panel.add(btnQueryByDepartment);
		
		
		btnQueryBySno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sno=textFieldSno.getText();
				try {
					
						//加载驱动  
	                    Class.forName("com.mysql.jdbc.Driver");  
	                    //得到连接  
	                    ct=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","123456");  
	                      
	                    ps=ct.prepareStatement("select * from student where sno='"+sno+"'");  
	                      
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
	                        jt.repaint();
	                        jt.setModel(dataModel); 
	                        //初始化 jsp  
	                        jsp = new JScrollPane(jt);
	                        jsp.setLayout(new ScrollPaneLayout());
	                        jsp.setBounds(14, 191, 654, 274);
	                        
	                        //把jsp放入到jframe  
	                        getContentPane().add(jsp);
	                        
	                        //reset();
					}
                } catch (Exception e) {  
                    e.printStackTrace();  
                } finally{  
                      
                        try {  
                            if(rs!=null){  
                            rs.close();  
                            }  
                            if(ps!=null){  
                                ps.close();  
                            }  
                            if(ct!=null){  
                                ct.close();  
                            }  
                        } catch (SQLException e) {  
                            e.printStackTrace();  
                        }  
                }
			}
		});
		buttonQueryAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					while(!flag)
					{
						//加载驱动  
	                    Class.forName("com.mysql.jdbc.Driver");  
	                    //得到连接  
	                    ct=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","123456");  
	                      
	                    ps=ct.prepareStatement("select * from student");  
	                      
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
	                        flag=true;
	                        
	                    }  
					}
                } catch (Exception e) {  
                    e.printStackTrace();  
                } finally{  
                      
                        try {  
                            if(rs!=null){  
                            rs.close();  
                            }  
                            if(ps!=null){  
                                ps.close();  
                            }  
                            if(ct!=null){  
                                ct.close();  
                            }  
                        } catch (SQLException e) {  
                            e.printStackTrace();  
                        }  
                }
                
			}
		});
		
		
		
		
	}
	public void reset()
	{
		dataModel.setRowCount(0);
	}
}
