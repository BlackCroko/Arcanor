package entite;

public class Heuristique {
	
	public static final double MAX_NOTE = Double.MAX_VALUE;
	
	public static final double MIN_NOTE = Double.MIN_VALUE;

	public double noteGrille(int[][][] grille, int joueur) {
		return Math.random();
	}
	
	public double scoredistance(int[][][] grille, int joueur){
		//TODO point en fonction de la distance a la ligne adverse
		// exemple a 1case tu marque 10 pts, a 2 cases 8 etc apres tu cherches pour avoir des points equilibré
		
		return 0;
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