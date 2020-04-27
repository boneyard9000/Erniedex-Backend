package com.erniedexapplication.erniedexapplication;

import com.erniedexapplication.erniedexapplication.Controllers.ItemController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class ErniedexApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErniedexApplication.class, args);

	}

}
