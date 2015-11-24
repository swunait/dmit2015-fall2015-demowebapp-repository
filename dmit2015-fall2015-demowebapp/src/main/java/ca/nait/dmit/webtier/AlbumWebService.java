package ca.nait.dmit.webtier;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import ca.nait.dmit.businesstier.AlbumService;
import ca.nait.dmit.entity.Album;

@WebService(serviceName="AlbumWebService")
public class AlbumWebService {
	
	@Inject
	private AlbumService albumService;
	
	@WebMethod
	@WebResult(name="listAlbums")
	public List<Album> getAlbums() {
		return albumService.getAlbums();
	}

}
