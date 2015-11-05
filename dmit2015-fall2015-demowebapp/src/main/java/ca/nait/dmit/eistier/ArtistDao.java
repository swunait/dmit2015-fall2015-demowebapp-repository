package ca.nait.dmit.eistier;

import java.util.List;

import ca.nait.dmit.entity.Artist;

public class ArtistDao extends AbstractDao<Artist> {
	private static final long serialVersionUID = 1L;

	public ArtistDao() {
		super(Artist.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Artist> findByName(String name) {
		return getEntityManager().createQuery("FROM Artist WHERE name LIKE :nameValue ").setParameter("nameValue", "%" + name + "%").getResultList();
	}

}
