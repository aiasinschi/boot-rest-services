package ro.iasinschi.playground.controller;

import java.util.*;

import org.springframework.web.bind.annotation.*;
import ro.iasinschi.playground.model.*;
import ro.iasinschi.playground.service.RestService;

@RestController
@RequestMapping(value="/rest")
public class BasicRestController {

	private RestService restService;

	public BasicRestController(RestService restService) {
		this.restService = restService;
	}

	@GetMapping("/basic")
	public List<String> getBasicStringList() {
		return new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
	}

	@GetMapping("/topArtists")
	public List<Artist> getTopArtists() {
		return restService.getTopArtistsList().getArtists().getArtist();
	}

	@GetMapping("/artist")
	public List<Artist> getArtists(@RequestParam("name") String name) {
		return restService.getArtist(name).getResults().getArtistmatches().getArtist();
	}

	@GetMapping("/albums")
	public List<Album> getAlbums(@RequestParam("name") String name) {
		return restService.getArtistsAlbums(name).getTopalbums().getAlbum();
	}
}
