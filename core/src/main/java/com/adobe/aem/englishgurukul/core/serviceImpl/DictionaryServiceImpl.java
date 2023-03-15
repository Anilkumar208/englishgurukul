package com.adobe.aem.englishgurukul.core.serviceImpl;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.adobe.aem.englishgurukul.core.services.DictionaryService;

@Component(service = DictionaryService.class, immediate = true)
public class implements DictionaryService {
	
	private static final Logger log = LoggerFactory.getLogger(DictionaryServiceImpl.class);

	@Override
	public String getMeaningOfWord(String word) {
		try {
			log.info("/n============try() executed==========");
			String apiEndPoint = "https://api.dictionaryapi.dev/api/v2/entries/en/";
			URIBuilder builder = new URIBuilder(
					apiEndPoint + URLEncoder.encode(word, StandardCharsets.UTF_8.toString()));

			HttpGet get = new HttpGet(builder.build());

			CloseableHttpClient httpclient = HttpClients.createDefault();

			CloseableHttpResponse response = httpclient.execute(get);

			String rawResult = "";

			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				System.out.printf("Bad response status code:%d%n", response.getStatusLine().getStatusCode());
				return word;
			}
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				rawResult = EntityUtils.toString(entity, Charset.forName("utf-8"));
			}
			return word;
		} catch (Exception e) {
          log.info("/n ======================catch() executed========================");
		}
		return "";
	}
	
	public String getDefinition() {
		return getMeaningOfWord(getDefinition());
	}

}
