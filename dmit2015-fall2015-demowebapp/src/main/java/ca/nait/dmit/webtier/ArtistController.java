package ca.nait.dmit.webtier;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import ca.nait.dmit.businesstier.ArtistService;
import ca.nait.dmit.entity.Artist;
import helper.JSFHelper;

@Model
public class ArtistController {

	@Inject
	private ArtistService artistService;
	
	private List<Artist> artists;
	
	private Artist artist = new Artist();
	
	@PostConstruct
	public void init() {
		artists = artistService.getArtists();
	}
	
	public List<Artist> getArtists() {
		return artists;
	}
	
	
	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public void createArtist() {
		artistService.add(artist);
		artist = new Artist();
		JSFHelper.addInfoMessage("Successfully added new artist.");
	}
	
	
	
}
