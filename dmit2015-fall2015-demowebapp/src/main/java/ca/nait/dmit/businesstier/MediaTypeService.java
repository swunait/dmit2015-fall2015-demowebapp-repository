package ca.nait.dmit.businesstier;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import ca.nait.dmit.eistier.MediaTypeDao;
import ca.nait.dmit.entity.MediaType;

@Stateless
public class MediaTypeService {

	@Inject
	private MediaTypeDao mediaTypeDao;
	
	private List<MediaType> mediaTypes;

	public List<MediaType> getMediaTypes() {
		return mediaTypes;
	}
	
	@PostConstruct
	public void retreiveAllMediaTypes() {
		mediaTypes = mediaTypeDao.findAll();
	}
}
