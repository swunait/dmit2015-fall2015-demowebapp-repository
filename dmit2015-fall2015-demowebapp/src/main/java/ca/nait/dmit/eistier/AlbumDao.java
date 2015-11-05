package ca.nait.dmit.eistier;

import java.util.List;

import ca.nait.dmit.entity.Album;
import ca.nait.dmit.entity.Artist;

public class AlbumDao extends AbstractDao<Album> {
	private static final long serialVersionUID = 1L;

	public AlbumDao() {
		super(Album.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Album> findByArtist(Artist artist) {
		return getEntityManager()
				.createQuery("FROM Album WHERE artist = :artistValue")
				.setParameter("artistValue", "%" + artist + "%")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Album> findByTitle(String title) {
		return getEntityManager()
				.createQuery("FROM Album WHERE title LIKE = :titleValue")
				.setParameter("titleValue", "%" + title + "%")
				.getResultList();
	}
}
