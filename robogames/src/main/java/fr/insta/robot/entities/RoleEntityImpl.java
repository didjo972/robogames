package fr.insta.robot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.insta.robot.bo.RoleEntity;

@Entity
@Table(name = "RG_ROLE")
public class RoleEntityImpl implements RoleEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String libelle;
	
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ROL_ID",unique = true, nullable = false, precision = 20, scale = 0)	
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	@Column(name = "ROL_LIBELLE", unique = false, nullable = false, length = 100)
	public String getLibelle() {
		return libelle;
	}

	@Override
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
