package entite;

public class Grille3D{

	private int[][][] grille = new int[8][7][4];
	
	public Grille3D(){
		
	}

	public Grille3D(Grille G) {
		Case[][] g = G.getGrille();
		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g[i].length; j++) {
				int k = 0;
				if (g[i][j].Contenu() != null) {
					Pion pion = g[i][j].Contenu();
					grille[i][j][k] = pion.getJoueur() * 4 + pion.getPoint();
					while (pion.getFils() != null) {
						k++;
						pion = pion.getFils();
						grille[i][j][k] = pion.getJoueur() * 4 + pion.getPoint();
					}
				}
			}
		}
	}

	public void affichage() {
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[i].length; j++) {
				for (int k = 0; k < grille[i][j].length; k++) {
					if (grille[i][j][k] != 0) {
						System.out.print(grille[i][j][k]);
					}
				}
			}
			System.out.println("");
		}
	}
	
	public void affichage2D(){
		for (int i = 0; i < grille[0].length; i++) {
			System.out.println("+-+-+-+-+-+-+-+-+");
			for (int j = 0; j < grille.length; j++) {
					System.out.print("|" + (grille[j][i][0]));
				}
			System.out.println("|");
			}
		System.out.println("+-+-+-+-+-+-+-+-+");
		System.out.println();
		System.out.println();
	}

	public Grille3D deplacement(int x1, int y1, int x2, int y2, boolean extraire) {
        Grille3D G = clone();
        int[][][] g = G.getGrille();
        if (extraire || g[x2][y2][0] != 0) {
            G.descente(x2, y2);
            g[x2][y2][0] = g[x1][y1][0];
            G.remonter(x1, y1);
        } else {
            for (int i = 0; i < 4; i++) {
                g[x2][y2][i] = g[x1][y1][i];
                g[x1][y1][i] = 0;
            }
        }
        return G;
    }

	public void remonter(int x, int y) {
		for (int i = 0; i < 3; i++) {
			grille[x][y][i] = grille[x][y][i + 1];
		}
	}

	public void descente(int x, int y) {
		System.out.println("");
		for (int i = 3; i > 0; i--) {
			grille[x][y][i] = grille[x][y][i - 1];
		}
	}

	public int[][][] getGrille() {
		return grille;
	}
	
	

	public void setGrille(int[][][] grille) {
		this.grille = grille;
	}

	public int score(int Joueur) {
		int cpt = 0;
		int i;
		if (Joueur == 0)
			i = 7;
		else
			i = 0;

		for (int j = 0; j < 8; j++) {
			if (grille[i][j][0] < 5 && Joueur == 0)
				cpt += grille[i][j][0];
			if (grille[i][j][0] > 4 && Joueur == 1)
				cpt += (grille[i][j][0] - 4);
		}
		return cpt;
	}

	public boolean isJouable(int x1, int y1, int x2, int y2, int Joueur) {
		if ((x2 < 0 || x2 >= 8) || (y2 < 0 || y2 >= 7))
			return false;
		if (grille[x2][y2][0] == 0 || (Joueur == 0 && grille[x2][y2][0] - 4 == grille[x1][y1][0] + 1)
				|| (Joueur == 1 && grille[x2][y2][0] + 1 == grille[x1][y1][0] - 4))
			return true;
		else
			return false;
	}
	
	public Grille3D clone(){
        Grille3D G = new Grille3D();
        int[][][] g = new int[8][7][4];
		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g[i].length; j++) {
				for(int k = 0; k < g[i][j].length; k++){
					g[i][j][k] = grille[i][j][k];
				}
				
			}
		}
		G.setGrille(g);
        return G;
    }

}
