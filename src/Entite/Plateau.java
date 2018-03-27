package Entite;

import javafx.scene.Group;

public class Plateau {
	
	Pion[][] grille = new Pion[7][8];
	int decalage;
	int tailleCase;
	int decalageTrait;
	
	public Plateau(int decalage, int tailleCase, int decalageTrait){
		this.decalage = decalage;
		this.tailleCase = tailleCase;
		this.decalageTrait = decalageTrait;
		Group troupe = new Group();
	}

	
	public void dessinEnvironnement(Group troupe) {
		Case trait = null;
		Pion pion = null;
		// dessin des lignes
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[i].length; j++) {
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
	
	void ajoutTrait(Case trait, int i, int j, boolean horizontal, Group troupe) {
		troupe.getChildren().add(trait);
		grille.add(trait);
		trait.setOnMouseClicked(this);

	}
	
	void ajoutPion(Pion pion, int i, int j, boolean horizontal, Group troupe) {
		pion.setOnMouseClicked(this);
        for(Case test : grille){
        	if(test.getLigne() == pion.getLigne() && test.getCol() == pion.getCol())
        	test.placePion();
        }
		troupe.getChildren().add(pion);
	}
	
}
