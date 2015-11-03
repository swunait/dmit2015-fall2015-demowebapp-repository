package ca.nait.dmit.webtier;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import ca.nait.dmit.businesstier.AlbumService;
import ca.nait.dmit.entity.Album;
import ca.nait.dmit.entity.Artist;

@Model
public class AlbumController {

	@Inject
	private AlbumService albumService;
	
	private List<Album> albums;
	private Artist selectedArtist;
	
	public List<Album> getAlbums() {
		return albums;
	}
	
	public Artist getSelectedArtist() {
		return selectedArtist;
	}

	@PostConstruct
	public void init() {
		albums = albumService.getAlbums();
	}
	
	public String retreiveAlbumsByArtist(Artist artist) {
		selectedArtist = artist;
		albums = albumService.findAlbumsByArtist(artist);
		return "/pages/albums";
	}
}
