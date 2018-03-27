package main;

import java.util.ArrayList;

import Entity.Etat;
import Entity.Joueur;
import Entity.Pion;
import Entity.Case;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
		Group troupe = new Group();
		Scene scene = new Scene(troupe, tailleCase + (nbCol) * tailleCase, tailleCase + (nbLigne) * tailleCase,
				Color.ANTIQUEWHITE);
		primaryStage.setTitle("Jeu Du Carre...");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		// definir les acteurs et les habiller
		dessinEnvironnement(troupe);
		// afficher le theatre
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

	/**
	 *  *creation des cellules et de leurs habits  
	 */
	void dessinEnvironnement(Group troupe) {
		Case trait = null;
		Pion pion = null;
		// dessin des lignes
		for (int i = 0; i < nbCol; i++) {
			for (int j = 0; j < nbLigne; j++) {
					trait = new Case(decalage + tailleCase * i, decalage + decalageTrait + tailleCase * j,
							tailleCase, tailleCase, i, j);
					ajoutTrait(trait, i, j, false, troupe);
				
			}
		}
		for(int i = 0; i < 6; i++){
			int rand = (int) (Math.random()*4)+2;
			int rand2 = (int) (Math.random()*2);
			pion = new Pion(decalage + tailleCase * i + tailleCase/2, decalage + decalageTrait + tailleCase * i + tailleCase/2,
					tailleCase/rand, rand2, i, i);
			System.out.println(rand);
			ajoutPion(pion, i, i, false, troupe);
		}

	}
	
	void ajoutPion(Pion pion, int i, int j, boolean horizontal, Group troupe) {
		pion.setOnMouseClicked(this);
        for(Case test : grille){
        	if(test.getLigne() == pion.getLigne() && test.getCol() == pion.getCol())
        	test.placePion();
        }
		troupe.getChildren().add(pion);
	}

	/**
	 *  *dessins des traits et place un trait de la couleur du joueur qui clic
	 * dessus  
	 */
	void ajoutTrait(Case trait, int i, int j, boolean horizontal, Group troupe) {
		troupe.getChildren().add(trait);
		grille.add(trait);
		trait.setOnMouseClicked(this);

	}

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
