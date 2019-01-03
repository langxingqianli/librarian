package com.zhaolongefu.librarian.service.impl;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.zhaolongefu.librarian.dao.BookDao;
import com.zhaolongefu.librarian.entity.Book;
import com.zhaolongefu.librarian.entity.WinPage;
import com.zhaolongefu.librarian.service.BookService;
@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {
	@Resource(name="bookDao")
	private BookDao bookDao;
	
	public WinPage<Book> getListByQuery(WinPage<Book> winPage, String query) throws Exception {
		Pageable pageable = PageRequest.of(winPage.getPageNum() - 1, winPage.getPageSize(), Direction.ASC, "bookId");
		// 进行分页查询
		Page<Book> page = null;
		if (query != null) {
			page = bookDao.findAll(new Specification<Book>() {
				private static final long serialVersionUID = 1L;
				public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
					// 形成如下where条件：where r.Category_name like '%query%' or r.CategoryCode like '%query%';
					Predicate predicate = cb.like(root.get("bookName"), "%" + query + "%"); 
							
					return cq.where(predicate).getRestriction();
				}
			}, pageable);
		} else {
			page = bookDao.findAll(pageable);
		}
		// 通过Page对象，提取数据，获得结果
		winPage.parsePageToWinPage(page);
		return winPage;
	}
	/**
	 * 通过bookName获得Book对象
	 * @param bookName
	 * @return Book
	 * @throws Exception
	 */
	public Book getBookByBookName(String bookName) throws Exception {
		
		return bookDao.findBookByBookName(bookName);
	}
	
	public boolean save(Book book) throws Exception {
		try {
			bookDao.save(book);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 通过bookId获得book对象
	 * @param bookId
	 * @return Book
	 * @throws Exception
	 */
	public Book getBookByBookId(Long bookId) throws Exception {
		
		return bookDao.getOne(bookId);
	}
	
	public boolean getDeleteBookByBookId(Long bookId) throws Exception {
		try {
			bookDao.deleteById(bookId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
