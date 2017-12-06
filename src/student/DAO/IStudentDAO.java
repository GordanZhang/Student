package student.DAO;

import java.util.List;
import student.model.student;

public interface IStudentDAO {
	boolean add(student stu);
	boolean delete(int id);
	boolean update(student stu);
	student queryBySno(String sno);
	student queryBySname(String sname);
	student queryByDepartment(String department);
	student queryByHometown(String Hometown);
	boolean queryMark(String sno);
	/**
	 * 查询整个学生表
	 * @return
	 */
	List<student> queryAll();
}
