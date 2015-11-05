package ca.nait.dmit.businesstier;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import ca.nait.dmit.eistier.GenreDao;
import ca.nait.dmit.entity.Genre;

@Stateless
public class GenreService {

	@Inject
	private GenreDao genreDao;
	
	private List<Genre> genres;

	public List<Genre> getGenres() {
		return genres;
	}
	
	@PostConstruct
	public void retreiveAllGenres() {
		genres = genreDao.findAll();
	}
}
