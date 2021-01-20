package cts.com.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cts.com.dao.BookRepository;
import cts.com.model.Book;
import cts.com.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	Logger logger=LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	BookService service;
	
	@Autowired
	BookRepository dao;

	@GetMapping("/find/{id}")
	public Book findBook(@PathVariable("id") long id ) {
		//Book b1=new Book();
		//b1.setISBN(id);
		 return dao.findByISBN(id);
		  
		//return service.searchBook(b1);
	}
	
	
	@PostMapping("/save")
	public Book addBook(@RequestBody Book book) {
		logger.info("save starts in controller");
		return service.saveBook(book);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public Book removeBook(@PathVariable("id") long id ) {
		Book b1=new Book();
		b1.setISBN(id);
		return service.deleteBook(b1);
	}
	
	@GetMapping("/all")
	public List<Book> showAllBook(){
	return 	service.getAllBook();
	}

	@GetMapping("/search/{id}")
	public Book searchBook(@PathVariable("id") long id ) {
		Book b1=new Book();
		b1.setISBN(id);
		return service.searchBook(b1);
	}


	@PostMapping("/update")
	public Book updateBook(@RequestBody Book book) {
		return service.updateBook(book);
	}

	
}
