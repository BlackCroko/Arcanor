package entite;

public class Grille {

	Case[][] grille = new Case[8][7];

	int pointj1 = 0;
	int pointj2 = 0;

	public Grille() {
	}
	
	public Grille(Case[][] g){
		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g[i].length; j++) {
				Case temp = g[i][j];
				grille[i][j] = new Case(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight(), temp.getLigne(), temp.getCol());
				if(g[i][j].Contenu() != null){
					Pion pion = temp.Contenu();
					try {
						grille[i][j].placePion(pion.clone());
					} catch (CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					while(pion.getFils() != null){
						
					}
				}
				
				
			}
		}
	}

	public Case[][] getGrille() {
		return grille;
	}

	public void setGrille(Case[][] grille) {
		this.grille = grille;
	}

	public Grille deplacement(int x1, int y1, int x2, int y2, boolean extraire) {
		Grille G = new Grille(grille);
		Pion pion = G.getGrille()[x1][y1].Contenu();
		Case dest = G.getGrille()[x2][y2];
		if(extraire){
			G.getGrille()[x1][y1].placePion(pion.getFils());
			if (pion.getFils() != null) {
				pion.getFils().setVisible(true);
				pion.getFils().setLigne(x1);
				pion.getFils().setCol(y1);
			}
			pion.setFils(dest.Contenu());
			if (dest.Contenu() != null)
				dest.Contenu().setVisible(false);
		}
		
		pion.deplacement(G.getGrille()[x2][y2].getX() + G.getGrille()[x2][y2].getWidth() / 2, G.getGrille()[x2][y2].getY() + G.getGrille()[x2][y2].getWidth() / 2, extraire);
		
		pion.setLigne(x2);
		pion.setCol(y2);
		
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[i].length; j++) {
				if (grille[i][j].getLigne() == x1 && grille[i][j].getCol() == y1
						&& !extraire) {
					grille[i][j].supprPion();
				}
				if (grille[i][j].getLigne() == pion.getLigne()
						&& grille[i][j].getCol() == pion.getCol()) {
					grille[i][j].placePion(pion);
				}
				grille[i][j].resetColor();
			}
		}
		
		return G;
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
