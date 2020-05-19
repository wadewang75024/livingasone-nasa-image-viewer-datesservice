package com.livingasone.nasaimageviewer.datesservice;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.livingasone.nasaimageviewer.datesservice.services.DatesService;
import com.livingasone.nasaimageviewer.datesservice.services.DatesServiceImpl;

@RunWith(SpringRunner.class)
@ContextConfiguration(
		  initializers = PropertyOverrideContextInitializer.class,
		  classes = DatesServiceApplication.class)
public class DatesServiceServiceLayerTest {
	
	 @TestConfiguration
	 static class CustomerServiceImplTestContextConfiguration {
	  
	        @Bean
	        public DatesService customerService() {
	            return new DatesServiceImpl();
	        }
	 }
	 
	 @Autowired
	 private DatesService datesService;
	 
	 List<String> dateList;
	 
	 @Before
	 public void setUp() {
		 dateList = Arrays.asList("2017-02-27","2018-06-02","2016-07-13");  
	 }
	 
	 @Test
	 public void testGetDates() throws Exception {
	     assertEquals(dateList, datesService.getDatesList());
	 }

}
