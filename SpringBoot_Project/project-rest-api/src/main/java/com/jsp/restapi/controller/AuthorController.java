package com.jsp.restapi.controller;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.restapi.dto.AuthorDTO;
import com.jsp.restapi.dto.BookDTO;
import com.jsp.restapi.service.AuthorService;

@RestController  //To Make Use Rest API
@RequestMapping("/api/v2") // To Provide Unique Path For Book Controller
public class AuthorController {
	
	@Autowired
	private AuthorService service;
	
	@PostMapping("/author")
	public ResponseEntity<String>  addDetailsInAuthor(@RequestBody AuthorDTO dto)
	{
		int addAuthor = service.addDetailsInAuthor(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body("Id is"+addAuthor);
	}
	
	@GetMapping("/author/byname/{aname}")
	public ResponseEntity<String> fetchauthorDetails(@PathVariable("aname") String aNamme)
	{
		AuthorDTO findAuthorByName=service.findAuthorByName(aNamme);
		return ResponseEntity.status(HttpStatus.FOUND).body("It is Retrived"+findAuthorByName);
	}
	
}
