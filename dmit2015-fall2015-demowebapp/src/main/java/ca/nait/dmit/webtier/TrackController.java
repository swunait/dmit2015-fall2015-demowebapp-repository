package ca.nait.dmit.webtier;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import ca.nait.dmit.businesstier.TrackService;
import ca.nait.dmit.entity.Album;
import ca.nait.dmit.entity.Genre;
import ca.nait.dmit.entity.MediaType;
import ca.nait.dmit.entity.Track;

@Model
public class TrackController {

	@Inject
	private TrackService trackService;
	
	private List<Track> tracks;
	private Album selectedAlbum;
	private MediaType selectedMediaType;
	private Genre selectedGenre;
	
	
	public MediaType getSelectedMediaType() {
		return selectedMediaType;
	}
	public void setSelectedMediaType(MediaType selectedMediaType) {
		this.selectedMediaType = selectedMediaType;
	}
	public Genre getSelectedGenre() {
		return selectedGenre;
	}
	public void setSelectedGenre(Genre selectedGenre) {
		this.selectedGenre = selectedGenre;
	}
	public Album getSelectedAlbum() {
		return selectedAlbum;
	}
	public void setSelectedAlbum(Album selectedAlbum) {
		this.selectedAlbum = selectedAlbum;
	}
	public List<Track> getTracks() {
		return tracks;
	}
	
	@PostConstruct
	public void init() {
		tracks = trackService.getTracks();
	}
	
	public String retreiveTracksByAlbum(Album album) {
		selectedAlbum = album;
		tracks = trackService.findTracksByAlbum(selectedAlbum);
		return "/pages/tracks";
	}
	
	public String retreiveTracksByMediaType(MediaType mediaType) {
		selectedMediaType = mediaType;
		tracks = trackService.findTracksByMediaType(selectedMediaType);
		return "/pages/tracks";
	}
	
	public String retreiveTracksByGenre(Genre genre) {
		selectedGenre = genre;
		tracks = trackService.findTracksByGenre(selectedGenre);
		return "/pages/tracks";
	}
	
}
