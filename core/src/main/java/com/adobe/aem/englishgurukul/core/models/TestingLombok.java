package com.adobe.aem.englishgurukul.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import lombok.*;

@Getter
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TestingLombok {

	@ValueMapValue
	private String title;

	@ValueMapValue
	private String description;

	@ValueMapValue
	private String fileReference;

}
