package com.zhaolongefu.librarian.service;

import com.zhaolongefu.librarian.entity.User;

public interface UserService {
	/**
	 * 通过用户名和密码去数据库 查找user对象
	 * @param username
	 * @param password
	 * @return User
	 * @throws Exception
	 */
	public User getUserByNameAndPwd(String username, String password)throws Exception;

}
