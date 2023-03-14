package com.adobe.aem.englishgurukul.core.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "English-gurukulScheduler", description = "Sling Scheduler Configuration")
public @interface SchedulerServiceConfig {

	@AttributeDefinition(
			name="Scheduler name",
			description="Name of the Scheduler",
			type=AttributeType.STRING)
	public String SchedulerName() default "custom Sling Scheduler";
	
	@AttributeDefinition(
			name="Cron Expression",
			description="Cron expression for Scheduler",
			type= AttributeType.STRING)
	public String cronExpress() default "0/20 * * * * ?";
	
	
}
