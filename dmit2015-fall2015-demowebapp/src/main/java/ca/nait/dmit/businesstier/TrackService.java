package ca.nait.dmit.businesstier;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import ca.nait.dmit.eistier.TrackDao;
import ca.nait.dmit.entity.Album;
import ca.nait.dmit.entity.Genre;
import ca.nait.dmit.entity.MediaType;
import ca.nait.dmit.entity.Track;

@Stateless
public class TrackService {

	@Inject
	private TrackDao trackDao;
	
	private List<Track> tracks;
	
	public List<Track> getTracks() {
		return tracks;
	}

	@PostConstruct
	public void retreiveAllTracks() {
		tracks = trackDao.findAll();
	}
	
	public List<Track> findTracksByAlbum(Album album) {
		return trackDao.findByAlbum(album);
	}
	
	public List<Track> findTracksByMediaType(MediaType mediaType) {
		return trackDao.findByMediaType(mediaType);
	}
	
	public List<Track> findTracksByGenre(Genre genre) {
		return trackDao.findByGenre(genre);
	}
}
