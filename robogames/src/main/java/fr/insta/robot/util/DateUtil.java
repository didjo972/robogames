/**
 *
 */
package fr.insta.robot.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.lang3.time.FastDateFormat;


/**
 * Classe utilitaire pour les dates
 */
public final class DateUtil {
    /**
     * Format de date.
     */
    private static final String DATE_PATTERN = "dd/MM/yyyy";

    /**
     * Formatteur de date date2string (Thread Safe au contraire de SimpleDateFormat)
     */
    private static final FastDateFormat DATE_FORMATTER = FastDateFormat.getInstance(DATE_PATTERN);

    /**
     * Map contenant pour chaque année la liste des jours fériés de l'année
     */
    private static Map<Integer, List<Calendar>> mapJoursFeries = new HashMap<Integer, List<Calendar>>();

    /** MILLISECONDS_PER_HOUR */
    public static final int MILLISECONDS_PER_MIN = 1000 * 60;

    /** MILLISECONDS_PER_HOUR */
    public static final int MILLISECONDS_PER_HOUR = MILLISECONDS_PER_MIN * 60;

    /** MILLISECONDS_PER_DAY */
    public static final int MILLISECONDS_PER_DAY = MILLISECONDS_PER_HOUR * 24;

    /**
     * Constructeur privé pour classe utilitaire
     */
    private DateUtil() {
    }

    /**
     * Retourne la date du jour formattée
     * @return String la date formattée
     */
    public static String getDateNowFR() {
        return formatDate(new Date());
    }

    /**
     * Format une date pour l'IHM
     * @param date la date à formater
     * @return la date formatée
     */
    public static String formatDate(final Date date) {
        if (date == null) {
            return "";
        }
        return DATE_FORMATTER.format(date);
    }

    /**
     * Génère une date à partir d'une string
     * @param date la string date à formatter
     * @return la date parsée
     */
    public static Date parseDate(final String date) {
        if (date != null) {
            try {
                final SimpleDateFormat simpleDate = new SimpleDateFormat(DATE_PATTERN);
                return simpleDate.parse(date);
            } catch (final Exception e) {
                return null;
            }
        }

        return null;
    }

