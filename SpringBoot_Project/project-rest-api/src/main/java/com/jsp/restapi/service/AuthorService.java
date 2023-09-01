package com.jsp.restapi.service;

import java.util.List;

import com.jsp.restapi.dto.AuthorDTO;
import com.jsp.restapi.dto.BookDTO;

public interface AuthorService {
	
	int addDetailsInAuthor(AuthorDTO dto);
	
	AuthorDTO findAuthorByName(String aName);
	
}
