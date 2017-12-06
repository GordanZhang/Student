package student.DAO.impl;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.ArrayList;  
import java.util.List; 

import student.util.DBCon;
import student.DAO.ISCDAO;
import student.model.SC;
import student.model.student;

public class SCDAOImpl implements ISCDAO{
	DBCon util=new DBCon();
	@Override
	public boolean add(SC sc) {
		// TODO Auto-generated method stub
		return util.update("insert into SC(sno,sname,cname,score) values(?,?,?,?)", 
				sc.getSno(),sc.getSname(),sc.getCname(),sc.getScore())>0;
	}

	@Override
	public boolean delete(String sno, String cname) {
		// TODO Auto-generated method stub
		return util.update("delete from SC where sno=? and cname=?", sno,cname)>0;
	}

	@Override
	public boolean update(SC sc) {
		// TODO Auto-generated method stub
		return util.update("update SC set score=? where sno=? and cname=?",sc.getScore(),sc.getSno(),sc.getCname())>0;
	}

	@Override
	public SC queryBySno(String sno) {
		// TODO Auto-generated method stub
		return _sc(util.query("select * from SC where sno=?", sno));  
	}
	
	@Override
	public SC queryBySname(String sname) {
		// TODO Auto-generated method stub
		return _sc(util.query("select * from SC where sname=?", sname));
	}

	@Override
	public SC queryByCname(String cname) {
		// TODO Auto-generated method stub
		return _sc(util.query("select * from SC where cname=?", cname));
	}

	@Override
	public SC queryByScore(int score) {
		// TODO Auto-generated method stub
		return _sc(util.query("select * from SC where score=?", score));
	}

	@Override
	public List<SC> queryAll() {
		// TODO Auto-generated method stub
		 return _list(util.query("select * from SC"));
	}
	
	private SC _sc(ResultSet rs) {
		// TODO Auto-generated method stub
		SC sc=null;  
        try {  
            if(rs.next()){  
                sc=new SC();  
                sc.setSno(rs.getString("sno")); 
                sc.setSname(rs.getString("sname"));  
                sc.setCname(rs.getString("cname"));  
                sc.setScore(rs.getInt("score"));
            
            }  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }finally{  
            util.closeConn();  
        }  
        return sc;  
	}
	
	private List<SC> _list(ResultSet rs) {
		// TODO Auto-generated method stub
		List<SC> _list=new ArrayList<SC>();  
        try {  
            while(rs.next()){  
                SC sc=new SC();  
                sc.setSno(rs.getString("sno"));  
                sc.setSname(rs.getString("sname"));
                sc.setCname(rs.getString("cname"));
                sc.setScore(rs.getInt("score"));
                _list.add(sc);  
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
