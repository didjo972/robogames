package fr.insta.robot.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.insta.robot.bo.HabilitationEntity;
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
	private Set<HabilitationEntity> habilitations = new HashSet<>();
	
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
	/////////////////////////////////////////////////////////////////////////
	@OneToMany(mappedBy="role", targetEntity = HabilitationEntityImpl.class, cascade = CascadeType.ALL)
	@Override
	public Set<HabilitationEntity> getHabilitations() {
		return habilitations;
	}
	
	@Override
	public void setHabilitations(Set<HabilitationEntity> habilitations) {
		this.habilitations = habilitations;
	}

}
