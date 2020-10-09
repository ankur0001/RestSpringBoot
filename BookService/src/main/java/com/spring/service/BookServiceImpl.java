package com.spring.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.bean.Book;
import com.spring.data.BookData;

@Component
public class BookServiceImpl  implements BookService{

	@Autowired
	BookData data;
	
	@Override
	public List<Book> getAllBook() {
		return data.getAllBooks();
	}

	@Override
	public Book getBookById(int id) {
		for(Book book:data.getAllBooks()) {
			if(book.getId()==id)
				return book;
		}
			
		return null;
	}

	@Override
	public Book save(Book book) {
		if(book.getId() ==0) {
			book.setId(data.getAllBooks().size()+1);
		}
		data.getAllBooks().add(book);
		return book;
	}

	@Override
	public Book deleteBookById(int id) {
		Iterator<Book> iterator = data.getAllBooks().iterator();
		
		while(iterator.hasNext()) {
			Book book= iterator.next();
			if(book.getId()==id) {
				iterator.remove();
				return book;
			}
		}
		return null;
	}

	@Override
	public Book update(Book updatedBook) {
		Iterator<Book> iterator = data.getAllBooks().iterator();
		
		while(iterator.hasNext()) {
			Book book= iterator.next();
			if(book.getId()==updatedBook.getId()) {
				book.setCategory(updatedBook.getCategory());
				book.setPrice(updatedBook.getPrice());
				return book;
			}
	}
		return null;
	}
	
	
}
