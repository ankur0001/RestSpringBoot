package com.spring.controller;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.bean.Book;
import com.spring.exception.BookNotFoundException;
import com.spring.service.BookService;


@RequestMapping("/v1" )
@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookService.getAllBook();
	}
	
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable int id) {
		Book book = bookService.getBookById(id);
		
		if(book == null) {
			throw new BookNotFoundException("id- "+ id);
		}
		return book;
	}
	
	@PostMapping("/books")
	public void addBook(@Valid @RequestBody Book book) {
		bookService.save(book);
	}
	
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable int id) {
		Book book = bookService.deleteBookById(id);
		
		if(book == null) {
			throw new BookNotFoundException("id- "+ id);
		}
	}
	
	@PutMapping("/books")
	public Book updateBook(@Valid @RequestBody Book book) {
		Book updatedBook = bookService.update(book);
		if(updatedBook == null) {
			throw new BookNotFoundException("id- "+ book.getId());
		}
		return updatedBook;
	}
}
