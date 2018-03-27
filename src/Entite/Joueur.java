
/**
 * Classe gestion des joueurs
 * @param couleur	Definit la couleur du joueur
 * @param point		Nombre de points du joueur 
 * @param joueur	Vaut true si il s'agit d'un joueur et false pour une IA
 * @author Romain Thuillez
 */

package Entity;

import javafx.scene.Group;

public class Joueur {
	private Etat couleur;
	private int point = 0;
	private boolean joueur;
	
	public Joueur(Etat couleur, boolean joueur) {
		this.couleur = couleur;
		this.joueur = joueur;
	}

	public Etat getCouleur() {
		return couleur;
	}

	public void setCouleur(Etat couleur) {
		this.couleur = couleur;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public boolean isJoueur() {
		return joueur;
	}

	public void setJoueur(boolean joueur) {
		this.joueur = joueur;
	}
	
}
