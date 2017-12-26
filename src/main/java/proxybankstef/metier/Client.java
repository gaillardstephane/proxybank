package proxybankstef.metier;

/**
 * @author Stephane - Sarra
 * @version 1.0 Cette classe regroupe les données relatives au client, deux
 *          variables statics permettent de distiunguer le type de client :
 *          Particulier ou Entreprise, la classe dispose en attribut de
 *          CompteCourant et CompteEpargne afin d'aggreger cette classe aux
 *          comptes bancaire.
 */
public class Client {

	public static final String PARTICULIER = "particulier";
	public static final String ENTREPRISE = "entreprise";

	private int clientId;
	private String clientNom;
	private String clientPrenom;
	private String typeClient;
	private CompteCourant clientCC;
	private CompteEpargne clientCE;

	// constructeur
	
	public Client() {
		super(); 
	}

	public Client(int clientId,  String nom, String prenom) {
		super();
		this.clientId= clientId; 
		this.clientNom = nom;
		this.clientPrenom=prenom; 
		}

	public Client(int clientId,  String nom) {
		super();
		this.clientId= clientId; 
		this.clientNom = nom;
		this.typeClient = PARTICULIER;
	}
	
		
	public Client(String nom, String typeClient) {
		super();
		// this.ClientId=instancesId;
		this.clientNom = nom;
		this.typeClient = typeClient;
	}

	// getteur et setteur
	public String getNom() {
		return clientNom;
	}

	public void setId(int clientId) {
		clientId = clientId;
	}

	public void setNom(String nom) {
		this.clientNom = nom;
	}

	public String getPrenom() {
		return clientPrenom;
	}

	public void setPrenom(String clientPrenom) {
		this.clientPrenom = clientPrenom;
	}

	public int getId() {
		return clientId;
	}

	public String getTypeClient() {
		return typeClient;
	}

	public void setTypeClient(String typeClient) {
		this.typeClient = typeClient;
	}

	/**
	 * @param clientCC
	 *            Permet d'ajouter un compte courant au client
	 */
	public void setClientCC(CompteCourant clientCC) {
		clientCC = clientCC;
	}

	/**
	 * @param clientCE
	 *            Permet d'ajouter un compte épargne au client
	 */
	public void setClientCE(CompteEpargne clientCE) {
		clientCE = clientCE;
	}

	// Retourne Les Comptes Bancaires
	/**
	 * @return le compte epargne du client
	 */
	public CompteEpargne getClientCE() {
		return clientCE;
	}

	/**
	 * @return le compte courant du client
	 */
	public CompteCourant getClientCC() {
		return clientCC;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Id Client: " + clientId + "Nom: " + clientNom + "\n";

	}

}
