package fr.insta.robot.bo;

public interface LiveEntity {
	
	/**
     * Retourne l'id
     * @return l'identifiant du Bean
     */
    Long getId();

    /**
     * Met à jour l'id
     * @param id l'identifiant du Bean
     */
    void setId(Long id);
	
	/**
	 * Retourne l'url
	 * @return l'url
	 */
	String getUrl();
	
	/**
	 * Met à jour l'url
	 * @param url l'url
	 */
	void setUrl(String url);
}
