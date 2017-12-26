package proxybankstef.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import proxybankstef.metier.Client;



/**
 * @author adminl
 *la classe DaoClient impl�mente l'interface IdaoClient, elle applique donc les 4 methodes decrites dans l'interfaces(insert,  
 *
 */
public class DaoClient implements IDaoGeneric {

	
	public void insert(Client c) {
		/**
		 *La m�thode insert prend en param�tre un client, elle permet de cr�er un client.
		 *
		 */
		
		try {
			Connection cnx = MyUtil.seConnecter();
			String s = "insert into client values(?,?,?,?)";
			PreparedStatement prestat = cnx.prepareStatement(s);
			prestat.setInt(1, c.getId());
			prestat.setString(2, c.getNom());
			prestat.setString(3, c.getPrenom());
			prestat.setInt(4, 2);

			prestat.executeUpdate();
			MyUtil.seDeconnecter(cnx);
			// System.out.println("insertion�");
		} catch (SQLException ex) {
			Logger.getLogger(DaoClient.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	
	/**
	 * La m�thode delete prend en param�tre l'idClient, elle permet de suprimer un client en utilisant son Idclient.
	 *
	 */
	public void delete(int i) {

		try {
			Connection cnx = MyUtil.seConnecter();
			String s = " delete from client where idclient=? ";
			PreparedStatement prestat2 = cnx.prepareStatement(s);
			prestat2.setInt(1, i);
			prestat2.executeUpdate();
			MyUtil.seDeconnecter(cnx);
			// System.out.println("dilit�n�");
		} catch (SQLException ex) {
			Logger.getLogger(DaoClient.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	/**
	 *  La m�thode update prend en param�tre l'idClient, et le client,  elle permet de mettre � jours un client grace � son Id.
	 *
	 */
	public void update(int i, Client c) {
		try {

			Connection cnx = MyUtil.seConnecter();
			String s = "update client set  nom=?, prenom=? where idclient=?";
			PreparedStatement prestat = cnx.prepareStatement(s);

			prestat.setString(1, c.getNom());
			prestat.setString(2, c.getPrenom());
			prestat.setInt(3, c.getId());

			prestat.executeUpdate();
			MyUtil.seDeconnecter(cnx);

		} catch (SQLException ex) {
			Logger.getLogger(DaoClient.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	/**
	 *  La m�thode SelectAll prend en param�tre l'idClient, elle permet de r�cuperer les clients � partir de l'Id du conseiller et retourner une arrayListe.
	 *
	 */

	public ArrayList<Client> selectAllClients(int i) {

		ArrayList<Client> listClient = new ArrayList<>();
		try {
			Connection cnx = MyUtil.seConnecter();
			String s = "select * from client where idconseiller= ? ";
			PreparedStatement prestat = cnx.prepareStatement(s);
			prestat.setInt(1, i);
			ResultSet rst = prestat.executeQuery();

			while (rst.next()) {
				int idclient = rst.getInt("idclient");
				String nom = rst.getString("nom");
				String prenom = rst.getString("prenom");

				Client c1 = new Client(idclient, nom, prenom);
				listClient.add(c1);
			}
			MyUtil.seDeconnecter(cnx);

		} catch (SQLException ex) {
			Logger.getLogger(DaoClient.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listClient;
	}
	/**
	 *  La m�thode retrieve prend en param�tre l'idClient, elle permet de selectionner un client en utilisant son Idclient.
	 *
	 */

	public Client retrieve(int i) {

		try {
			Connection cnx = MyUtil.seConnecter();
			String s = "select idclient, nom, prenom from client where idclient= ? ";
			
			PreparedStatement prestat = cnx.prepareStatement(s);
			prestat.setInt(1, i);
			ResultSet rst = prestat.executeQuery();
			
			int idclient = rst.getInt("idclient");
			String nom = rst.getString("nom");
			String prenom = rst.getString("prenom");

			MyUtil.seDeconnecter(cnx);

			return new Client(idclient, nom, prenom);
			// System.out.println("selection�");

		} catch (SQLException ex) {
			Logger.getLogger(DaoClient.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}

	}



}
