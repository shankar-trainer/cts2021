package cts.com.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cts.com.dao.BookRepository;
import cts.com.model.Book;
import cts.com.web.BookController;

@Service
public class BookService {

	Logger logger=LoggerFactory.getLogger(BookService.class);
	

	
	@Autowired
	BookRepository repository;
	
	public List<Book> getAllBook(){
		return repository.findAll();
	}
	
	public Book saveBook(Book book) {

       logger.info("service save method");		

	 	Optional<Book> findById = repository.findById(book.getISBN());
	 	if(!findById.isPresent()) 
	 		return  repository.save(book);
	 	return null;
	}
	
	
	public Book searchBook(Book b) {
		Optional<Book> findById = repository.findById(b.getISBN());
		
		if(findById.isPresent())
			  return findById.get();
		return null;	  
	}
	
	public Book deleteBook(Book b) {
		Optional<Book> findById = repository.findById(b.getISBN());
		
		if(findById.isPresent()) {
			  repository.delete(b);
		  return b;
		}
		return null;	  
	}

	public Book updateBook(Book b) {
		Optional<Book> findById = repository.findById(b.getISBN());
		
		if(findById.isPresent()) {
			  repository.save(b);
		  return b;
		}
		return null;	  
	}

	
	
	
	
}
