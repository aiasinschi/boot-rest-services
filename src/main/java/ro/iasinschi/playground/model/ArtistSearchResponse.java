package ro.iasinschi.playground.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtistSearchResponse {

	private ArtistSearchResult results;

	public ArtistSearchResult getResults() {
		return results;
	}

	public void setResults(ArtistSearchResult results) {
		this.results = results;
	}
}
