package ro.iasinschi.playground.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AlbumListResponse {

	private AlbumResponse topalbums;

	public AlbumResponse getTopalbums() {
		return topalbums;
	}

	public void setTopalbums(AlbumResponse topalbums) {
		this.topalbums = topalbums;
	}
}
