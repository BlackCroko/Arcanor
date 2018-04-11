package main;

import affichage.Menu;
import entite.Etat;
import entite.Joueur;
import entite.Plateau;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Appli extends Application {
	/** taille d'une case en pixels */
	int tailleCase;
	int nbLigne;
	int nbCol;
	int decalageTrait;
	int decalage;
	boolean rejouer = false;

	Joueur J1 = new Joueur(Etat.J1, true);
	Joueur J2 = new Joueur(Etat.J2, false);

	String score = "J1 : " + J1.getPoint() + " - " + J2.getPoint() + " : J2";

	Joueur joueur = J1;

	/**
	 * lancement automatique de l'application graphique Definition des variable
	 * de bases
	 */
	public void start(Stage primaryStage) {
		tailleCase = 80;
		nbLigne = 7;
		nbCol = 8;
		decalage = tailleCase / 2;
		decalageTrait = 15;
		construirePlateauJeu(primaryStage);
	}

	/** construction du théatre et de la scène */
	void construirePlateauJeu(Stage primaryStage) {
		// definir la scene principale
		Menu menu = new Menu(decalage, tailleCase, decalageTrait);
		Plateau plateau = new Plateau(decalage, tailleCase, decalageTrait);
		Group troupe = new Group();
		//troupe = plateau.dessinEnvironnement();
		troupe = menu;
		Scene scene = new Scene(troupe, tailleCase + (nbCol) * tailleCase, tailleCase + (nbLigne+1) * tailleCase,
				Color.ANTIQUEWHITE);
		scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
		primaryStage.setTitle("Arcanor");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		// definir les acteurs et les habiller
		// afficher le theatre
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

	/**
	 *  *creation des cellules et de leurs habits  
	 */

	/**
	 *  *dessins des traits et place un trait de la couleur du joueur qui clic
	 * dessus  
	 */


	/**
	 *  *lorsqu'un joueur a joué, on definit l'autre joueur comme joueur actif
	 */
	void changjoueur(Group troupe) {
		if (joueur == J1)
			joueur = J2;
		else
			joueur = J1;
		if (!joueur.isJoueur()) {
			changjoueur(troupe);
		}
	}

	/**
	 *  *verifie si un point a ete maquer return vrai si il a ete marquer ou
	 * faux sinon 
	 */
	boolean pointmarque(int i, int j, Group troupe) {
		return false;
	}

	/**
	 * affiche le nom du vainqueur si la partie est terminé
	 * 
	 * @return vrai si le jeu est terminé, faux sinon 
	 */
	boolean win(Group troupe) {

		return false;
	}

	/**reponse aux evenements de souris*/

}
