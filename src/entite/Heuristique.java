package entite;

public class Heuristique {

	public static final int MAX_NOTE = Integer.MAX_VALUE;

	public static final int MIN_NOTE = Integer.MIN_VALUE;

	public int noteGrille(int[][][] grille, int joueur) {

		int score0 = score(grille, 0);
		int score1 = score(grille, 1);

		if (score1 >= 12)
			return MAX_NOTE;
		else if (score0 >= 12)
			return MIN_NOTE;

		return 2 * scoredistance(grille, joueur) + 5 * scoreCache(grille, joueur) + 10 * scoreMange(grille, joueur)
				+ 60 * score1;
	}

	public int scoredistance(int[][][] grille, int joueur) {
		int cpt = 0;

		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[0].length; j++) {

				if (joueur == 0 && grille[i][j][0] < 5 && grille[i][j][0] != 0) {

					if (j == 1)
						cpt += 1;
					else if (j == 2)
						cpt += 2;
					else if (j == 3)
						cpt += 3;
					else if (j == 4)
						cpt += 4;
					else if (j == 5)
						cpt += 5;
					cpt = cpt + grille[i][j][0];
				}
				if (joueur == 1 && grille[i][j][0] > 4 && grille[i][j][0] != 0) {

					if (j == 5)
						cpt += 1;
					else if (j == 4)
						cpt += 2;
					else if (j == 3)
						cpt += 3;
					else if (j == 2)
						cpt += 4;
					else if (j == 1)
						cpt += 5;
					cpt = cpt + (grille[i][j][0] - 4);
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