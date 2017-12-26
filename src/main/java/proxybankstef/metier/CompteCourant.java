package proxybankstef.metier;
/**
 * @author Stephane - Sarra
 * @version 1.0 Herite de la classe CompteBancaire et a pour attribut le montant
 *          autorisé de découvert par defaut
 * 
 */

public class CompteCourant extends CompteBancaire {

	private double decouvert = 1000;

	// constructeur
	public CompteCourant(int numCompte, double solde, String date) {
		super(numCompte, solde, date);

	}

	// getteur et setteur
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public double getDecouvert() {
		return decouvert;
	}
	// methodes
}
