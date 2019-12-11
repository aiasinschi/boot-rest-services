package ro.iasinschi.playground.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Artist {

	private String name;

	private Long listeners;

	private String mbid;

	private String url;

	private int streamable;

	public Artist() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getListeners() {
		return listeners;
	}

	public void setListeners(Long listeners) {
		this.listeners = listeners;
	}

	public String getMbid() {
		return mbid;
	}

	public void setMbid(String mbid) {
		this.mbid = mbid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getStreamable() {
		return streamable;
	}

	public void setStreamable(int streamable) {
		this.streamable = streamable;
	}
}
