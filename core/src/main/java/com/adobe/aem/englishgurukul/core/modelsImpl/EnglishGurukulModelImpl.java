package com.adobe.aem.englishgurukul.core.modelsImpl;

import java.util.Iterator;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.aem.englishgurukul.core.models.EnglishGurukulModel;
import com.adobe.aem.englishgurukul.core.services.EnglishGurukulService;
import com.day.cq.wcm.api.Page;

@Model(adaptables = SlingHttpServletRequest.class, adapters = EnglishGurukulModel.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class EnglishGurukulModelImpl implements EnglishGurukulModel {

	private static final Logger log = LoggerFactory.getLogger(EnglishGurukulModelImpl.class);

	@OSGiService
	EnglishGurukulService englishGurukulService;

	@Override
	public Iterator<Page> getPagesList() {
		log.info("\n========== PagesList() ==========");
		return englishGurukulService.getPages();
	}

	
}
