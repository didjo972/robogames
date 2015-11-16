package fr.insta.robot.common;

/**
 * Liste des écrans
 */
public final class Ecran {

    /**
     * Constructeur privé.
     */
    private Ecran() {
        super();
    }

    /**
     * Préfixe sur toutes les pages
     */
    private static final String VIEWS_PREFIX = "/views";

    /**
     * Préfixe sur toutes les pages du bloc USER
     */
    private static final String VIEWS_USER = VIEWS_PREFIX + "/USER";

    /**
     * Ecrans globaux de l'application
     */
    public enum Global implements IEcran {
        /**
         * GLOBAL
         */
        LOGIN(VIEWS_PREFIX + "/login.xhtml"),

        /**
         * Accès interdit
         */
        ACCES_INTERDIT(VIEWS_PREFIX + "/acces_interdit.xhtml");

        /**
         * url
         */
        private final String url;

        /**
         * @param url url de l'écran
         */
        private Global(final String url) {
            this.url = url;
        }

        @Override
        public String getUrl() {
            return url;
        }
    }

    /**
     * Ecrans du bloc USER
     */
    public enum USER implements IEcran {

        /** Rechercher un prestataire */
        ACCUEIL(VIEWS_USER + "/accueil.xhtml"),
        /** Declarer un prestataire */
        BILLETTERIE(VIEWS_USER + "/billetterie.xhtml"),
        /** Fiche prestataire */
        DEBRIEFS(VIEWS_USER + "/debriefs.xhtml"),
        /** Affecter un contrat */
        LIVE(VIEWS_USER + "/live.xhtml"),
        /** Fiche prestataire */
        LOCALISATION(VIEWS_USER + "/localisation.xhtml"),
        /** Gérer lien fiche fournisseur */
        MATCH(VIEWS_USER + "/match.xhtml");

        /**
         * url
         */
        private final String url;

        /**
         * @param url url de l'écran
         */
        private USER(final String url) {
            this.url = url;
        }

        @Override
        public String getUrl() {
            return url;
        }
    }

    /**
     * @param ecran l'écran dont on cherche l'url
     * @param redirect indicateur de redirection
     * @param params les paramètres de construction de l'url
     * @return url
     */
    public static String getUrl(final IEcran ecran, final boolean redirect, final Object... params) {
        if (redirect) {
            return redirectTo(ecran.getUrl(), params);
        }
        return String.format(ecran.getUrl(), params);
    }

    /**
     * Redirige l'application sur une URL donnée
     * @param url url
     * @param params les paramètres de construction de l'url
     * @return url
     */
    public static String redirectTo(final String url, final Object... params) {
        String finalUrl = String.format(url, params);
        if (params.length > 0 || url.indexOf('?') != -1) {
            finalUrl += "&faces-redirect=true";
        } else {
            finalUrl += "?faces-redirect=true";
        }
        return finalUrl;
    }

    /**
     * Redirige l'application sur un écran donné
     * @param ecran ecran
     * @param params les paramètres de construction de l'url
     * @return url
     */
    public static String redirectTo(final IEcran ecran, final Object... params) {
        return redirectTo(ecran.getUrl(), params);
    }

}
