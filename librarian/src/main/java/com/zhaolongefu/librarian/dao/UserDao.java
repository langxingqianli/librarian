package com.zhaolongefu.librarian.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zhaolongefu.librarian.base.dao.BaseDao;
import com.zhaolongefu.librarian.entity.User;

public interface UserDao extends BaseDao<User, Long>{
	@Query("from User u where u.username=:username and u.password=:password")
	public User findUserByNameAndPwd(@Param("username")String username,@Param("password") String password);

}
