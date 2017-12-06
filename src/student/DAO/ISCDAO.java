package student.DAO;

import java.util.List;
import student.model.SC;
import student.model.student;

public interface ISCDAO {
	/**
	 * ¼��ѧ���ɼ�
	 * @param sc
	 * @return
	 */
	boolean add(SC sc);
	/**
	 * ɾ��ѧ���ɼ�
	 * @param id
	 * @return
	 */
	boolean delete(String sno,String cname);
	/*
	 * �޸�ѧ���ɼ�
	 */
	boolean update(SC sc);
	/**
	 * ͨ��ѧ�Ų�ѯ
	 * @param sno
	 * @return
	 */
	SC queryBySno(String sno);
	/**
	 * ͨ��������ѯ
	 * @param sname
	 * @return
	 */
	SC queryBySname(String sname);
	/**
	 * ͨ���γ�����ѯ
	 * @param cname
	 * @return
	 */
	SC queryByCname(String cname);
	/**
	 * ͨ��������ѯ
	 * @param score
	 * @return
	 */
	SC queryByScore(int score);
	/**
	 * ��ѯ����SC��
	 * @return
	 */
	List<SC> queryAll();
}
