package fr.insta.robot.entities;

import fr.insta.robot.bo.BilletEntity;
import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.bo.HabilitationEntity;
import fr.insta.robot.bo.InformationsEntity;
import fr.insta.robot.bo.LiveEntity;
import fr.insta.robot.bo.RoleEntity;
import fr.insta.robot.bo.UserEntity;

/**
 * Factory qui permet de créer les objets métiers.
 */
public final class RGEntityFactory {

	/**
     * Constructeur bloqué on ne doit accéder que par les méthodes statiques.
     */
    private RGEntityFactory() {
        super();
    }
    
    /**
     * Méthode qui crée et renvoie un objet de type BilletEntity.
     * @return un BilletEntity
     */
    public static BilletEntity getBilletEntityInstance() {
    	return new BilletEntityImpl();
    }
    
    /**
     * Méthode qui crée et renvoie un objet de type EvenementEntity.
     * @return un EvenementEntity
     */
    public static EvenementEntity getEvenementEntityInstance() {
    	return new EvenementEntityImpl();
    }
    
    /**
     * Méthode qui crée et renvoie un objet de type HabilitationEntity.
     * @return un HabilitationEntity
     */
    public static HabilitationEntity getHabilitationEntityInstance() {
    	return new HabilitationEntityImpl();
    }
    
    /**
     * Méthode qui crée et renvoie un objet de type InformationsEntity.
     * @return un InformationsEntity
     */
    public static InformationsEntity getInformationsEntityInstance() {
    	return new InformationsEntityImpl();
    }
    
    /**
     * Méthode qui crée et renvoie un objet de type LiveEntity.
     * @return un LiveEntity
     */
    public static LiveEntity getLiveEntityInstance() {
    	return new LiveEntityImpl();
    }
    
    /**
     * Méthode qui crée et renvoie un objet de type RoleEntity.
     * @return un RoleEntity
     */
    public static RoleEntity getRoleEntityInstance() {
    	return new RoleEntityImpl();
    }
    
    /**
     * Méthode qui crée et renvoie un objet de type UserEntity.
     * @return un UserEntity
     */
    public static UserEntity getUserEntityInstance() {
        return new UserEntityImpl();
    }
    
}
