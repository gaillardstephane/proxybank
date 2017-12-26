package proxybankstef.metier;
/**
 * @author Stephane -Sarra
 * @version 1.0 Est la classe m�re de CompteCourant et CompteEpargne, contient
 *          du num�ro de client associ� ainsi que le solde et la date de
 *          creation
 */
public class CompteBancaire {

	// Attributs
	private int CbNumCompte;
	private double CbSolde;
	private String CbDate;

	// Constructeurs
	public CompteBancaire(int numCompte, double solde, String date) {
		super();
		this.CbNumCompte = numCompte;
		this.CbSolde = solde;
		this.CbDate = date;
	}

	// Getters et Setters
	public int getNumCompte() {
		return CbNumCompte;
	}

	public double getSolde() {
		return CbSolde;
	}

	public void setSolde(double solde) {
		this.CbSolde = solde;
	}

	public String getDate() {
		return CbDate;
	}

	public void setDate(String date) {
		this.CbDate = date;
	}

	// M�thodes
	/**
	 * M�thodes permet de verifier le compte depasse le solde autoris�: retourne un
	 * boolean
	 */
	public void auditerCompte() {

	}

	public String toString() {
		return "Le num�ro de compte " + CbNumCompte + " a �t� cr�e le " + CbDate + " Solde= " + CbSolde;
	}
}
