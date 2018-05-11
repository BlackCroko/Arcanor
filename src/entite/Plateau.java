package entite;

import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;

public class Plateau implements EventHandler<MouseEvent> {

	int[] base = { 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4 };
	boolean[] possible = new boolean[9];
	Pion[] joueur1 = new Pion[12];
	Pion[] joueur2 = new Pion[12];
	Grille grille = new Grille();
	int decalage;
	int tailleCase;
	int decalageTrait;
	Pion pionSelectionne;
	Group total = new Group();
	Group troupe = new Group();
	int point1 = 0;
	int point2 = 0;
	Score score = new Score();
	Choix C1;
	Choix C2;

	int joueurActuel = 0;
	
	private IA ordi;

	public Plateau(int decalage, int tailleCase, int decalageTrait) {
		this.decalage = decalage;
		this.tailleCase = tailleCase;
		this.decalageTrait = decalageTrait;
	}

	public Group dessinEnvironnement() {

		// dessin des lignes
		for (int i = 0; i < grille.getGrille().length; i++) {
			for (int j = 0; j < grille.getGrille()[i].length; j++) {
				grille.getGrille()[i][j] = new Case(decalage + tailleCase * i, decalage + decalageTrait + tailleCase * j,
						tailleCase, tailleCase, i, j);
				troupe.getChildren().add(grille.getGrille()[i][j]);
				grille.getGrille()[i][j].setOnMouseClicked(this);

			}
		}

		initPion(troupe);

		C1 = new Choix(0, tailleCase);
		C2 = new Choix(1, tailleCase);
		troupe.getChildren().add(C1);
		troupe.getChildren().add(C2);
		// C1.setOnMouseMoved(new EventHandler<MouseEvent>(){
		// public void handle(MouseEvent me){
		// C1.setFill(Color.AQUA);
		// }
		// });
		// C1.setOnMouseExited(new EventHandler<MouseEvent>(){
		// public void handle(MouseEvent me){
		// C1.setFill(Color.GREY);
		// }
		// });
		C1.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				if (!C1.isSelected()) {
					C2.switchColor();
					C1.switchColor();
				}
			}
		});
		// C2.setOnMouseMoved(new EventHandler<MouseEvent>(){
		// public void handle(MouseEvent me){
		// C2.setFill(Color.AQUA);
		// }
		// });
		// C2.setOnMouseExited(new EventHandler<MouseEvent>(){
		// public void handle(MouseEvent me){
		// C2.setFill(Color.GREY);
		// }
		// });
		C2.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				if (!C2.isSelected()) {
					C2.switchColor();
					C1.switchColor();
				}
			}
		});
		/*
		 * Pion pion = null; int rand = 1; for (int i = 0; i < 8; i++) { for(int
		 * j = 0; j< 2; j++){ rand =4 - i % 4; int rand2 = (int) (Math.random()
		 * * 2); pion = new Pion(decalage + tailleCase * i + tailleCase / 2,
		 * decalage + decalageTrait + tailleCase * j*6 + tailleCase / 2,
		 * tailleCase/2, rand, rand2, i, j*6); ajoutPion(pion, troupe); } }
		 */
		troupe.getChildren().add(score);
		total.getChildren().add(troupe);
		return total;

	}

	public void initPion(Group troupe) {
		Pion pion = null;
		Pion[] J = new Pion[12];
		int rand;
		for (int j = 0; j < 2; j++) {
			for (int l = 1; l < 9; l++)
				possible[l] = false;
			for (int k = 0; k < 4; k++) {
				for (int i = 0; i < 3; i++) {
					rand = (int) (Math.random() * 7) + 1;
					if (k == 1 || k == 3) {
						pion = new Pion(decalage + tailleCase * J[3 * k + i - 3].getLigne() + tailleCase / 2,
								decalage + decalageTrait + tailleCase * j * 6 + tailleCase / 2, tailleCase / 2,
								base[3 * k + i], j, J[3 * k + i - 3].getLigne(), j * 6);
						J[3 * k + i - 3].setFils(pion);
						pion.setVisible(false);
					} else {
						while (possible[rand]) {
							rand = (int) (Math.random() * 7) + 1;

						}
						pion = new Pion(decalage + tailleCase * rand + tailleCase / 2,
								decalage + decalageTrait + tailleCase * j * 6 + tailleCase / 2, tailleCase / 2,
								base[3 * k + i], j, rand, j * 6);
						grille.getGrille()[rand][j * 6].placePion(pion);
						possible[rand] = true;
					}
					J[3 * k + i] = pion;
					pion.setOnMouseClicked(this);
					troupe.getChildren().add(pion);
				}
			}

		}
	}

	public void ajoutPion(Pion pion, Group troupe) {
		pion.setOnMouseClicked(this);
		grille.getGrille()[pion.getLigne()][pion.getCol()].placePion(pion);
		troupe.getChildren().add(pion);
	}

	public void majPoint(Pion p) {
		if (p.joueur == 0) {
			if (p.getCol() == grille.getGrille()[0].length - 1) {
				point1 += p.getPoint();
				p.setFin(true);
				// Victoire(troupe);
			}
		} else if (p.joueur == 1) {
			if (p.getCol() == 0) {
				point2 += p.getPoint();
				p.setFin(true);
				// Victoire(troupe);
			}
		}
		score.setScore(point1, point2);
	}

	public void handle(MouseEvent me) {

		Object o = me.getSource();
		if (o instanceof Pion) {
			Pion d = (Pion) o;

			// System.out.println("clic en " + d.getLigne() + "," + d.getCol());
			// si on selectionne un nouveau pion ou deselectionne le pion deja
			// selectionne
			if ((pionSelectionne == null || pionSelectionne == d) && !d.isFin() && d.getJoueur() == joueurActuel) {
				d.switchSelected();
				d.colorPion();
				if (pionSelectionne == null) {
					pionSelectionne = d;
					int x = pionSelectionne.getLigne();
					int y = pionSelectionne.getCol();
					for (int i = 0; i < grille.getGrille().length; i++) {
						for (int j = 0; j < grille.getGrille()[i].length; j++) {
							if (grille.getGrille()[i][j].getLigne() == x + 1 && grille.getGrille()[i][j].getCol() == y + 1) {
								if (grille.getGrille()[i][j].isJouable(pionSelectionne))
									grille.getGrille()[i][j].ispossible();
								else
									grille.getGrille()[i][j].isimpossible();
							}
							if (grille.getGrille()[i][j].getLigne() == x && grille.getGrille()[i][j].getCol() == y + 1) {
								if (grille.getGrille()[i][j].isJouable(pionSelectionne))
									grille.getGrille()[i][j].ispossible();
								else
									grille.getGrille()[i][j].isimpossible();
							}
							if (grille.getGrille()[i][j].getLigne() == x - 1 && grille.getGrille()[i][j].getCol() == y + 1) {
								if (grille.getGrille()[i][j].isJouable(pionSelectionne))
									grille.getGrille()[i][j].ispossible();
								else
									grille.getGrille()[i][j].isimpossible();
							}
							if (grille.getGrille()[i][j].getLigne() == x + 1 && grille.getGrille()[i][j].getCol() == y) {
								if (grille.getGrille()[i][j].isJouable(pionSelectionne))
									grille.getGrille()[i][j].ispossible();
								else
									grille.getGrille()[i][j].isimpossible();
							}
							if (grille.getGrille()[i][j].getLigne() == x + 1 && grille.getGrille()[i][j].getCol() == y - 1) {
								if (grille.getGrille()[i][j].isJouable(pionSelectionne))
									grille.getGrille()[i][j].ispossible();
								else
									grille.getGrille()[i][j].isimpossible();

							}
							if (grille.getGrille()[i][j].getLigne() == x && grille.getGrille()[i][j].getCol() == y - 1) {
								if (grille.getGrille()[i][j].isJouable(pionSelectionne))
									grille.getGrille()[i][j].ispossible();
								else
									grille.getGrille()[i][j].isimpossible();
							}
							if (grille.getGrille()[i][j].getLigne() == x - 1 && grille.getGrille()[i][j].getCol() == y - 1) {
								if (grille.getGrille()[i][j].isJouable(pionSelectionne))
									grille.getGrille()[i][j].ispossible();
								else
									grille.getGrille()[i][j].isimpossible();
							}
							if (grille.getGrille()[i][j].getLigne() == x - 1 && grille.getGrille()[i][j].getCol() == y) {
								if (grille.getGrille()[i][j].isJouable(pionSelectionne))
									grille.getGrille()[i][j].ispossible();
								else
									grille.getGrille()[i][j].isimpossible();
							}
						}
					}
				} else {
					pionSelectionne = null;
					for (int i = 0; i < grille.getGrille().length; i++) {
						for (int j = 0; j < grille.getGrille()[i].length; j++) {
							grille.getGrille()[i][j].resetColor();
						}
					}
				}
			}
		} else if (o instanceof Case && pionSelectionne != null) {
			Case r = (Case) o;
			boolean suppr = false;
			if (r.getEtat() == Etat.possible) {
				int x = pionSelectionne.getLigne();
				int y = pionSelectionne.getCol();
				if (r.Contenu() != null || C2.isSelected()) {
					grille.getGrille()[x][y].placePion(pionSelectionne.getFils());
					if (pionSelectionne.getFils() != null) {
						pionSelectionne.getFils().setVisible(true);
						pionSelectionne.getFils().setLigne(x);
						pionSelectionne.getFils().setCol(y);
					}
					pionSelectionne.setFils(r.Contenu());
					if (r.Contenu() != null)
						r.Contenu().setVisible(false);
				} else
					suppr = true;
				// System.out.println(r.Contenu());
				// le nouveau centre du jeton sera au centre du rectangle
				// sélectionné
				double newX = r.getX() + tailleCase / 2;
				double newY = r.getY() + tailleCase / 2;
				pionSelectionne.switchSelected();

				pionSelectionne.deplacement(r.getLigne(), r.getCol(), newX, newY);

				pionSelectionne.setLigne(r.getLigne());
				pionSelectionne.setCol(r.getCol());
				for (int i = 0; i < grille.getGrille().length; i++) {
					for (int j = 0; j < grille.getGrille()[i].length; j++) {
						if (grille.getGrille()[i][j].getLigne() == x && grille.getGrille()[i][j].getCol() == y && suppr) {
							grille.getGrille()[i][j].supprPion();
						}
						if (grille.getGrille()[i][j].getLigne() == pionSelectionne.getLigne()
								&& grille.getGrille()[i][j].getCol() == pionSelectionne.getCol()) {
							grille.getGrille()[i][j].placePion(pionSelectionne);
						}
						grille.getGrille()[i][j].resetColor();
					}
				}

				majPoint(pionSelectionne);
				Victoire(troupe);
				pionSelectionne = null;
				switchJoueur();
			}
		}

	}

	public void switchJoueur() {
		if (joueurActuel == 0)
			joueurActuel = 1;
		else
			joueurActuel = 0;
		score.switchTrait(joueurActuel);

		if (joueurActuel == 1) {
			ordi = new IA(grille);
		}
	}

	public void Victoire(Group troupe) {

		if ((point1 >= 12) || (point2 >= 12)) {
			for (int i = 0; i < 30; i++) {
				Circle circle = new Circle(150, Color.web("white", 0.05));
				circle.setStrokeType(StrokeType.OUTSIDE);
				circle.setStroke(Color.web("white", 0.06));
				circle.setStrokeWidth(4);
				// troupe.getChildren().add(circle);
			}

			troupe.setEffect(new BoxBlur(10, 10, 2));

			Timeline timeline = new Timeline();
			for (Node circle : troupe.getChildren()) {
				circle.setVisible(true);
				timeline.getKeyFrames()
						.addAll(new KeyFrame(Duration.ZERO, // set start
															// position at 0
								new KeyValue(circle.translateXProperty(), circle.getLayoutX()),
								new KeyValue(circle.translateYProperty(), circle.getLayoutY())),
								new KeyFrame(new Duration(30000), // set end
																	// position
																	// at 40s
										new KeyValue(circle.translateXProperty(), Math.random() * 800),
										new KeyValue(circle.translateYProperty(), Math.random() * 600)));
			}

			// play 40s of animation
			timeline.play();
			Choix C = new Choix(0, tailleCase);
			total.getChildren().add(C);
			C.setOnMouseClicked(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent me) {
					if (timeline.getStatus() == Status.RUNNING)
						timeline.pause();
					else if (timeline.getStatus() == Status.PAUSED)

						timeline.play();
					timeline.setAutoReverse(true);
				}
			});
			// timeline.setOnFinished(timeline.play());

		}
	}
}
