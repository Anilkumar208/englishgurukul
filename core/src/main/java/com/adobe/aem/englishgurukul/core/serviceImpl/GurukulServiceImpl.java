package com.adobe.aem.englishgurukul.core.serviceImpl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.aem.englishgurukul.core.services.GurukulServiceConfig;
import com.adobe.aem.englishgurukul.core.services.GurukulServiceInterface;

@Component(service = GurukulServiceInterface.class, immediate = true)
@Designate(ocd = GurukulServiceConfig.class)
public class GurukulServiceImpl implements GurukulServiceInterface {

	private static final Logger log = LoggerFactory.getLogger(GurukulServiceImpl.class);

	private int serviceID;

	private String serviceName;

	private String serviceURL;

	@Activate
	protected void activate(GurukulServiceConfig gurukulServiceConfig) {
		log.info("\n=========Activate() ===================");
		serviceID = gurukulServiceConfig.serviceID();
		serviceName = gurukulServiceConfig.serviceName();
		serviceURL = gurukulServiceConfig.serviceURL();
	}

	@Override
	public int serviceID() {
		return serviceID;
	}

	@Override
	public String serviceName() {
		return serviceName;
	}

	@Override
	public String serviceURL() {
		return serviceURL;
	}

}
