package ca.nait.dmit.webtier;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import ca.nait.dmit.businesstier.ArtistService;
import ca.nait.dmit.entity.Artist;

@Model
public class ArtistController {

	@Inject
	private ArtistService artistService;
	
	private List<Artist> artists;
	
	@PostConstruct
	public void init() {
		artists = artistService.getArtists();
	}
	
	public List<Artist> getArtists() {
		return artists;
	}
}
