package com.zhaolongefu.librarian.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zhaolongefu.librarian.base.dao.BaseDao;
import com.zhaolongefu.librarian.entity.Book;

public interface BookDao extends BaseDao<Book, Long> {
	@Query("from Book b where b.bookName=:bookName")
	public Book findBookByBookName(@Param("bookName")String bookName)throws Exception;

}
