package ro.iasinschi.playground.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtistListResponse {

	private ArtistResponse artists;

	public ArtistListResponse() {
	}

	public ArtistResponse getArtists() {
		return artists;
	}

	public void setArtists(ArtistResponse artists) {
		this.artists = artists;
	}
}
