package com.project.terminal.crudterminal;
import com.project.terminal.crudterminal.controller.AppController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;

@SpringBootApplication
public class CrudTerminalApplication {



	public static void main(String[] args) throws ParseException {
		SpringApplication.run(CrudTerminalApplication.class, args);
		AppController.showProses();
	}






}
