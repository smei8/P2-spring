package com.ers.expensesys2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ExpenseSys2Application {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseSys2Application.class, args);
	}

}
