package com.spring.service;

import java.util.List;

import com.spring.bean.Book;

public interface BookService {

	public List<Book> getAllBook();
	public Book getBookById(int id);
	public Book save(Book book);
	public Book deleteBookById(int id);
	public Book update(Book book);
}
