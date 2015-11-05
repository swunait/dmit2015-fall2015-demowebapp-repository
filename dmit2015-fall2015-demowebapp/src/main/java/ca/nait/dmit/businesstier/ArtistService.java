package ca.nait.dmit.businesstier;

//import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import ca.nait.dmit.eistier.ArtistDao;
import ca.nait.dmit.entity.Artist;

@Stateless
public class ArtistService  {
	
	@Inject
	private Logger logger;
	
	@Inject
	private ArtistDao artistDao;
	
	private List<Artist> artists;
	
	@PostConstruct
	public void retreiveAllArtist() {
		artists = artistDao.findAll();
		logger.infov("Retrieved {0} records from the database.", artists.size());
	}

	public List<Artist> getArtists() {
		return artists;
	}
	
	public Artist findArtistById(int artistId) {
		return artistDao.find(artistId);
	}

	public List<Artist> findArtistsByName(String name) {
		return artistDao.findByName(name);
	}
	
	public void UpdateArtist(Artist artist) {
		artistDao.edit(artist);
	}
	
	public void RemoveArtist(Artist artist) {
		artistDao.remove(artist);
	}
	
	public void CreateArtist(Artist artist) {
		artistDao.persist(artist);
	}
}
