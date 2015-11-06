package ca.nait.dmit.webtier;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.constraints.NotBlank;

import ca.nait.dmit.businesstier.AlbumService;
import ca.nait.dmit.entity.Album;
import helper.JSFHelper;

@Named
@ViewScoped
public class AlbumQueryController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private AlbumService albumService;
	
	@NotBlank(message="Search value is required.")
	private String searchValue;
	
	private List<Album> searchResults;
	
	private Album searchSingleResult;

	private int searchResultCount = 0;
	
	public int getSearchResultCount() {
		return searchResultCount;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	
	public List<Album> getSearchResults() {
		return searchResults;
	}

	public Album getSearchSingleResult() {
		return searchSingleResult;
	}

	public void doSearch() {
		// search by albumId
		try {
			int albumId = Integer.parseInt( searchValue );
			searchSingleResult = albumService.findByAlbumId(albumId);
			searchResultCount = 1;
		} catch( NumberFormatException e ) {
			searchSingleResult = null;
			searchResultCount = 0;
		}

		if( searchResultCount == 0 )	 
		{	
			// search by album title
			searchResults =  albumService.findAlbumsByTitle(searchValue);
			searchResultCount = searchResults.size();
			if( searchResults.size() == 1 )
			{
				searchSingleResult = searchResults.get(0);
				searchResults = null;
			}
		}
		
		if( searchResultCount == 0 )	 
		{	
			// search by artist name
			searchResults =  albumService.findAlbumsByArtistName(searchValue);
			searchResultCount = searchResults.size();
			if( searchResults.size() == 1 )
			{
				searchSingleResult = searchResults.get(0);
				searchResults = null;
			}
		}
				
		if( searchResultCount == 1 )
		{
			JSFHelper.addInfoMessage("Successfully found the following record.");
		}
		else if( searchResultCount > 1 )
		{
			JSFHelper.addInfoMessage("Successfully found " + searchResultCount + " records.");
			searchSingleResult = null;
		}
		else
		{
			JSFHelper.addErrorMessage("There are no records in the system matching that criteria.");
		}
	}
	
	public void cancelEdit() {
		searchResultCount = 0;
		searchSingleResult = null;
		searchResults = null;
	}
	
	public void edit(Album selectedAlbum) {
		searchSingleResult = selectedAlbum;
	}
	
	public void updateAlbum() {
		JSFHelper.addInfoMessage("The update feature will be be inmplemented at a later date.");
	}
	
	public void deleteAlbum() {
		JSFHelper.addInfoMessage("The delete feature will be be inmplemented at a later date.");
	}
}
