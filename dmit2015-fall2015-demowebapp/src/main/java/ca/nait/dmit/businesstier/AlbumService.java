package ca.nait.dmit.businesstier;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
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
	
	public List<Album> findAlbumsByArtistName(String artistName) {
		return albumDao.findByArtistName(artistName);
	}

	public List<Album> findAlbumsByTitle(String title) {
		return albumDao.findByTitle(title);
	}

	public Album findByAlbumId(int albumId) {
		return albumDao.find(albumId);
	}

	public void update(Album album) {
		albumDao.edit(album);
	}
	
	public void delete(Album album) throws Exception {
		try {
			albumDao.remove(album);
		} catch (PersistenceException pe) {
			throw new Exception("This record is being referenced from another table and cannot be deleted.");
		} catch(Exception e) {
			throw new Exception(":( Failed to delete this record.");
		}
	}
	
	public void add(Album album) {
		albumDao.persist(album);
	}

}
