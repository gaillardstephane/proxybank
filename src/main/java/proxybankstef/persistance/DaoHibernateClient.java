package proxybankstef.persistance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import proxybankstef.metier.Client;
import proxybankstef.metier.CompteBancaire;
import proxybankstef.util.HibernateUtil;

/**
 * @author stephane Dao Client, ajouter le nom d'un cutomer, ajouter un
 *         compteBancaire à un client, selectionner tous les client
 *
 */
public class DaoHibernateClient {

	// ajouter un client ??? le client est il instencié ici ? 
	public void addClient(String name, String prenom) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();

		try {
			txn.begin();
// question le client est il vraiment créer ici, ou plutôt dans la couche service et persisté en DAO ? 
			Client client = new Client();
			client.setNom(name);
			client.setPrenom(prenom);
			session.save(client);

			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// updater un client
	public void updateClient(Client client) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();

		try {
			txn.begin();

			Client clientsession = (Client) session.get(Client.class, client.getId());
			clientsession = client;
			session.update(clientsession);

			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
	}

	// ajouter un compteBancaire à un client , le passeport doit-etre créer par la Dao
	// compteBancaire puis ajouté ensuite ici au client
	public void addPasstoCus(Client client, CompteBancaire compteBancaire) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();

		try {
			txn.begin();

			//ajouter une liste de compte bancaire dans le client, relation oneToMany, la méthode add doit-etre ajouter ( reverse end) 
			Client custsession = (Client) session.get(Client.class, client.getId());
			custsession.setCompteBancaire(compteBancaire);
			session.save(custsession);

			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
	}
	// suprimer un compteBancaire à partir d'un client, verirification de l'identite des
	// compteBancaires en base et ammené

	public void removePasstoCus(Client client, CompteBancaire compteBancaire) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();

		try {
			txn.begin();

			//ajouter une liste de compte bancaire dans le client, relation oneToMany, la méthode add doit-etre ajouter ( reverse end) 
			Client custsession = (Client) session.get(Client.class, client.getId());
			CompteBancaire passpsession = custsession.getCompteBancaire();

			if (compteBancaire.equals(passpsession)) {

				session.delete(compteBancaire);

			} else {

				session.close();
			}

			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// effacer un client
	public void removeCust(Client client) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();

		try {
			txn.begin();

			Client custsession = (Client) session.get(Client.class, client.getId());
			session.delete(custsession);

			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	public ArrayList<Client> gettingdAllCust() {

		ArrayList<Client> listcust = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();

		try {
			txn.begin();

			Query query = session.createQuery("select * from client");

			for (Iterator<Client> i = query.list().iterator(); i.hasNext();) {
				Client client = i.next();
				listcust.add(client);
			}
			
			
			
			
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
		return listcust;

	}
}
