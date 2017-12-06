package student.DAO;

import java.util.List;
import student.model.SC;
import student.model.student;

public interface ISCDAO {
	/**
	 * 录入学生成绩
	 * @param sc
	 * @return
	 */
	boolean add(SC sc);
	/**
	 * 删除学生成绩
	 * @param id
	 * @return
	 */
	boolean delete(String sno,String cname);
	/*
	 * 修改学生成绩
	 */
	boolean update(SC sc);
	/**
	 * 通过学号查询
	 * @param sno
	 * @return
	 */
	SC queryBySno(String sno);
	/**
	 * 通过姓名查询
	 * @param sname
	 * @return
	 */
	SC queryBySname(String sname);
	/**
	 * 通过课程名查询
	 * @param cname
	 * @return
	 */
	SC queryByCname(String cname);
	/**
	 * 通过分数查询
	 * @param score
	 * @return
	 */
	SC queryByScore(int score);
	/**
	 * 查询整个SC表
	 * @return
	 */
	List<SC> queryAll();
}
