package proxybankstef.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Stephane - Sarra
 * @version 1.0 L' agence contient un constructeur et les accesseurs et
 *          mutateurs Implementation de l'identifiant de l'agence et de la date de
 *          création
 */
@Entity
public class Agence {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int numId;
	private String dateCreation;

	// constructeur
	
	
	public Agence() {
		super();
	}
	
	public Agence(int numId, String dateCreation) {
		super();
		this.numId = numId;
		this.dateCreation = dateCreation;
	}

	// getteur et setteur
	public int getNumId() {
		return numId;
	}

	public void setNumId(int numId) {
		this.numId = numId;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	// méthodes

}


