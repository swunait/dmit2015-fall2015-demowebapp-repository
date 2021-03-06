package ca.nait.dmit.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;


/**
 * The persistent class for the Album database table.
 * 
 */
@Entity
@NamedQuery(name="Album.findAll", query="SELECT a FROM Album a")
public class Album implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AlbumId")
	private int albumId;

	@NotBlank(message="Album Title is required")
	@Column(name="Title")
	private String title;

	@Valid
	@NotNull(message="A valid artist is required")
	//uni-directional many-to-one association to Artist
	@ManyToOne
	@JoinColumn(name="ArtistId")
	private Artist artist;

	public Album() {
	}

	public int getAlbumId() {
		return this.albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Artist getArtist() {
		return this.artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

}