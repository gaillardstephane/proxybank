package proxybankstef.service;

import java.util.ArrayList;

import proxybankstef.metier.Client;
import proxybankstef.persistance.DaoClient;
import proxybankstef.persistance.IDaoGeneric;

/**
 * @author Stephane - Sarra couche intermediare du model 3 tiers, elle sert à
 *         isoler MVC et DAO. sa fonction est de relayer objets et variables
 */
public class ServiceClient {

	private IDaoGeneric client = new DaoClient();

	// methodes
	public Client getClient(int i) {
		return client.retrieve(i);
	}

	public void removeClient(int i) {
		client.delete(i);
	}

	public void updateClient(int i, Client c) {
		client.update(i, c);
	}

	public void addClient(Client e) {
		client.insert(e);
	}

	public ArrayList<Client> listAllClient(int i) {
		return client.selectAllClients(i);
	}

	public Client selectClient(int i) {
		return client.retrieve(i);
	}
}
