package ro.iasinschi.playground.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ro.iasinschi.playground.model.*;

@Service
public class RestService {

	private final String BASE_PREFIX = "http://ws.audioscrobbler.com/2.0/?";
	private final String chart_get_top_artists = "method=chart.gettopartists&api_key=";
	private final String artist_search = "method=artist.search&api_key=";
	private final String artist_top_albums = "method=artist.gettopalbums&api_key=";
	private final String API_KEY = "d6eaec278e29a4930c7121d7061e618f";
	private final String FORMAT_JSON = "&format=json";

	public String getJsonResponse(String URL) {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
		jsonHttpMessageConverter.getObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		restTemplate.getMessageConverters().add(jsonHttpMessageConverter);

		System.out.println(URL);
		ResponseEntity<String> resultEntity = restTemplate.exchange(URL, HttpMethod.GET, new HttpEntity<String>(headers), String.class);
		return resultEntity.getBody();
	}

	public String getTopArtists(boolean useJson) {
		String URL = String.format("%s%s%s%s", BASE_PREFIX, chart_get_top_artists, API_KEY, useJson ? FORMAT_JSON : "");
		return getJsonResponse(URL);
	}

	public String getArtist(String artistName, boolean useJson) {
		String URL = String.format("%s%s%s&artist=%s%s", BASE_PREFIX, artist_search, API_KEY, artistName, useJson ? FORMAT_JSON : "");
		return getJsonResponse(URL);
	}

	public String getArtistsAlbums(String artistName, boolean useJson) {
		String URL = String.format("%s%s%s&artist=%s%s", BASE_PREFIX, artist_top_albums, API_KEY, artistName, useJson ? FORMAT_JSON : "");
		return getJsonResponse(URL);
	}

	public ArtistListResponse getTopArtistsList() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
		try {
			return mapper.readValue(getTopArtists(true), ArtistListResponse.class);
		} catch (JsonProcessingException ex) {
			return null;
		}
	}

	public ArtistSearchResponse getArtist(String artistName) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(getArtist(artistName, true), ArtistSearchResponse.class);
		} catch (JsonProcessingException ex) {
			return null;
		}
	}

	public AlbumListResponse getArtistsAlbums(String artistName) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(getArtistsAlbums(artistName, true), AlbumListResponse.class);
		} catch (JsonProcessingException ex) {
			return null;
		}
	}
}
