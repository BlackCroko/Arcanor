package main;

import java.util.ArrayList;

import Entite.Case;
import Entite.Etat;
import Entite.Joueur;
import Entite.Pion;
import Entite.Plateau;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Appli extends Application implements EventHandler<MouseEvent> {
	/** taille d'une case en pixels */
	int tailleCase;
	int nbLigne;
	int nbCol;
	int decalageTrait;
	int decalage;
	boolean rejouer = false;
	
	Pion pionSelectionne;
	ArrayList<Case> grille = new ArrayList();

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
		Plateau plateau = new Plateau(decalage, tailleCase, decalageTrait);
		Group troupe = new Group();
		Scene scene = new Scene(troupe, tailleCase + (nbCol) * tailleCase, tailleCase + (nbLigne) * tailleCase,
				Color.ANTIQUEWHITE);
		primaryStage.setTitle("Arcanor");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		// definir les acteurs et les habiller
		plateau.dessinEnvironnement(troupe);
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
	public void handle(MouseEvent me){
	  
	  Object o = me.getSource();
	  if(o instanceof Pion)
	  {
	    Pion d = (Pion)o;

        System.out.println("clic en " + d.getLigne() + "," + d.getCol());
	    //si on selectionne un nouveau pion ou deselectionne le pion deja selectionne
	    if(pionSelectionne==null || pionSelectionne==d)
	    {
	      d.switchSelected();
	      d.colorPion();
	      if(pionSelectionne==null){ 
	    	  pionSelectionne=d;
	    	  int x = pionSelectionne.getLigne();
	    	  int y = pionSelectionne.getCol();
	    	  for(Case test : grille){
	    		  if(test.getLigne() == x+1 && test.getCol() == y+1){
	    			  if(!test.isPlace())
	    			  test.ispossible();
	    			  else test.isimpossible();
	    		  }
	    		  if(test.getLigne() == x && test.getCol() == y+1){
	    			  if(!test.isPlace())
	    			  test.ispossible();
	    			  else test.isimpossible();
	    		  }
	    		  if(test.getLigne() == x-1 && test.getCol() == y+1){
	    			  if(!test.isPlace())
	    			  test.ispossible();
	    			  else test.isimpossible();
	    		  }
	    		  if(test.getLigne() == x+1 && test.getCol() == y){
	    			  if(!test.isPlace())
	    			  test.ispossible();
	    			  else test.isimpossible();
	    		  }
	    		  if(test.getLigne() == x+1 && test.getCol() == y-1){
	    			  if(!test.isPlace())
	    			  test.ispossible();
	    			  else test.isimpossible();
	    			  
	    		  }
	    		  if(test.getLigne() == x && test.getCol() == y-1){
	    			  if(!test.isPlace())
	    			  test.ispossible();
	    			  else test.isimpossible();
	    		  }
	    		  if(test.getLigne() == x-1 && test.getCol() == y-1){
	    			  if(!test.isPlace())
	    			  test.ispossible();
	    			  else test.isimpossible();
	    		  }
	    		  if(test.getLigne() == x-1 && test.getCol() == y){
	    			  if(!test.isPlace())
	    			  test.ispossible();
	    			  else test.isimpossible();
	    		  } 
	    	  }
	      }
	      else{
	    	  pionSelectionne=null;
	    	  for(Case test : grille){
		        	test.resetColor();
		        }
	      }
	    }
	  }
	  else
	      if(o instanceof Case && pionSelectionne!=null)
	      {
	        Case r = (Case)o;
	        if(r.getEtat() == Etat.possible){
	        	int x = pionSelectionne.getLigne();
	        	int y = pionSelectionne.getCol();
	        	
	        //le nouveau centre du jeton sera au centre du rectangle sélectionné
	        double newX =  r.getX()  + tailleCase/2;
	        double newY =  r.getY() + tailleCase/2;
	        int tps = 300;
	        pionSelectionne.switchSelected();
	        Timeline timeline = new Timeline();
	        timeline.getKeyFrames().addAll(
	          new KeyFrame(new Duration(tps), 
	                new KeyValue(pionSelectionne.centerXProperty(), newX),
	                new KeyValue(pionSelectionne.centerYProperty(), newY),
	                new KeyValue(pionSelectionne.fillProperty(), pionSelectionne.getCj())
	                ));
	        timeline.play();
	        pionSelectionne.setLigne(r.getLigne());
	        pionSelectionne.setCol(r.getCol());
	        for(Case test : grille){
	        	if(test.getLigne() == x && test.getCol() == y){
	        		test.supprPion();
	        	}
	        	if(test.getLigne() == pionSelectionne.getLigne() && test.getCol() == pionSelectionne.getCol()){
	        		test.placePion();
	        	}
	        	test.resetColor();
	        }

	        pionSelectionne = null;
	      }
	   }
	}

}
