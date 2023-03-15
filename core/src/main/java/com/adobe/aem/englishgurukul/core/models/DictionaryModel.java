package com.adobe.aem.englishgurukul.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.aem.englishgurukul.core.services.DictionaryService;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DictionaryModel {

	@ OSGiService
	DictionaryService dictionaryService;
	
	@ValueMapValue
	private String word;
	
	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public String getWord() {
		return word;
	}

	public String getMeaning() {
		return dictionaryService.getMeaningOfWord(word);
	}
}
