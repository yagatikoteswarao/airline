package com.jsp.restapi.dto;

import java.util.List;

import com.jsp.restapi.entity.Author;
import com.jsp.restapi.entity.Book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class AuthorDTO {
	
	private String author_name;
	
}
