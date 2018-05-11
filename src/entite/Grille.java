package entite;

public class Grille {

	Case[][] grille = new Case[8][7];

	public Grille() {
	}

	public Case[][] getGrille() {
		return grille;
	}

	public void setGrille(Case[][] grille) {
		this.grille = grille;
	}

	public Grille deplacement(int x1, int y1, int x2, int y2) {
		return this;
	}

}
