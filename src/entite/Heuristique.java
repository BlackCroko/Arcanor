package entite;

public class Heuristique {

	public static final double MAX_NOTE = Double.MAX_VALUE;

	public static final double MIN_NOTE = Double.MIN_VALUE;

	public double noteGrille(int[][][] grille, int joueur) {
		return Math.random();
	}

	public double scoredistance(int[][][] grille, int joueur) {
		// TODO point en fonction de la distance a la ligne adverse
		// exemple a 1case tu marque 10 pts, a 2 cases 8 etc apres tu cherches pour
		// avoir des points equilibré ++ dernière ligne et regarder si chemin est libre
		// ou s'il faut faire des détours
		int cpt = 0;

		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[0].length; j++) {

				if (joueur == 0 && grille[i][j][0] < 5 && grille[i][j][0] != 0) {
					if (j == 1)
						cpt += 2;
					else if (j == 2)
						cpt += 4;
					else if (j == 3)
						cpt += 6;
					else if (j == 4)
						cpt += 8;
					else if (j == 5)
						cpt += 10;
					else if (j == 6)
						cpt += 12;
				}
				if (joueur == 1 && grille[i][j][0] > 4 && grille[i][j][0] != 0) {
					if (j == 5)
						cpt += 2;
					else if (j == 4)
						cpt += 4;
					else if (j == 3)
						cpt += 6;
					else if (j == 2)
						cpt += 8;
					else if (j == 1)
						cpt += 10;
					else if (j == 0)
						cpt += 12;
				}
			}
		}

		return cpt;
	}

	public int score(int[][][] grille, int Joueur) {
		int cpt = 0;
		int j;
		if (Joueur == 0)
			j = 6;
		else
			j = 0;

		for (int i = 0; i < grille.length; i++) {
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
					if (grille[i][j][0] < 5 && grille[i][j][k] < 5 && Joueur == 0 && j != 6)
						cpt += grille[i][j][k];
					if (grille[i][j][0] > 4 && grille[i][j][k] > 4 && Joueur == 1 && j != 0)
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