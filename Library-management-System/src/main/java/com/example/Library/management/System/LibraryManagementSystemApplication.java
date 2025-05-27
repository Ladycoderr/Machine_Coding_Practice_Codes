package com.example.Library.management.System;

import com.example.Library.management.System.Controller.TestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LibraryManagementSystemApplication {

	public static void main(String[] args) {

		ApplicationContext app = SpringApplication.run(LibraryManagementSystemApplication.class, args);
		TestController ts = app.getBean(TestController.class);
		ts.Testcases();
	}

}
