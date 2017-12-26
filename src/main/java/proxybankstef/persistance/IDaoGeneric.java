package proxybankstef.persistance;

import java.util.ArrayList;
import classesMetiers.Client;

/**
 * @author Stephane - Sarra 
 * 
 *         l'interface IdaoGeneric contient les methodes
 *         Insert, Update, Delete, retrieve, et select All, contrairement à ce
 *         que son nom indique, elle n'est pas génerique, elle sera implémentée
 *         par la classe DaoClient.
 */
public interface IDaoGeneric {

	void insert(Client c);

	void update(int i, Client c);

	void delete(int i);

	Client retrieve(int i);

	ArrayList<Client> selectAllClients(int i);

}
