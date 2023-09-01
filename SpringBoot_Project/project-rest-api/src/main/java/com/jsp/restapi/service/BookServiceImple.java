package com.jsp.restapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.restapi.dto.BookDTO;
import com.jsp.restapi.entity.Book;
import com.jsp.restapi.repository.BookRepository;

@Service
public class BookServiceImple  implements BookService{
	@Autowired
	private BookRepository repository;
	
	@Override
	public int addBook(BookDTO dto) {
		  Book b1=repository.save(Book.builder()
				  .bookName(dto.getBookName())
				  .bookPrice(dto.getBookPrice())
				  .bookPages(dto.getBookPages())
				  .build());
		return b1.getBookId();
	}

	@Override
	public BookDTO findBookById(int bid) {
		Optional<Book> bookObject = repository.findById(bid);
		if(bookObject.isPresent())
		{
			Book b1 = bookObject.get();  //TO GEt Book Entity Object
			
			//Transfer Data From Book To BookDTO
			BookDTO dto=BookDTO.builder()
					.bookName(b1.getBookName())
					.bookPrice(b1.getBookPrice())
					.bookPages(b1.getBookPages())
					.build();
			
			return dto;
		}
		else
		{
		return null;
		}
	}

	@Override
	public List<BookDTO> getAllBooks() {
		
		List<Book> books= repository.findAll();
		
		if(books.size()>0)
		{
			//Transfer List Of Book To List Of BookDTO
			List<BookDTO> dto = books.stream().map(t -> BookDTO.builder()
					.bookName(t.getBookName()).bookPrice(t.getBookPrice()).bookPages(t.getBookPages())
					.build())
					.collect(Collectors.toList());
			return dto;
		}
		else
		{
			return null;
		}
		}

	@Override
	public List<BookDTO> getBookDetailsBasedOnPricePages(double price, int pages) {
		List<Book> booksFromDb = repository.findByPriceAndPages(price, pages);
		
		if(booksFromDb.isEmpty())
			{
				return null;
			}
		else
		{
			//Transfer Book Data From Entity To Dto
			
			List<BookDTO> dto = booksFromDb.stream()
									.map(x-> BookDTO.builder().bookName(x.getBookName()).bookPrice(x.getBookPrice())
									.bookPages(x.getBookPages()).build())
					       			.collect(Collectors.toList());
			return dto;
		}
	}
	
	@Override
	public BookDTO findBookByName(String bName) {
			
			Book book1= repository.findByBookName(bName);
			
			if(book1!=null)
			{
				
				//Transfer Data From Book To BookDTO
				BookDTO dto=BookDTO.builder()
						.bookName(book1.getBookName())
						.bookPrice(book1.getBookPrice())
						.bookPages(book1.getBookPages())
						.build();
				
				return dto;
			}
			
			else
			{
			return null;
			}
			
		}

	@Override
	public	List<BookDTO> findBookByBookNameLetters(char c) {
		 
		List<Book> book2 = repository.findByBookNameLetters(c);
		
		if(book2!=null)
		{
			//Transfer Data From Book To BookDTO
			List<BookDTO> dto = book2.stream().map(t1 -> BookDTO.builder()
					.bookName(t1.getBookName()).bookPrice(t1.getBookPrice()).bookPages(t1.getBookPages())
					.build())
					.collect(Collectors.toList());
			return dto;
		}
		else
		{
			return null;
		}
	}

	@Override
	public BookDTO findBookDetailsByAuthorId(int id) {
		
		Optional<Book> bookObject = repository.findByBookDetailsByAuthorId(id);
		if(bookObject.isPresent())
		{
			Book b1 = bookObject.get();  //TO GEt Book Entity Object
			//Transfer Data From Book To BookDTO
			BookDTO dto=BookDTO.builder()
					.bookName(b1.getBookName())
					.bookPrice(b1.getBookPrice())
					.bookPages(b1.getBookPages())
					.build();
			return dto;
		}
		else
		{
		return null;
		}
	}
	
}
