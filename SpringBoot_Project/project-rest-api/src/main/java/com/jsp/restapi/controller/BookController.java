package com.jsp.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.restapi.dto.BookDTO;
import com.jsp.restapi.entity.Book;
import com.jsp.restapi.service.BookService;

@RestController  //To Make Use Rest API
@RequestMapping("/api/v1") // To Provide Unique Path For Book Controller
public class BookController {
	
	@Autowired
	private BookService service;
	//Create an api To Add Details in db
	//To Take Input From Position In The Form Of Java Object
	@PostMapping("/books")
	public int addBook(@RequestBody BookDTO dto)
	{
		int addBook = service.addBook(dto);
		return addBook;
	}
	
	//Create An Api To Get Book Details From Db By Id
	@GetMapping("/books/{bid}")
	public BookDTO findBook( @PathVariable("bid") int id)
	{
		BookDTO findBookById = service.findBookById(id);
		return findBookById;  
	}
	
	//Create An APi To Get All Book Details
	@GetMapping("/books")
	public List<BookDTO> getAllBooks()
	{
		return service.getAllBooks();	
	}
	
	@GetMapping("/books/{price}/{pages}")
	public List<BookDTO> getBookByPricesAndPages(@PathVariable("pages") int bookPages,
								@PathVariable("price") double bookPrice)
	{
		return service.getBookDetailsBasedOnPricePages(bookPrice, bookPages);
	}
	
	@GetMapping("/books/byname/{bname}")
	public  BookDTO findBookByName(@PathVariable("bname") String bName)
	{
		
		BookDTO findBookByName=service.findBookByName(bName);
		return findBookByName;
		
	}
	
	@GetMapping("/books/byletter/{letter}")
	public ResponseEntity<String>  getBookByBookNameLetters(@PathVariable("letter")char c)
	{
		if(service.findBookByBookNameLetters(c)==null)
		{ 
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("It is Not Retrived"+null);
		
		}
		else
		{	
			return ResponseEntity.status(HttpStatus.FOUND).body("It is Retrived"+service.findBookByBookNameLetters(c));
		}	
	}
	
	@GetMapping("/books/byauthorid/{aid}")
	public BookDTO getBookDetailsByAuthorId(@PathVariable("aid") int id)
	{
//		if(service.findBookDetailsByAuthorId(id)!=null);
//		{
//			return ResponseEntity.status(HttpStatus.FOUND).body("It is Retrived"+service.findBookDetailsByAuthorId(id));
//		}
//		else
//		{
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//		}
		return service.findBookDetailsByAuthorId(id);
	}
}

















