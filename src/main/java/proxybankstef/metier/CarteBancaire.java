package proxybankstef.metier;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Stephane - Sarra
 * @version 1.0 La carte bancaire est une classe mère qui contient un
 *          constructeur et les accesseurs et mutateurs Implementant l'ID de la
 *          carte et sa date d'expiration. Un boolean permet de valider sa
 *          validité.
 */

@Entity
@Table(name = "cartebancaire")
@Inheritance(strategy = InheritanceType.JOINED)
public class CarteBancaire {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
		private int idCarteBancaire;
		private int dateExpiration;
		
		@Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "created", nullable = false)
		private Date created; 
		private boolean cbValide = true;

		// constructeur
		
		
		public CarteBancaire(int idCarteBancaire, int dateExpiration) {
			super();
			this.idCarteBancaire = idCarteBancaire;
			this.dateExpiration = dateExpiration;
		}

		public CarteBancaire() {
			super();
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

		public Date getCreated() {
			return created;
		}

		public void setCreated(Date created) {
			this.created = created;
		}

	}



