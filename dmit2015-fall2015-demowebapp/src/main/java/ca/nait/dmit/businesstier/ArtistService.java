package ca.nait.dmit.businesstier;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

import ca.nait.dmit.eistier.ArtistDao;
import ca.nait.dmit.entity.Artist;

@Path("/artist")
@Produces(MediaType.APPLICATION_JSON)
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

	@GET
	public List<Artist> getArtists() {
		return artists;
	}
	
	public Artist findArtistById(int artistId) {
		return artistDao.find(artistId);
	}

	public List<Artist> findArtistsByName(String name) {
		return artistDao.findByName(name);
	}
	
	public void update(Artist artist) {
		artistDao.edit(artist);
	}
	
	public void delete(Artist artist) throws Exception {
		try {
			artistDao.remove(artist);
		} catch ( PersistenceException pe ) {
			throw new Exception("This record is being referenced from another table and cannot be deleted..");
		} catch ( Exception ex ) {
			throw new Exception(":( Remove artist was not successful.");
		} 
	}
	
	public void add(Artist artist) {
		artistDao.persist(artist);
	}
}
