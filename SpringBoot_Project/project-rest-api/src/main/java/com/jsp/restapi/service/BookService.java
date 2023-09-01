package com.jsp.restapi.service;

import java.util.List;

import com.jsp.restapi.dto.BookDTO;
import com.jsp.restapi.entity.Book;

public interface BookService {
	
	int addBook(BookDTO dto);
	BookDTO findBookById(int bid);
	List<BookDTO> getAllBooks();
	List<BookDTO> getBookDetailsBasedOnPricePages(double price ,int pages);
	BookDTO findBookByName(String bName);
	
	List<BookDTO> findBookByBookNameLetters(char c);
	
	BookDTO findBookDetailsByAuthorId(int id);

}
