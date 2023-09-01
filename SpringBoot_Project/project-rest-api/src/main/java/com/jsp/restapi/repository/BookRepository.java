package com.jsp.restapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.restapi.entity.Book;

public interface BookRepository  extends JpaRepository<Book, Integer>{
	
	@Query("SELECT b1 FROM Book b1 WHERE b1.bookPrice<= :bookPrice AND b1.bookPages >= :bookPages")
	List<Book> findByPriceAndPages(@Param("bookPrice") double price,@Param("bookPages") int pages);
	
	@Query("SELECT b1 FROM Book b1 WHERE b1.bookName= :bookName")
	public Book findByBookName(@Param("bookName")String bName);
	
	@Query("SELECT b1 FROM Book b1 WHERE b1.bookName LIKE %:character%")
	public List<Book>	findByBookNameLetters(@Param("character") char c);
	
	@Query("SELECT b1 FROM Book b1 ,Author a1 WHERE b1.bookId=a1.authorId AND b1.bookId=:bid")
	public Optional<Book> findByBookDetailsByAuthorId(@Param("bid")int id);
	
} 
