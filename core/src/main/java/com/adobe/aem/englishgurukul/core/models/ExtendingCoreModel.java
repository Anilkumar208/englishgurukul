//package com.adobe.aem.englishgurukul.core.models;
//
//import org.apache.sling.api.resource.Resource;
//import org.apache.sling.models.annotations.Model;
//import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.adobe.cq.wcm.core.components.internal.models.v2.ImageImpl;
//import com.adobe.cq.wcm.core.components.models.Image;
//
//@Model(adaptables = Resource.class, adapters = Image.class, resourceType = "/core/wcm/components/image/v2/image")
//public class ExtendingCoreModel extends ImageImpl {
//
//	private static final Logger log = LoggerFactory.getLogger(ExtendingCoreModel.class);
//
//	@ValueMapValue
//	private String text;
//
//	@ValueMapValue
//	private String title;
//	
//	@Override
//	public String getFileReference() {
//		log.info("/n========FileReference()========");
//		return fileReference;
//	}
//	
//	public String getText() {
//		log.info("/n========Text()==============");
//		return text;
//	}
//
//	public String getTitle() {
//		log.info("/n========Title()==============");
//		return title;
//	}
//	
//}
