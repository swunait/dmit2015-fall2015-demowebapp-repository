package ca.nait.dmit.webtier;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import ca.nait.dmit.businesstier.TrackService;
import ca.nait.dmit.entity.Album;
import ca.nait.dmit.entity.Track;

@Model
public class TrackController {

	@Inject
	private TrackService trackService;
	
	private List<Track> tracks;
	private Album selectedAlbum;
	
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
		tracks = trackService.findTracksByAlbum(album);
		return "/pages/tracks";
	}
	
}
