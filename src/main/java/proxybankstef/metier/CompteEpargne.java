package proxybankstef.metier;

/**
 * @author Stephane - Sarra
 * @version 1.0 Herite de la classe CompteBancaire et a pour attribut le taux de
 *          remunération par defaut
 */
public class CompteEpargne extends CompteBancaire {

	public double TauxRemuneration = 3;

	// constructeur
	public CompteEpargne(int numCompte, double solde, String date) {
		super(numCompte, solde, date);
	}

	// méthodes
	public double getTauxRemuneration() {
		return TauxRemuneration;
	}

	public void setTauxRemuneration(double tauxRemuneration) {
		TauxRemuneration = tauxRemuneration;
	}

}
