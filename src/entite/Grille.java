package entite;

public class Grille {

	Case[][] grille = new Case[8][7];

	int pointj1 = 0;
	int pointj2 = 0;

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
	
	public void majPoint() {
		pointj1 = 0;
		pointj2 = 0;
		for(int i = 0; i < grille.length; i++){
			if(grille[i][grille[0].length - 1].Contenu() != null)
			if (grille[i][grille[0].length - 1].Contenu().getJoueur() == 0) {
				pointj2 += grille[i][grille[0].length - 1].Contenu().getPoint();
				grille[i][grille[0].length - 1].Contenu().setFin(true);
				// Victoire(troupe);
			}
			if(grille[i][0].Contenu() != null)
			if (grille[i][0].Contenu().getJoueur() == 1) {
				pointj1 += grille[i][0].Contenu().getPoint();
				grille[i][0].Contenu().setFin(true);
				// Victoire(troupe);
			}
		}
	}
	
	
	
	
	
	

	public int getPointj1() {
		return pointj1;
	}

	public void setPoint(int joueur, int point) {
		if(joueur == 0)
			this.pointj1 += point;
		else
			this.pointj2 += point;
	}

	public int getPointj2() {
		return pointj2;
	}
	
	

}
