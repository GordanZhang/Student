package student.util;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;

import javax.swing.JOptionPane;  
/**
 * 数据库连接封装
 * @author 张国栋
 *
 */
public class DBCon {
	public static final String DRIVER="com.mysql.jdbc.Driver";
	public static final String URL="jdbc:mysql://localhost:3306/student";
	public static final String USERNAME="root";
	public static final String PASSWORD="123456";
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public DBCon()
	{
		try 
		{
			Class.forName(DRIVER);
		}catch(ClassNotFoundException e){
			JOptionPane.showMessageDialog(null, "jdbc driver is not found");
			e.printStackTrace();
		}
	}
	/**
	 * 建立连接
	 * @return
	 */
	public Connection getConn()
	{	
		try {
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 关闭连接
	 */
	public void closeConn()
	{
		if(rs!=null) {
			try {
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null) {
			try {
				ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public int update(String sql)
	{
		int result = -1;  
        if (getConn() == null) {  
            return result;  
        }  
        try {  
            ps = conn.prepareStatement(sql);  
            result = ps.executeUpdate();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return result;  
	}
	public int update(String sql,Object... obj)
	{
		int result=-1;
		conn=getConn();
		try {
			ps=conn.prepareStatement(sql);
			if(obj!=null) {
				for(int i=0;i<obj.length;i++){  
                    ps.setObject(i+1, obj[i]);  
                }  
			}
			result=ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeConn();
		}
		return result;
	}
	public ResultSet query(String sql)
	{
		conn=getConn();
		if(conn==null) {
			return null;
		}
		try {
			ps = conn.prepareStatement(sql);  
            rs = ps.executeQuery();  
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeConn();
		}
		return rs;
	}
	public ResultSet query(String sql,Object... obj)
	{
		conn=getConn();
		if(conn==null) {
			return null;
		}
		try {
			 ps=conn.prepareStatement(sql);  
	            if(obj!=null){  
	                for(int i=0;i<obj.length;i++){  
	                    ps.setObject(i+1, obj[i]);  
	                }  
	            }  
	            rs=ps.executeQuery();  
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeConn();
		}
		return rs;
	}
	
}
