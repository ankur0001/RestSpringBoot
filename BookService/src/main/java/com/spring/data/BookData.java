package com.spring.data;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.spring.bean.Book;
@Component
public class BookData {
	private ArrayList<Book> allBooks= new ArrayList<Book>();
	
	public ArrayList<Book> getAllBooks() {
		return allBooks;
	}

	BookData(){
		allBooks.add(new Book(1,"Java",100));
		allBooks.add(new Book(2,".net",80));
		allBooks.add(new Book(3,"hadoop",120));
		allBooks.add(new Book(4,"DS",130));
		allBooks.add(new Book(5,"Spring",140));
	}

}
