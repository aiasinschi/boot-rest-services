package ro.iasinschi.playground.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtistSearchResult {

	private ArtistResponse artistmatches;

	public ArtistResponse getArtistmatches() {
		return artistmatches;
	}

	public void setArtistmatches(ArtistResponse artistmatches) {
		this.artistmatches = artistmatches;
	}
}
