package cn.itcast.dao;

import cn.itcast.pojo.User;

public interface UserDao {
	/**
	 * �����û���¼����
	 * @param username	�û���
	 * @param password	����
	 * @return ��¼�Ƿ�ɹ�
	 */
	
	public abstract boolean login(String username,String password);
	
	/**
	 * �����û�ע�Ṧ��
	 * @param user	��ע����û���Ϣ
	 */
	public abstract void regist(User user);
}
