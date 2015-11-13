package ca.nait.dmit.webtier;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.constraints.NotBlank;

import ca.nait.dmit.businesstier.ArtistService;
import ca.nait.dmit.entity.Artist;
import helper.JSFHelper;

@Named
@ViewScoped
public class ArtistQueryController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private ArtistService artistService;
	
	@NotBlank(message="Search value is required.")
	private String searchValue;
	
	private List<Artist> searchResults;
	
	private Artist searchSingleResult;

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
	
	public List<Artist> getSearchResults() {
		return searchResults;
	}

	public Artist getSearchSingleResult() {
		return searchSingleResult;
	}

	public void doSearch() {
		// search by artistId
		try {
			int artistId = Integer.parseInt( searchValue );
			searchSingleResult = artistService.findArtistById(artistId);
			if( searchSingleResult != null ) {
				searchResultCount = 1;				
			}
		} catch( NumberFormatException e ) {
			searchSingleResult = null;
			searchResultCount = 0;
		}

		// search by artist name
		if( searchResultCount == 0 )
		{
			searchResults =  artistService.findArtistsByName(searchValue);
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
	
	public void edit(Artist selectedArtist) {
		searchSingleResult = selectedArtist;
	}
	
	public void updateArtist() {
		artistService.update(searchSingleResult);
		JSFHelper.addInfoMessage("Successfully updated artist information");
	}
	
	public void deleteArtist() {
		try {
			artistService.delete(searchSingleResult);
			JSFHelper.addInfoMessage("Successfully deleted artist");
			searchResultCount = 0;
			searchSingleResult = null;
			searchResults = null;
		} catch (Exception e) {
			JSFHelper.addErrorMessage(e.getMessage());
		}
	}
}
