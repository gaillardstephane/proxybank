package proxybankstef.persistance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Query;

import org.formation.oneToMany.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author stephane Dao Customer, ajouter le nom d'un cutomer, ajouter un
 *         passport à un customer, selectionner tous les customer
 *
 */
public class DaoProfessor {

	// ajouter un customer
	public void addCustomer(String name, String prenom) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();

		try {
			txn.begin();

			Customer customer = new Customer();
			customer.setName(name);
			customer.setPrenom(prenom);
			session.save(customer);

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

	// updater un customer
	public void updateCustomer(Customer customer) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();

		try {
			txn.begin();

			Customer custsession = (Customer) session.get(Customer.class, customer.getIdCus());
			custsession = customer;
			session.update(custsession);

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

	// ajouter un passport à un customer , le passeport doit-etre créer par la Dao
	// passport puis ajouté ensuite ici au client
	public void addPasstoCus(Customer customer, Passport passport) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();

		try {
			txn.begin();

			Customer custsession = (Customer) session.get(Customer.class, customer.getIdCus());
			custsession.setPassport(passport);
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
	// suprimer un passport à partir d'un customer, verirification de l'identite des
	// passports en base et ammené

	public void removePasstoCus(Customer customer, Passport passport) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();

		try {
			txn.begin();

			Customer custsession = (Customer) session.get(Customer.class, customer.getIdCus());
			Passport passpsession = custsession.getPassport();

			if (passport.equals(passpsession)) {

				session.delete(passport);

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

	// effacer un customer
	public void removeCust(Customer customer) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();

		try {
			txn.begin();

			Customer custsession = (Customer) session.get(Customer.class, customer.getIdCus());
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

	public ArrayList<Customer> gettingdAllCust() {

		ArrayList<Customer> listcust = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();

		try {
			txn.begin();

			Query query = session.createQuery("select * from customer");

			for (Iterator<Customer> i = query.list().iterator(); i.hasNext();) {
				Customer customer = i.next();
				listcust.add(customer);
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
