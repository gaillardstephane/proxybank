package proxybankstef.metier;

/**
 * @author Stephane - Sarra
 * @version 1.0
 * La contenant les differents employées, Conseiller et Gérant, la classe possede un numID, nom de l'employe et son prenom
 */
public class Employe {

	protected int numId;
	protected String nomE;
	protected String prenomE;

	// constructeur
	public Employe(int numId, String nomE, String prenomE) {
		super();
		this.numId = numId;
		this.nomE = nomE;
		this.prenomE = prenomE;
	}

	// getter et setter
	public int getNumId() {
		return numId;
	}

	public void setNumId(int numId) {
		this.numId = numId;
	}

	public String getNomE() {
		return nomE;
	}

	public void setNomE(String nomE) {
		this.nomE = nomE;
	}

	public String getPrenomE() {
		return prenomE;
	}

	public void setPrenomE(String prenomE) {
		this.prenomE = prenomE;
	}
	// méthodes
}

