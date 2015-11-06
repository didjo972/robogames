package fr.insta.robot.services;

import fr.insta.robot.AbstractServiceFactory;

/**
 * Factory des services.
 */
public class RGServiceFactory extends AbstractServiceFactory {
	/**
     * Le singleton.
     */
    private static final RGServiceFactory INSTANCE = new RGServiceFactory();

    /**
     * Constructeur privé pour singleton.
     */
    private RGServiceFactory() {
        super();
    }

    /**
     * @return le singleton
     */
    public static RGServiceFactory getInstance() {
        return INSTANCE;
    }
    
    /**
     * Méthode qui créee et renvoie un objet de type BilletService.
     * @return un service exposant les méthodes de haut niveau pour les actions sur les objets de type BilletService
     */
    public BilletService getBilletService() {
    	return (BilletService) getContext().getBean("billetService");
    }
    
    /**
     * Méthode qui créee et renvoie un objet de type EvenementService.
     * @return un service exposant les méthodes de haut niveau pour les actions sur les objets de type EvenementService
     */
    public EvenementService getEvenementService() {
    	return (EvenementService) getContext().getBean("evenementService");
    }
    
    /**
     * Méthode qui créee et renvoie un objet de type HabilitationService.
     * @return un service exposant les méthodes de haut niveau pour les actions sur les objets de type HabilitationService
     */
    public HabilitationService getHabilitationService() {
    	return (HabilitationService) getContext().getBean("habilitationService");
    }
    
    /**
     * Méthode qui créee et renvoie un objet de type InformationsService.
     * @return un service exposant les méthodes de haut niveau pour les actions sur les objets de type InformationsService
     */
    public InformationsService getInformationsService() {
    	return (InformationsService) getContext().getBean("informationsService");
    }
    
    /**
     * Méthode qui créee et renvoie un objet de type LiveService.
     * @return un service exposant les méthodes de haut niveau pour les actions sur les objets de type LiveService
     */
    public LiveService getLiveService() {
    	return (LiveService) getContext().getBean("liveService");
    }
    
    /**
     * Méthode qui créee et renvoie un objet de type RoleService.
     * @return un service exposant les méthodes de haut niveau pour les actions sur les objets de type RoleService
     */
    public RoleService getRoleService() {
    	return (RoleService) getContext().getBean("roleService");
    }
    
    /**
     * Méthode qui créee et renvoie un objet de type UserService.
     * @return un service exposant les méthodes de haut niveau pour les actions sur les objets de type UserService
     */
    public UserService getUserService() {
    	return (UserService) getContext().getBean("userService");
    }
}
