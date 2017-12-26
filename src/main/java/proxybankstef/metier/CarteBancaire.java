package proxybankstef.metier;

/**
 * @author Stephane - Sarra
 * @version 1.0 La carte bancaire est une classe mère qui contient un
 *          constructeur et les accesseurs et mutateurs Implementant l'ID de la
 *          carte et sa date d'expiration. Un boolean permet de valider sa
 *          validité.
 */
public class CarteBancaire {

		private int idCarteBancaire;
		private int dateExpiration;
		private boolean cbValide = true;

		// constructeur
		public CarteBancaire(int idCarteBancaire, int dateExpiration) {
			super();
			this.idCarteBancaire = idCarteBancaire;
			this.dateExpiration = dateExpiration;
		}

		// getteur setteur
		public int getIdCarteBancaire() {
			return idCarteBancaire;
		}

		public void setIdCarteBancaire(int idCarteBancaire) {
			this.idCarteBancaire = idCarteBancaire;
		}

		public int getDateExpiration() {
			return dateExpiration;
		}

		public void setDateExpiration(int dateExpiration) {
			this.dateExpiration = dateExpiration;
		}

		/**
		 * @param cbValide
		 *            permet de mettre à jour la validité de la carte bancaire par un
		 *            boolean : true / false.
		 */
		public void setCbValide(boolean cbValide) {
			this.cbValide = cbValide;
		}
		// methodes

		/**
		 * @return retourne la validité de la carte, boolean : true/ false.
		 */
		public boolean isCbValide() {
			return cbValide;
		}

		/**
		 * Rendre la carte bancaire inactive
		 */
		public void desactiverCB() {
			cbValide = false;
		}

	}



