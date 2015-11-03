package ca.nait.dmit.businesstier;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import ca.nait.dmit.eistier.AlbumDao;
import ca.nait.dmit.entity.Album;
import ca.nait.dmit.entity.Artist;

@Stateless
public class AlbumService {
	
	@Inject
	private AlbumDao albumDao;

	private List<Album> albums;
	
	public List<Album> getAlbums() {
		return albums;
	}

	@PostConstruct
	public void retreiveAllAlbums() {
		albums = albumDao.findAll();
	}
	
	public List<Album> findAlbumsByArtist(Artist artist) {
		return albumDao.findByArtist(artist);
	}
}
