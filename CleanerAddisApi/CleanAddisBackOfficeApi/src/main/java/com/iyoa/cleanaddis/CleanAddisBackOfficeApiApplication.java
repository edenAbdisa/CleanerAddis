package com.iyoa.cleanaddis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootApplication
public class CleanAddisBackOfficeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleanAddisBackOfficeApiApplication.class, args);
		log.info("clean addis started line13");
	}

}
