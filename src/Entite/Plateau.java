package Entite;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class Plateau implements EventHandler<MouseEvent> {

	Case[][] grille = new Case[8][7];
	int decalage;
	int tailleCase;
	int decalageTrait;
	Pion pionSelectionne;
	Group troupe = new Group();

	public Plateau(int decalage, int tailleCase, int decalageTrait) {
		this.decalage = decalage;
		this.tailleCase = tailleCase;
		this.decalageTrait = decalageTrait;
	}

	public Group dessinEnvironnement() {
		Pion pion = null;
		// dessin des lignes
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[i].length; j++) {
				grille[i][j] = new Case(decalage + tailleCase * i, decalage + decalageTrait + tailleCase * j,
						tailleCase, tailleCase, i, j);
				troupe.getChildren().add(grille[i][j]);
				grille[i][j].setOnMouseClicked(this);

			}
		}
		int rand = 1;
		for (int i = 0; i < 8; i++) {
			for(int j = 0; j< 2; j++){
			rand =4 - i % 4;
			int rand2 = (int) (Math.random() * 2);
			pion = new Pion(decalage + tailleCase * i + tailleCase / 2,
					decalage + decalageTrait + tailleCase * j*6 + tailleCase / 2, tailleCase/2, rand, rand2, i, j*6);
			ajoutPion(pion, i, j*6, false, troupe);
			}
		}
		return troupe;

	}

	void ajoutPion(Pion pion, int i, int j, boolean horizontal, Group troupe) {
		pion.setOnMouseClicked(this);
		grille[pion.getLigne()][pion.getCol()].placePion(pion);
		troupe.getChildren().add(pion);
	}

	public void handle(MouseEvent me) {

		Object o = me.getSource();
		if (o instanceof Pion) {
			Pion d = (Pion) o;

			System.out.println("clic en " + d.getLigne() + "," + d.getCol());
			// si on selectionne un nouveau pion ou deselectionne le pion deja selectionne
			if (pionSelectionne == null || pionSelectionne == d) {
				d.switchSelected();
				d.colorPion();
				if (pionSelectionne == null) {
					pionSelectionne = d;
					int x = pionSelectionne.getLigne();
					int y = pionSelectionne.getCol();
					for (int i = 0; i < grille.length; i++) {
						for (int j = 0; j < grille[i].length; j++) {
							if (grille[i][j].getLigne() == x + 1 && grille[i][j].getCol() == y + 1) {
								if (grille[i][j].isJouable(pionSelectionne))
									grille[i][j].ispossible();
								else
									grille[i][j].isimpossible();
							}
							if (grille[i][j].getLigne() == x && grille[i][j].getCol() == y + 1) {
								if (grille[i][j].isJouable(pionSelectionne))
									grille[i][j].ispossible();
								else
									grille[i][j].isimpossible();
							}
							if (grille[i][j].getLigne() == x - 1 && grille[i][j].getCol() == y + 1) {
								if (grille[i][j].isJouable(pionSelectionne))
									grille[i][j].ispossible();
								else
									grille[i][j].isimpossible();
							}
							if (grille[i][j].getLigne() == x + 1 && grille[i][j].getCol() == y) {
								if (grille[i][j].isJouable(pionSelectionne))
									grille[i][j].ispossible();
								else
									grille[i][j].isimpossible();
							}
							if (grille[i][j].getLigne() == x + 1 && grille[i][j].getCol() == y - 1) {
								if (grille[i][j].isJouable(pionSelectionne))
									grille[i][j].ispossible();
								else
									grille[i][j].isimpossible();

							}
							if (grille[i][j].getLigne() == x && grille[i][j].getCol() == y - 1) {
								if (grille[i][j].isJouable(pionSelectionne))
									grille[i][j].ispossible();
								else
									grille[i][j].isimpossible();
							}
							if (grille[i][j].getLigne() == x - 1 && grille[i][j].getCol() == y - 1) {
								if (grille[i][j].isJouable(pionSelectionne))
									grille[i][j].ispossible();
								else
									grille[i][j].isimpossible();
							}
							if (grille[i][j].getLigne() == x - 1 && grille[i][j].getCol() == y) {
								if (grille[i][j].isJouable(pionSelectionne))
									grille[i][j].ispossible();
								else
									grille[i][j].isimpossible();
							}
						}
					}
				} else {
					pionSelectionne = null;
					for (int i = 0; i < grille.length; i++) {
						for (int j = 0; j < grille[i].length; j++) {
							grille[i][j].resetColor();
						}
					}
				}
			}
		} else if (o instanceof Case && pionSelectionne != null) {
			Case r = (Case) o;
			if (r.getEtat() == Etat.possible) {
				int x = pionSelectionne.getLigne();
				int y = pionSelectionne.getCol();
				if(r.Contenu()!=null)
				pionSelectionne.setFils(r.Contenu());
				//System.out.println(r.Contenu());
				// le nouveau centre du jeton sera au centre du rectangle sélectionné
				double newX = r.getX() + tailleCase / 2;
				double newY = r.getY() + tailleCase / 2;
				int tps = 300;
				pionSelectionne.switchSelected();
				pionSelectionne.deplacement(r.getLigne(), r.getCol(), newX, newY);
				/*Timeline timeline = new Timeline();
				timeline.getKeyFrames()
						.addAll(new KeyFrame(new Duration(tps), new KeyValue(pionSelectionne.centerXProperty(), newX),
								new KeyValue(pionSelectionne.centerYProperty(), newY),
								new KeyValue(pionSelectionne.fillProperty(), pionSelectionne.getCj())));
				timeline.play();*/
				pionSelectionne.setLigne(r.getLigne());
				pionSelectionne.setCol(r.getCol());
				for (int i = 0; i < grille.length; i++) {
					for (int j = 0; j < grille[i].length; j++) {
						if (grille[i][j].getLigne() == x && grille[i][j].getCol() == y) {
							grille[i][j].supprPion();
						}
						if (grille[i][j].getLigne() == pionSelectionne.getLigne()
								&& grille[i][j].getCol() == pionSelectionne.getCol()) {
							grille[i][j].placePion(pionSelectionne);
						}
						grille[i][j].resetColor();
					}
				}

				pionSelectionne = null;
			}
		}
	}

}
