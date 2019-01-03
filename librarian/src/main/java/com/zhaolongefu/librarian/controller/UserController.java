package com.zhaolongefu.librarian.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhaolongefu.librarian.base.controller.BaseController;
import com.zhaolongefu.librarian.entity.User;
import com.zhaolongefu.librarian.service.UserService;

@Controller("userController")
@RequestMapping("/user")
public class UserController extends BaseController{
	@Resource(name="userService")
	private UserService userService;
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String getLoginPage() throws Exception {
	//	System.out.println("感觉对就好");
		return "user/user_login_page";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String getLogin(String username, String password) throws Exception {
	//	System.out.println(username + "\t" + password);
		if (username != null && !"".equals(username) && password != null && !"".equals(password)) {
			User user = userService.getUserByNameAndPwd(username,password);
			if (user != null) {
				session.setAttribute("user", user);
				return "book/book_index";
				
			}
			return "user/user_login_page";
		}
		return "user/user_login_page";
	}
}
