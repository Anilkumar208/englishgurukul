package com.adobe.aem.englishgurukul.core.serviceImpl;

import java.util.Iterator;

import javax.jcr.LoginException;

import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.aem.englishgurukul.core.services.EnglishGurukulService;
import com.adobe.aem.englishgurukul.core.utils.ResolverUtil;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(service = EnglishGurukulService.class, immediate = true)
public class EnglishGurukulServiceImpl implements EnglishGurukulService {

	private static final Logger log = LoggerFactory.getLogger(EnglishGurukulServiceImpl.class);

	@Reference
	ResourceResolverFactory resourceResolverFactory;

	@Reference
	SlingRepository slingRepository;

	@Activate
	public void activate(ComponentContext componentContext) {
		log.info("\n=========== inside activate()=================");
		log.info("\n {} = {} ", componentContext.getBundleContext().getBundle().getBundleId(),
				componentContext.getBundleContext().getBundle().getSymbolicName());
	}

	@Override
	public Iterator<Page> getPages() {
		try {
			ResourceResolver resourceResolver = ResolverUtil.newResolver(resourceResolverFactory);
			PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
			Page page = pageManager.getPage("/content/englishgurukul/us/en");
			Iterator<Page> pages = page.listChildren();
			return pages;
		} catch (LoginException e) {
			log.info("\n Login Exception {} ", e.getMessage());
		} catch (Throwable e) {
			log.info("\n Throwable {} ", e.getMessage());

		}
		return null;

	}

}
