package com.tutorial.service;

import java.util.List;

import com.tutorial.model.Book;

public interface BookService {
	
	Book findByID(long bookid);
	
	void save(Book book);
	
	List<Book> list();
	
	void delete(long bookid);
}
