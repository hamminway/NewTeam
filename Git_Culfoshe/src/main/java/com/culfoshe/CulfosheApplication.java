package com.culfoshe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class CulfosheApplication {

	public static void main(String[] args) {
		SpringApplication.run(CulfosheApplication.class, args);
	}

}
