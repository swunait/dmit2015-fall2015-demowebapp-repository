package ca.nait.dmit.eistier;

import javax.ejb.Stateless;

import ca.nait.dmit.entity.Artist;

@Stateless
public class ArtistDao extends AbstractDao<Artist> {
	private static final long serialVersionUID = 1L;

	public ArtistDao() {
		super(Artist.class);
	}

}
