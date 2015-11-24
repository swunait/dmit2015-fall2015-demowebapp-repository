package ca.nait.dmit.webtier;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import ca.nait.dmit.businesstier.ArtistService;
import ca.nait.dmit.entity.Artist;

@WebService(serviceName="ArtistWebService")
public class ArtistWebService {

	@Inject
	private ArtistService artistService;
	
	@WebMethod
	@WebResult(name="listArtists")
	public List<Artist> getArtists() {
		return artistService.getArtists();
	}
	
}
