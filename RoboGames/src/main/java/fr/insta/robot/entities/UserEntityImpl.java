package fr.insta.robot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.insta.robot.bo.UserEntity;

@Entity
@Table(name = "RG_USER")
public class UserEntityImpl implements UserEntity {

	/** serialVersionUID **/
	private static final long serialVersionUID = 1L;
	
	/** L'Id */
	private Long id;
	
	/** L'Habilitation */
//	private HabilitationEntity habilitation;
	
	/** L'informations */
//	private InformationsEntity informations;

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID", unique = true, nullable = false, precision = 20, scale = 0)
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
