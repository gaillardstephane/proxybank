package proxybankstef.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Stephane - Sarra
 *         la classe MyUtil permet de se connecter grace à la
 *         methode seConnecter et à se deconnecter grace à la methose se
 *         Deconnecter
 *
 */
public class MyUtil {

	public static Connection seConnecter() {
		Connection cnx = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnx = DriverManager.getConnection("jdbc:mysql://localhost/proxybanquess", "root", "");

		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(MyUtil.class.getName()).log(Level.SEVERE, null, ex);

		}
		return cnx;
	}

	public static void seDeconnecter(Connection cnx) {
		try {
			cnx.close();
		} catch (SQLException ex) {
			Logger.getLogger(MyUtil.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
