package entite;


public class Heuristique {


	public double noteGrille(int[][][] grille, int joueur) {
		return  0;
	}
	
	public int score(int[][][] grille, int Joueur) {
		int cpt = 0;
		int j;
		if (Joueur == 0)
			j = 6;
		else
			j = 0;

		for (int i = 0; i < 7; i++) {
			if (grille[i][j][0] < 5 && Joueur == 0)
				cpt += grille[i][j][0];
			if (grille[i][j][0] > 4 && Joueur == 1)
				cpt += (grille[i][j][0] - 4);
		}
		return cpt;
	}

	public int scoreCache(int[][][] grille, int Joueur) {
		int cpt = 0;
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[i].length; j++) {
					for (int k = 1; k < grille[i][j].length; k++) {
						if (grille[i][j][k] < 5 && Joueur == 0 && j != 6)
							cpt += grille[i][j][k];
						if (grille[i][j][k] > 4 && Joueur == 1 && j != 0)
							cpt += (grille[i][j][k] - 4);
					}
			}
		}
		return cpt;
	}

	public int scoreMange(int[][][] grille, int Joueur) {
		int cpt = 0;
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[i].length; j++) {
					for (int k = 1; k < grille[i][j].length; k++) {
						if (grille[i][j][0] > 4 && grille[i][j][k] < 5 && Joueur == 1)
							cpt += grille[i][j][k];
						if (grille[i][j][0] < 5 && grille[i][j][k] > 4 && Joueur == 0)
							cpt += (grille[i][j][k] - 4);
					}
			}
		}
		return cpt;
	}

}