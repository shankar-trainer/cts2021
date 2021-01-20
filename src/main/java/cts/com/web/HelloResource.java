package cts.com.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello/rest")
@RestController
public class HelloResource {

	 @Value("${welcome.message}")
	private String msg;
	
	 @GetMapping
	 public String disp() {
		 return msg;
	 }

}
