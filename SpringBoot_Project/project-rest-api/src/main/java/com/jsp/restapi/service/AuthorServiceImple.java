package com.jsp.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.restapi.dto.AuthorDTO;
import com.jsp.restapi.dto.BookDTO;
import com.jsp.restapi.entity.Author;
import com.jsp.restapi.entity.Book;
import com.jsp.restapi.repository.AuthorRepository;

@Service
public class AuthorServiceImple implements AuthorService {

	@Autowired
	private AuthorRepository arepo;
	
	@Override
	public int addDetailsInAuthor(AuthorDTO dto) {
		 Author a1 = arepo.save(Author.builder()
				 	.authorName(dto.getAuthor_name())
				 	.build());
		return a1.getAuthorId();
	}

	@Override
	public AuthorDTO findAuthorByName(String aName) {
		Author a2= arepo.findByAuthorsByName(aName);
		
		if(a2!=null)
		{
		  //TO GEt Book Entity Object
			
			//Transfer Data From Book To BookDTO
			AuthorDTO dto=AuthorDTO.builder()
					.author_name(a2.getAuthorName())
					.build();
			return dto;
		}
		else
		{
		return null;
		}
	}
	

}
