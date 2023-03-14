package com.adobe.aem.englishgurukul.core.schedulers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.jcr.LoginException;

import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.commons.scheduler.Job;
import org.apache.sling.commons.scheduler.JobContext;
import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.aem.englishgurukul.core.services.SchedulerServiceConfig;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(service = Job.class, immediate = true)
@Designate(ocd = SchedulerServiceConfig.class)
public class GurukulJobScheduler implements Job {

	private static final Logger log = LoggerFactory.getLogger(GurukulJobScheduler.class);

	private int SchedulerJobId;

	@Reference
	Scheduler scheduler;

	@Reference
	ResourceResolver resourceResolver;

	public Iterator<Page> getPages() throws LoginException {
		log.info("/n=========== Iterate pages=================");
		PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
		Page page = pageManager.getPage("/content/aemgeeks/us/en");
		Iterator<Page> pages = page.listChildren();
		log.info(null, getPages().hasNext());
		return pages;
	}

	@Activate
	public void activate(SchedulerServiceConfig config) {
		addSchedulerJob(config);
		SchedulerJobId = config.SchedulerName().hashCode();

	}

	@Deactivate
	public void deactivate(SchedulerServiceConfig config) {
		removeSchedulerJob();
	}

	private void removeSchedulerJob() {
		scheduler.unschedule(String.valueOf(SchedulerJobId));
	}

	private void addSchedulerJob(SchedulerServiceConfig config) {
		ScheduleOptions in = scheduler.EXPR("0 03 17 1/1 * ? *");
		Map<String, Serializable> inMap = new HashMap<>();
		inMap.put("country", "IN");
		inMap.put("url", "www.in.com");
		in.config(inMap);

		scheduler.schedule(this, in);
		ScheduleOptions de = scheduler.EXPR("0 04 17 1/1 * ? *");
		Map<String, Serializable> deMap = new HashMap<>();
		deMap.put("country", "DE");
		deMap.put("url", "www.de.com");
		de.config(deMap);
		scheduler.schedule(this, de);

		ScheduleOptions us = scheduler.EXPR("0 05 17 1/1 * ? *");
		Map<String, Serializable> usMap = new HashMap<>();
		usMap.put("country", "US");
		usMap.put("url", "www.us.com");
		us.config(usMap);
		scheduler.schedule(this, us);
	}

	@Override
	public void execute(JobContext jobContext) {
		log.info("\n =======> COUNTRY {} : URL {} ", jobContext.getConfiguration().get("country"),
				jobContext.getConfiguration().get("url"));

	}

}