    /**
     * Incrémente la date en paramétre
     * @param date la date
     * @param type Calendar.DATE, Calendar.MONTH, ...
     * @param nb nombre a ajouter
     * @return nouvelle date
     */
    public static Date add(final Date date, final int type, final int nb) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(type, nb);
        return cal.getTime();
    }

    /**
     * Retourne la durée formattée (jour, heure, minute)
     * @param dureeMillis durée en milliseconde
     * @param nbHeureOuvreeParJour nombre d'heure ouvrées par jour travaillé (9h par défaut)
     * @param affichageEnJour indicateur du mode d'affichage (true j h m, false h m)
     * @return String la durée formattée (jour, heure, minute)
     */
    public static String formatDuree(final Long dureeMillis, final int nbHeureOuvreeParJour,
                    final boolean affichageEnJour) {

        if (dureeMillis == null) {
            return null;
        }

        // Constantes
        final StringBuilder dureeFr = new StringBuilder();

        // Conversion calendar
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("UTC"));
        c.setTimeInMillis(dureeMillis);

        // Variables
        int jour = 0;
        int heure = (int) (dureeMillis / MILLISECONDS_PER_HOUR);
        final int minute = c.get(Calendar.MINUTE);
        if (affichageEnJour) {
            jour = heure / nbHeureOuvreeParJour;
            heure = heure % nbHeureOuvreeParJour;
        }

        // Affichage
        if (jour > 0 || affichageEnJour) {
            dureeFr.append(jour).append('j');
        }
        if (heure > 0 || minute > 0) {
            if (dureeFr.length() != 0) {
                dureeFr.append(' ');
            }
            dureeFr.append(heure).append('h');
        }
        if (minute > 0) {
            if (dureeFr.length() != 0) {
                dureeFr.append(' ');
            }
            dureeFr.append(minute).append("min");
        }

        return dureeFr.toString();
    }

    /**
     * Calcul du nombre de jours ouvrés entre 2 dates
     * @param date1 date
     * @param date2 date
     * @return nombre de jours ouvrés entre 2 dates
     */
    public static int getNbJoursOuvres(final Date date1, final Date date2) {
        return (int) (getDureeOuvre(date1, date2, 0, 24) / MILLISECONDS_PER_DAY);
    }

    /**
     * Retourne la durée en heures ouvrée entre 2 dates<br/>
     * @param date1 date1
     * @param date2 date2
     * @param heureDebutJournee heure à laquel la journée de travaille commence (9h par défaut)
     * @param heureFinJournee heure à laquel la journée de travaille commence (18h par défaut)
     * @return durée en milliseconde
     */
    public static Long getDureeOuvre(final Date date1, final Date date2, final int heureDebutJournee,
                    final int heureFinJournee) {
        Long dureeTotal = 0L;

        // Constantes
        final int nbHeureOuvreeParJour = heureFinJournee - heureDebutJournee;
        final int nbMillisOuvreeParJour = nbHeureOuvreeParJour * MILLISECONDS_PER_HOUR;

        // Convertion de la date de début en Calendar ouvré
        // Elimination des secondes et millisecondes
        final Calendar c1 = Calendar.getInstance();
        c1.setTime(date1);
        c1.set(Calendar.SECOND, 0);
        c1.set(Calendar.MILLISECOND, 0);
        // Avant 9h, on retourne à 9h00
        if (c1.get(Calendar.HOUR_OF_DAY) < heureDebutJournee) {
            c1.set(Calendar.HOUR_OF_DAY, heureDebutJournee);
            c1.set(Calendar.MINUTE, 0);
        }
        // Après 18h, on retourne à 9h00 le lendemain
        if (c1.get(Calendar.HOUR_OF_DAY) >= heureFinJournee) {
            c1.add(Calendar.DAY_OF_YEAR, 1);
            c1.set(Calendar.HOUR_OF_DAY, heureDebutJournee);
            c1.set(Calendar.MINUTE, 0);
        }

        // Convertion de la date de fin en Calendar ouvré
        // Elimination des secondes et millisecondes
        final Calendar c2 = Calendar.getInstance();
        c2.setTime(date2);
        c2.set(Calendar.SECOND, 0);
        c2.set(Calendar.MILLISECOND, 0);
        // Après 18h, on retourne à 18h00
        if (c2.get(Calendar.HOUR_OF_DAY) >= heureFinJournee) {
            c2.set(Calendar.HOUR_OF_DAY, heureFinJournee);
            c2.set(Calendar.MINUTE, 0);
        }
        // Avant 9h, on retourne à 18h00 la veille
        if (c2.get(Calendar.HOUR_OF_DAY) < heureDebutJournee) {
            c2.add(Calendar.DAY_OF_YEAR, -1);
            c2.set(Calendar.HOUR_OF_DAY, heureFinJournee);
            c2.set(Calendar.MINUTE, 0);
        }

        // Vérification cohérence des 2 dates
        if (c2.before(c1)) {
            return 0L;
        }

        // Si les 2 dates sont sur le même jour, alors on retourne le diff entre les 2
        final Long diff = c2.getTimeInMillis() - c1.getTimeInMillis();
        if (diff < nbMillisOuvreeParJour) {
            if (isJourFerie(c1)) {
                return 0L;
            } else {
                return diff;
            }
        }

        // On traite les jours 1 par 1
        final Calendar cTemp = (Calendar) c1.clone();
        while (cTemp.equals(c2) || cTemp.before(c2)) {

            // Si le jour est travaillé, on incrémente le total
            if (!isJourFerie(cTemp)) {

                // Si c'est le 1er jour, calcul du temps jusqu'a la fin de journée
                // Si c'est le dernier jour, calcul du temps depuis le début de journée
                // Sinon on ajoute une journée entière
                if (cTemp.equals(c1)) {
                    final Calendar cfirst = (Calendar) cTemp.clone();
                    cfirst.set(Calendar.HOUR_OF_DAY, heureFinJournee);
                    cfirst.set(Calendar.MINUTE, 0);
                    dureeTotal += cfirst.getTimeInMillis() - cTemp.getTimeInMillis();

                } else if (cTemp.equals(c2)) {
                    final Calendar clast = (Calendar) cTemp.clone();
                    clast.set(Calendar.HOUR_OF_DAY, heureDebutJournee);
                    clast.set(Calendar.MINUTE, 0);
                    dureeTotal += cTemp.getTimeInMillis() - clast.getTimeInMillis();

                } else {
                    dureeTotal += nbMillisOuvreeParJour;
                }
            }

            // Une fois qu'on a passé le 1er jour, on attend le dernier jour
            if (cTemp.equals(c1)) {
                cTemp.set(Calendar.HOUR_OF_DAY, c2.get(Calendar.HOUR_OF_DAY));
                cTemp.set(Calendar.MINUTE, c2.get(Calendar.MINUTE));
            }
            // On passe au jour suivant
            cTemp.add(Calendar.DAY_OF_YEAR, 1);
        }

        return dureeTotal;
    }

    /**
     * Vérifie si la date en paramétre est un jour férié
     * @param calendar le jour a tester
     * @return indicateur jour férié
     */
    public static boolean isJourFerie(final Calendar calendar) {
        final Calendar date = (Calendar) calendar.clone();

        // Test Samedi - Dimanche
        if (date.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || date.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return true;
        }

        // Lissage de la date pour faciliter les calculs
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);

        // Récupération de l'année pour recherche dans la map de jour férié
        final Integer annee = date.get(Calendar.YEAR);

        // Si la map ne contient pas d'information sur l'année en cours, on calcul les jours fériés et on ajoute dans la map
        if (!mapJoursFeries.containsKey(annee)) {
            // On constitue la liste des jours fériés
            final List<Calendar> joursFeries = new ArrayList<Calendar>();

            // On recherche les jours fériés de l'année de la date en paramètre
            final Calendar jourFerie = (Calendar) date.clone();

            // Jour de l'an
            jourFerie.set(jourFerie.get(Calendar.YEAR), Calendar.JANUARY, 1);
            joursFeries.add((Calendar) jourFerie.clone());

            // 1er mai
            jourFerie.set(jourFerie.get(Calendar.YEAR), Calendar.MAY, 1);
            joursFeries.add((Calendar) jourFerie.clone());

            // 8 mai
            jourFerie.set(jourFerie.get(Calendar.YEAR), Calendar.MAY, 8);
            joursFeries.add((Calendar) jourFerie.clone());

            // Fete national
            jourFerie.set(jourFerie.get(Calendar.YEAR), Calendar.JULY, 14);
            joursFeries.add((Calendar) jourFerie.clone());

            // Assomption
            jourFerie.set(jourFerie.get(Calendar.YEAR), Calendar.AUGUST, 15);
            joursFeries.add((Calendar) jourFerie.clone());

            // Tous Saints
            jourFerie.set(jourFerie.get(Calendar.YEAR), Calendar.NOVEMBER, 1);
            joursFeries.add((Calendar) jourFerie.clone());

            // 11 novembre
            jourFerie.set(jourFerie.get(Calendar.YEAR), Calendar.NOVEMBER, 11);
            joursFeries.add((Calendar) jourFerie.clone());

            // Noel
            jourFerie.set(jourFerie.get(Calendar.YEAR), Calendar.DECEMBER, 25);
            joursFeries.add((Calendar) jourFerie.clone());

            // Pâques (algorithme de Oudin (1940))
            // Calcul du nombre d'or - 1
            final int intGoldNumber = annee % 19;
            // Année divisé par cent
            final int intAnneeDiv100 = annee / 100;
            // intEpacte est = 23 - Epacte (modulo 30)
            final int intEpacte = (intAnneeDiv100 - intAnneeDiv100 / 4 - (8 * intAnneeDiv100 + 13) / 25 + 19
                            * intGoldNumber + 15) % 30;
            // Le nombre de jours à partir du 21 mars pour atteindre la pleine lune Pascale
            final int intDaysEquinoxeToMoonFull = intEpacte - intEpacte / 28
                            * (1 - intEpacte / 28 * (29 / (intEpacte + 1)) * ((21 - intGoldNumber) / 11));
            // Jour de la semaine pour la pleine lune Pascale (0=dimanche)
            final int intWeekDayMoonFull = (annee + annee / 4 + intDaysEquinoxeToMoonFull + 2 - intAnneeDiv100 + intAnneeDiv100 / 4) % 7;
            // Nombre de jours du 21 mars jusqu'au dimanche de ou avant la pleine lune Pascale (un nombre entre -6 et 28)
            final int intDaysEquinoxeBeforeFullMoon = intDaysEquinoxeToMoonFull - intWeekDayMoonFull;
            // Mois de pâques
            final int intMonthPaques = 3 + (intDaysEquinoxeBeforeFullMoon + 40) / 44;
            // Jour de pâques
            final int intDayPaques = intDaysEquinoxeBeforeFullMoon + 28 - 31 * (intMonthPaques / 4);
            // Lundi de pâques
            jourFerie.set(annee, intMonthPaques - 1, intDayPaques + 1);
            final Calendar lundiDePaque = (Calendar) jourFerie.clone();
            joursFeries.add(lundiDePaque);

            // Ascension, 38 jours après Paques
            final Calendar ascension = (Calendar) lundiDePaque.clone();
            ascension.add(Calendar.DAY_OF_YEAR, 38);
            joursFeries.add(ascension);

            // Pentecote, 49 jours après Paques
            final Calendar lundiPentecote = (Calendar) lundiDePaque.clone();
            lundiPentecote.add(Calendar.DAY_OF_YEAR, 49);
            joursFeries.add(lundiPentecote);

            // Ajout dans la map
            synchronized (mapJoursFeries) {
                mapJoursFeries.put(annee, joursFeries);
            }
        }

        // Résultat
        return mapJoursFeries.get(annee).contains(date);
    }

    /**
     * Calcul le nombre de jour entre 2 dates
     * @param a première date
     * @param b deuxième date
     * @return nombre de jour entre 2 dates
     */
    public static int nbJoursEntre(final Date a, final Date b) {

        // On retire les heures, minutes, secondes, millisecondes pour avoir une comparaison en jours cohérente
        final Date aWithHMS = getDateWithoutHMS(a);
        final Date bWithHMS = getDateWithoutHMS(b);

        return (int) (Math.abs(aWithHMS.getTime() - bWithHMS.getTime()) / MILLISECONDS_PER_DAY);
    }

    /**
     * Méthode qui renvoie une date sans les heures / minutes / secondes
     * @param date la date à laquelle retirer les données
     * @return la date sans les hms
     */
    public static Date getDateWithoutHMS(final Date date) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * Méthode comparant deux dates sans prendre en compte les minutes/secondes
     * @param pDate1 la première date
     * @param pDate2 la seconde date
     * @return true si la première date est après ou égale la deuxième
     */
    public static boolean afterOrEqual(final Date pDate1, final Date pDate2) {
        final int result = compare(pDate1, pDate2);
        return result == 1 || result == 0;
    }

    /**
     * Méthode comparant deux dates sans prendre en compte les minutes/secondes
     * @param pDate1 la première date
     * @param pDate2 la seconde date
     * @return true si lapremière date est avant ou egale à la deuxième
     */
    public static boolean beforeOrEqual(final Date pDate1, final Date pDate2) {
        final int result = compare(pDate1, pDate2);
        return result == -1 || result == 0;
    }

    /**
     * Compare 2 dates en prenant en compte HH:mm
     * @param date1 la première date
     * @param date2 la seconde date
     * @return 0 si les date sont identiques, 1 si la 1ère est > à la 2ème, -1 si la 1ère est < à la 2ème
     */
    public static int compare(final Date date1, final Date date2) {
        final Calendar ca = new GregorianCalendar();
        final Calendar cb = new GregorianCalendar();
        ca.setTime(date1);
        cb.setTime(date2);

        int result = 0;

        if (ca.get(Calendar.YEAR) < cb.get(Calendar.YEAR)) {
            result = -1;
        } else if (ca.get(Calendar.YEAR) > cb.get(Calendar.YEAR)) {
            result = 1;
        } else {
            if (ca.get(Calendar.DAY_OF_YEAR) < cb.get(Calendar.DAY_OF_YEAR)) {
                result = -1;
            } else if (ca.get(Calendar.DAY_OF_YEAR) > cb.get(Calendar.DAY_OF_YEAR)) {
                result = 1;
            } else {
                if (ca.get(Calendar.HOUR_OF_DAY) < cb.get(Calendar.HOUR_OF_DAY)) {
                    result = -1;
                } else if (ca.get(Calendar.HOUR_OF_DAY) > cb.get(Calendar.HOUR_OF_DAY)) {
                    result = 1;
                } else {
                    if (ca.get(Calendar.MINUTE) < cb.get(Calendar.MINUTE)) {
                        result = -1;
                    } else if (ca.get(Calendar.MINUTE) > cb.get(Calendar.MINUTE)) {
                        result = 1;
                    }
                }
            }
        }
        return result;
    }

    /**
     * @return l'année courante
     */
    public static int getAnneeCourante() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    /**
     * Retourne l'annee de la date passée en paramètre
     * @param date une date
     * @return l'annee de la date, ou null si date==null
     */
    public static Integer getAnneeDate(final Date date) {
        if (date == null) {
            return null;
        }
        final Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }
}
