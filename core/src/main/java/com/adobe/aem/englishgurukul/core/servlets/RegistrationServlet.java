 package com.adobe.aem.englishgurukul.core.servlets;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service=Servlet.class,property = { "sling.servlet.resourceTypes=" + "/content/bright/us/en/news-room",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET })
public class RegistrationServlet {

			private static final Logger LOG = LoggerFactory.getLogger(RegistrationServlet.class);
			
			protected void doGet(SlingHttpServletRequest slingHttpServletRequest,
					SlingHttpServletResponse slingHttpServletResponse) {}
			

		
}
