package com.example.snake.and.ladder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SnakeAndLadderApplication {

	public static void main(String[] args) {

		ApplicationContext app = SpringApplication.run(SnakeAndLadderApplication.class, args);
		TestCaseController ts = app.getBean(TestCaseController.class);
		ts.testcases();
	}

}
