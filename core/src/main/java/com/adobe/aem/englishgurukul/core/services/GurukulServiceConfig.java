package com.adobe.aem.englishgurukul.core.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Gurukul Service Config", description = "Example for service Configuration")
public @interface GurukulServiceConfig {

	@AttributeDefinition(name = "Service ID", description = "Enter the name of service ID", type = AttributeType.INTEGER)
	public int serviceID();

	@AttributeDefinition(name = "Service Name", description = "Enter name of the service", type = AttributeType.STRING)
	public String serviceName() default "Gurukul Service";

	@AttributeDefinition(name = "ServiceURL", description = "Enter the URL for service", type = AttributeType.STRING)
	public String serviceURL() default "localhost";
}
