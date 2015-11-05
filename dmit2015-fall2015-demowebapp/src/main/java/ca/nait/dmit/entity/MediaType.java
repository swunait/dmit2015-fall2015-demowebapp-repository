package ca.nait.dmit.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MediaType database table.
 * 
 */
@Entity
@NamedQuery(name="MediaType.findAll", query="SELECT m FROM MediaType m")
public class MediaType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MediaTypeId")
	private int mediaTypeId;

	@Column(name="Name")
	private String name;

	public MediaType() {
	}

	public int getMediaTypeId() {
		return this.mediaTypeId;
	}

	public void setMediaTypeId(int mediaTypeId) {
		this.mediaTypeId = mediaTypeId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}