package ca.nait.dmit.eistier;

import ca.nait.dmit.entity.Genre;

public class GenreDao extends AbstractDao<Genre> {
	private static final long serialVersionUID = 1L;

	public GenreDao() {
		super(Genre.class);
	}
}
