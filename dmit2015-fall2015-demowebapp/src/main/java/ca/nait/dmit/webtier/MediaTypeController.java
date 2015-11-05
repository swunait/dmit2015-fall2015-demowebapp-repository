package ca.nait.dmit.webtier;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import ca.nait.dmit.businesstier.MediaTypeService;
import ca.nait.dmit.entity.MediaType;

@Model
public class MediaTypeController {

	@Inject
	private MediaTypeService mediaTypeService;
	
	private List<MediaType> mediaTypes;

	public List<MediaType> getMediaTypes() {
		return mediaTypes;
	}
	
	@PostConstruct
	public void init() {
		mediaTypes = mediaTypeService.getMediaTypes();
	}
}
