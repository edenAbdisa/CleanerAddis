package com.iyoa.cleanaddis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.extern.slf4j.Slf4j;
//@Slf4j
@SpringBootApplication
@EnableJpaRepositories("com.iyoa")
public class CleanAddisBackOfficeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleanAddisBackOfficeApiApplication.class, args);
		//log.info("clean addis started line13");
	}

}
