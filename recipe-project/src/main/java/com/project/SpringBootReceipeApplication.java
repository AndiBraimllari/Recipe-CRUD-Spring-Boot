package com.project;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootReceipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReceipeApplication.class, args);
	}
}
//netstat -ano | findstr :PORTNUMBER         taskkill /PID IDTOKILL /F