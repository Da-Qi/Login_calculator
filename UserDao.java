package cn.itcast.dao;

import cn.itcast.pojo.User;

public interface UserDao {
	/**
	 * 这是用户登录功能
	 * @param username	用户名
	 * @param password	密码
	 * @return 登录是否成功
	 */
	
	public abstract boolean login(String username,String password);
	
	/**
	 * 这是用户注册功能
	 * @param user	被注册的用户信息
	 */
	public abstract void regist(User user);
}
