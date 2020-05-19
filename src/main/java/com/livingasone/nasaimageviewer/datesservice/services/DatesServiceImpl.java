package com.livingasone.nasaimageviewer.datesservice.services;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class DatesServiceImpl implements DatesService {
	public static Logger logger = LogManager.getLogger(DatesService.class);
	private List<String> datesList = new ArrayList<>();
	
	@Value("${datesservice.datesfile.name}")
	private String fileName;
	
	@Value("#{'${datesservice.datesfile.acceptedformats}'.split('&')}")
	private String[] datesFormats;

	public List<String> getDatesList() {
		logger.info("getDatesList");
		return datesList;
	}

    @PostConstruct
    public void init() {
    	logger.info("DatesService init - loading dates from " + fileName);
    	
    	try  {
    		Resource resource = new ClassPathResource(fileName);
        	InputStream inputStream = resource.getInputStream();
			Scanner scanner = new Scanner(inputStream);		
			while (scanner.hasNext()) {			
				try {
					String date = scanner.nextLine();
					logger.info("Raw date from file: {}", date);	
					Date parsedDate = DateUtils.parseDateStrictly(date, datesFormats);
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					datesList.add(formatter.format(parsedDate));
				} catch (ParseException e) {
					logger.error(e.getMessage());
				}
			}
			scanner.close();
		} catch (Exception e) {
			logger.error("Error reading file {}", fileName);
			e.printStackTrace();
		}
    }
}

