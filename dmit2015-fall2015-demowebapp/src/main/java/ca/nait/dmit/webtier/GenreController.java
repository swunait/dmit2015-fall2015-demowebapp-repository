package ca.nait.dmit.webtier;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import ca.nait.dmit.businesstier.GenreService;
import ca.nait.dmit.entity.Genre;

@Model
public class GenreController {

	@Inject
	private GenreService genreService;
	
	private List<Genre> genres;

	public List<Genre> getGenres() {
		return genres;
	}
	
	@PostConstruct
	public void init() {
		genres = genreService.getGenres();
	}
}
