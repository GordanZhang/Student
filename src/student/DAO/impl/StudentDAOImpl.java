package student.DAO.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import student.DAO.IStudentDAO;
import student.util.DBCon;
import student.model.student;

public class StudentDAOImpl implements IStudentDAO{
	DBCon util=new DBCon();
	@Override
	public boolean add(student stu) {
		// TODO Auto-generated method stub
		return util.update("insert into student(id,name,sno,department,hometown,mark,email,tel,sex) values(?,?,?,?,?,?,?,?,?)", 
				stu.getId(),stu.getName(),stu.getSno(),stu.getDepartment(),stu.getHometown(),stu.getMark(),stu.getEmail(),stu.getEmail(),stu.getSex())>0;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return util.update("delete from student where id=?", id)>0;
	}

	@Override
	public boolean update(student stu) {
		// TODO Auto-generated method stub
		return util.update("update student set name=?,sno=?,department=?,email=?,tel=? where id=?",stu.getName(),stu.getSno(),stu.getDepartment(),stu.getEmail(),stu.getTel(),stu.getId())>0;
	}

	@Override
	public student queryBySno(String sno) {
		// TODO Auto-generated method stub
		return _student(util.query("select * from student where sno=?", sno));  
	}

	@Override
	public student queryBySname(String sname) {
		// TODO Auto-generated method stub
		return _student(util.query("select * from student where sname=?", sname));
	}

	@Override
	public student queryByDepartment(String department) {
		// TODO Auto-generated method stub
		return _student(util.query("select * from student where department=?", department));
	}

	@Override
	public student queryByHometown(String Hometown) {
		// TODO Auto-generated method stub
		return _student(util.query("select * from student where hometown=?", Hometown));
	}

	@Override
	public boolean queryMark(String sno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<student> queryAll() {
		// TODO Auto-generated method stub
		return _list(util.query("select * from user"));  
	}
	private student _student(ResultSet rs) {
		// TODO Auto-generated method stub
		 student stu=null;  
	        try {  
	            if(rs.next()){  
	                stu=new student();  
	                stu.setId(rs.getInt("id")); 
	                stu.setName(rs.getString("name"));  
	                stu.setSno(rs.getString("sno"));  
	                stu.setDepartment(rs.getString("department"));
	                stu.setHometown(rs.getString("hometown"));
	                stu.setMark(rs.getString("mark"));
	                stu.setEmail(rs.getString("email"));
	                stu.setTel(rs.getString("tel"));
	                stu.setSex(rs.getString("sex"));
	            }  
	        } catch (SQLException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }finally{  
	            util.closeConn();  
	        }  
	        return stu;  
	}
	private List<student> _list(ResultSet rs) {
		// TODO Auto-generated method stub
		List<student> _list=new ArrayList<student>();  
        try {  
            while(rs.next()){  
            	student stu=new student();  
                stu.setId(rs.getInt("id")); 
                stu.setName(rs.getString("name"));  
                stu.setSno(rs.getString("sno"));  
                stu.setDepartment(rs.getString("department"));
                stu.setHometown(rs.getString("hometown"));
                stu.setMark(rs.getString("mark"));
                stu.setEmail(rs.getString("email"));
                stu.setTel(rs.getString("tel"));
                stu.setSex(rs.getString("sex")); 
                _list.add(stu);  
            }  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }finally{  
            util.closeConn();  
        }  
        return _list;  
	}

}
