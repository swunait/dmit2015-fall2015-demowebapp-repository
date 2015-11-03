package ca.nait.dmit.eistier;

import java.util.List;

import ca.nait.dmit.entity.Album;
import ca.nait.dmit.entity.Track;

public class TrackDao extends AbstractDao<Track> {
	private static final long serialVersionUID = 1L;

	public TrackDao() {
		super(Track.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Track> findByAlbum(Album album) {
		return getEntityManager().createQuery("from Track where album = :albumValue").setParameter("albumValue", album).getResultList();
	}
}
