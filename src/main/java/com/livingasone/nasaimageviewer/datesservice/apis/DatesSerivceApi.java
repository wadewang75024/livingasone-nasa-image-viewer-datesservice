package com.livingasone.nasaimageviewer.datesservice.apis;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livingasone.nasaimageviewer.datesservice.DatesServiceApplication;
import com.livingasone.nasaimageviewer.datesservice.services.DatesService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class DatesSerivceApi {
	public static Logger logger = LogManager.getLogger(DatesSerivceApi.class);
	
	@Autowired
	private DatesService service;
	
	@GetMapping("/dates")
	public List<String> getImagesDates() {
		logger.info("getImagesDates...");
		return service.getDatesList();
	}
	
}
