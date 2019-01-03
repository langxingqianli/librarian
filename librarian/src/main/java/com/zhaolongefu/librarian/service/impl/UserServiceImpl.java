package com.zhaolongefu.librarian.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.zhaolongefu.librarian.dao.UserDao;
import com.zhaolongefu.librarian.entity.User;
import com.zhaolongefu.librarian.service.UserService;
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Resource(name="userDao")
	private UserDao userDao;
	/**
	 * 通过用户名和密码去数据库 查找user对象
	 * @param username
	 * @param password
	 * @return User
	 * @throws Exception
	 */
	public User getUserByNameAndPwd(String username, String password) throws Exception {
		return userDao.findUserByNameAndPwd(username,password);
	}

}
