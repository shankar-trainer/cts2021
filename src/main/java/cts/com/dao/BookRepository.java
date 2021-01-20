package cts.com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cts.com.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
	
	public Book findByISBN(long ISBN);
	//public List<Book> findAll();
	
	//public Book findByISBN_And_bName(long ISBN,String bName);
		
}
