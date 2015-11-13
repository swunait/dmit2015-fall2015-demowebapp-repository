package ca.nait.dmit.webtier;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import ca.nait.dmit.businesstier.AlbumService;
import ca.nait.dmit.businesstier.ArtistService;
import ca.nait.dmit.entity.Album;
import ca.nait.dmit.entity.Artist;
import helper.JSFHelper;

@Model
public class AlbumController {

	@Inject
	private AlbumService albumService;
	
	@Inject
	private ArtistService artistService;
	
	private List<Album> albums;
	private Artist selectedArtist;
	private Album album = new Album();
	private int artistId;
	
	public List<Album> getAlbums() {
		return albums;
	}
	
	public Artist getSelectedArtist() {
		return selectedArtist;
	}
	
	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
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
	
	public void createAlbum() {
		Artist artist = artistService.findArtistById(artistId);
		if( artist != null ) {
			album.setArtist(artist);
			albumService.add(album);
			album = new Album();
			JSFHelper.addInfoMessage("Successfully added new album.");			
		} else {
			JSFHelper.addErrorMessage("The artist you entered is not a valid Artist.");
		}
			
	}
}
