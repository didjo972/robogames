package fr.insta.robot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.insta.robot.bo.LiveEntity;

@Entity
@Table(name = "RG_LIVE")
public class LiveEntityImpl implements LiveEntity {
	
	/** Id */
	private Long id;
	/** Url */
	private String url;
	
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LIVE_ID",unique = true, nullable = false, precision = 20, scale = 0)	
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	@Column(name = "INF_NOM", unique = false, nullable = false, columnDefinition = "LONGTEXT")
	public String getUrl() {
		return url;
	}

	@Override
	public void setUrl(String url) {
		this.url = url;
		
	}

}
