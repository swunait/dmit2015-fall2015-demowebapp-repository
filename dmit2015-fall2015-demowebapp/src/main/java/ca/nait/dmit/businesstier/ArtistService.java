package ca.nait.dmit.businesstier;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import ca.nait.dmit.eistier.ArtistDao;
import ca.nait.dmit.entity.Artist;

@Stateless
public class ArtistService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Logger logger;
	
	@Inject
	private ArtistDao artistDao;
	
	private List<Artist> artists;
	
	@PostConstruct
	public void retreiveAllArtist() {
		artists = artistDao.findAll();
		logger.infov("Retrieved {0} artits from database.", artists.size());
	}

	public List<Artist> getArtists() {
		return artists;
	}

}
