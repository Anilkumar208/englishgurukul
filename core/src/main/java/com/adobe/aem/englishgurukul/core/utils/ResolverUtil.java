package com.adobe.aem.englishgurukul.core.utils;

import java.util.HashMap;
import java.util.Map;
import javax.jcr.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;

public class ResolverUtil {

	private ResolverUtil() {
		
}
	public static final String ENGLISH_GURUKUL ="englishgurukul";
	
	  public static ResourceResolver newResolver( ResourceResolverFactory resourceResolverFactory ) throws LoginException, Throwable {
	        final Map<String, Object> paramMap = new HashMap<String, Object>();
	        paramMap.put( ResourceResolverFactory.SUBSERVICE,ENGLISH_GURUKUL);
	        ResourceResolver resolver = resourceResolverFactory.getServiceResourceResolver(paramMap);
	        return resolver;
	    }
		
	}
	

