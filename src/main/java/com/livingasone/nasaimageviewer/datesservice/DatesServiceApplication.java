package com.livingasone.nasaimageviewer.datesservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class DatesServiceApplication {
	public static Logger logger = LogManager.getLogger(DatesServiceApplication.class);
	public static void main(String[] args) {
	    logger.info("DatesServiceApplication main starts...");
	    SpringApplication.run(DatesServiceApplication.class, args);
	}
}
