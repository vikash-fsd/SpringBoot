package com.tutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.model.Book;
import com.tutorial.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private BookRepository bookrepo;
	
	@Transactional
	public Book findByID(long bookid){
		return bookrepo.getOne(bookid);
	}
	 
	@Transactional
	public void save(Book book) {
		bookrepo.save(book);
	}
	 
	@Transactional(readOnly = true)
	public List<Book> list() {
		return bookrepo.findAll();
	}
	
	@Transactional
	public void delete(long bookid) {
		bookrepo.deleteById(bookid);
	}

}
