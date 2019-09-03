package com.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.model.Book;

@Repository("bookRepository")
public interface BookRepository extends JpaRepository<Book, Long> {

}
