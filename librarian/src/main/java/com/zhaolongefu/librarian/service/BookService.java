package com.zhaolongefu.librarian.service;

import com.zhaolongefu.librarian.entity.Book;
import com.zhaolongefu.librarian.entity.WinPage;

public interface BookService {

	public WinPage<Book> getListByQuery(WinPage<Book> winPage, String query)throws Exception;
	/**
	 * 通过bookName获得Book对象
	 * @param bookName
	 * @return Book
	 * @throws Exception
	 */
	public Book getBookByBookName(String bookName)throws Exception;
	public boolean save(Book book)throws Exception;
	/**
	 * 通过bookId获得book对象
	 * @param bookId
	 * @return Book
	 * @throws Exception
	 */
	public Book getBookByBookId(Long bookId)throws Exception;
	public boolean getDeleteBookByBookId(Long bookId)throws Exception;

}
