package com.zhaolongefu.librarian.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhaolongefu.librarian.base.controller.BaseController;
import com.zhaolongefu.librarian.entity.Book;
import com.zhaolongefu.librarian.entity.WinPage;
import com.zhaolongefu.librarian.service.BookService;
import com.zhaolongefu.librarian.util.DateUtil;
@Controller("bookController")
@RequestMapping("/book")
public class BookController extends BaseController{
	@Resource(name="bookService")
	private BookService bookService;
	@RequestMapping(value="/list", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getListByPage(Integer pageNum, Integer pageSize, Integer draw, String query) throws Exception {
		System.out.println(1);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// 通过pageNum和pageSize形成分页对象WinMallPage
		WinPage<Book> winPage = new WinPage<Book>(pageNum, pageSize, draw);
	//	System.out.println("111"+winMallPage.getPageSize());
		// 判断此时用户是否进行了分页查询
		if (query != null && !"".equals(query)) {
			// 将查询条件放到最终的结果中，用于交给前端进行显示
			resultMap.put("query", query);
			winPage = bookService.getListByQuery(winPage, query);
		} else {
			// 用户不进行模糊匹配查询
			resultMap.put("query", "");
			winPage = bookService.getListByQuery(winPage, null);
		}
		resultMap.put("page",winPage);
		return resultMap;
	}
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String getIndex() throws Exception{
		return "book/book_index";
	}
	@RequestMapping(value="/addbook")
	public String getAddBook()throws Exception{
		return "book/book_save";
	}
	@RequestMapping(value="/checkBookName",method=RequestMethod.POST)
	@ResponseBody
	public boolean checkBookName(Long bookId, String bookName)throws Exception{
		if (bookName != null && !"".equals(bookName)) {
			//通过bookName去数据库查找是是否有book这个对象
			Book book = bookService.getBookByBookName(bookName);
			//如果是从数据库查出来是null,就证明可以填写
			if (book == null || (book != null && book.getBookId() == bookId)) {
				return true;
			}
		}
		return false;
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public boolean save(Book book,String publishDate)throws Exception {
		Date date = new Date();
		date = DateUtil.getbrithday(publishDate);
		book.setPublishDate(date);
		return bookService.save(book);
	}
	@RequestMapping(value="/updatebook")
	public ModelAndView getUpdatePage(Long bookId)throws Exception {
		//通过bookId获得book对象
		Book book = bookService.getBookByBookId(bookId);
		Map<String, Object> pMap = new HashMap<String,Object>();
		pMap.put("book", book);
		return new ModelAndView("book/book_update",pMap);
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	@ResponseBody
	public boolean getUpdatePage(Long bookId,String publishDate,Book book)throws Exception{
		if (book.getBookId() == bookId) {
			Date date = new Date();
			date = DateUtil.getbrithday(publishDate);
			book.setPublishDate(date);
			return bookService.save(book);
		}
		return false;
	}
	@RequestMapping(value="/detailbook")
	public ModelAndView getDetailPage(Long bookId)throws Exception {
		Book book = bookService.getBookByBookId(bookId);
		return new ModelAndView("book/book_detail","book",book);
	}
	@RequestMapping(value="/delete/{bookId}",method=RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteBook(@PathVariable("bookId")Long bookId) throws Exception{
		boolean flag = bookService.getDeleteBookByBookId(bookId);
		if (flag) {
			return true;
		}
		return false;
	}
}



















































