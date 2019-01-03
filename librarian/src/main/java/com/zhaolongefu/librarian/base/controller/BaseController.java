package com.zhaolongefu.librarian.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller("baseController")
public class BaseController {
	@Autowired
	protected HttpServletRequest request;
	
	@Autowired
	protected HttpSession session;
}
