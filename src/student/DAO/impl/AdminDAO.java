package student.DAO.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import javax.swing.JOptionPane;

public class AdminDAO {
	Connection con = null;
	Statement statement = null;
	ResultSet res = null;
	String driver = "com.mysql.jdbc.Driver";
	String url  = "jdbc:mysql://localhost:3306/student";
	String name = "root";
	String passwd = "123456";
	public AdminDAO()
	{
		 try{
			    Class.forName(driver).newInstance();
			    con = DriverManager.getConnection(url,name,passwd);
			    statement = con.createStatement();
			     
			    }catch(ClassNotFoundException e){
			        System.out.println("对不起，找不到这个Driver");
			        e.printStackTrace();
			    }catch(SQLException e){
			        e.printStackTrace();
			    }catch(Exception e){
			        e.printStackTrace();
			        }
	}
	public boolean compare(String username,String password){
	    boolean m = false;
	    String sql = "select password from admin where id=\""+username+"\"";
	    try{
	        res = statement.executeQuery(sql);
	        if(res.next()){
	            String pa = res.getString(1);
	            System.out.println(pa+" " +password);
	            if(pa.equals(password)){
	                m = true;
	            }else {
	                JOptionPane.showMessageDialog(null, "密码错误！");
	            }
	        }else {
	            JOptionPane.showMessageDialog(null, "用户名不存在！");
	        }
	        res.close();
	        con.close();
	        statement.close();
	         
	    }catch(SQLException e){
	        e.printStackTrace();
	    }
	    return m;
	}
}
