package com.livingasone.nasaimageviewer.datesservice;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.support.TestPropertySourceUtils;

public class PropertyOverrideContextInitializer
implements ApplicationContextInitializer<ConfigurableApplicationContext> {

  static final String PROPERTY_FIRST_VALUE = "imageDates.txt";
  static final String PROPERTY_SECOND_VALUE = "MM/dd/yy&MMM d, yyyy&MMM-d-yyyy";

  @Override
  public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
      TestPropertySourceUtils.addInlinedPropertiesToEnvironment(
        configurableApplicationContext, "datesservice.datesfile.name=" + PROPERTY_FIRST_VALUE);
      TestPropertySourceUtils.addInlinedPropertiesToEnvironment(
	          configurableApplicationContext, "datesservice.datesfile.acceptedformats=" + PROPERTY_SECOND_VALUE);

      TestPropertySourceUtils.addPropertiesFilesToEnvironment(
        configurableApplicationContext, "context-override-application.properties");
  }
}

