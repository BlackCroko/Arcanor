package entite;

import java.util.ArrayList;

public class IA {
	

	Case[][] grille = new Case[8][7];
	ArrayList<Grille> fils = new ArrayList<Grille>();
	
	public IA(Case[][] grille){
		this.grille = grille;
		for (int k = 0; k < grille.length; k++) {
			System.out.println("+-+-+-+-+-+-+-+");
			for (int l = 0; l < grille[k].length; l++) {
				if (grille[k][l].Contenu() != null) {
					if (grille[k][l].Contenu().getJoueur() == 1) {
						int x = grille[k][l].Contenu().getLigne();
						int y = grille[k][l].Contenu().getCol();
						for (int i = 0; i < grille.length; i++) {
							for (int j = 0; j < grille[i].length; j++) {

								if (grille[i][j].getLigne() == x + 1 && grille[i][j].getCol() == y + 1) {
									if (grille[i][j].isJouable(grille[k][l].Contenu()))
										System.out.print("coucou");
								}
								if (grille[i][j].getLigne() == x && grille[i][j].getCol() == y + 1) {
									if (grille[i][j].isJouable(grille[k][l].Contenu()))
										System.out.print("coucou");
								}
								if (grille[i][j].getLigne() == x - 1 && grille[i][j].getCol() == y + 1) {
									if (grille[i][j].isJouable(grille[k][l].Contenu()))
										System.out.print("coucou");
								}
								if (grille[i][j].getLigne() == x + 1 && grille[i][j].getCol() == y) {
									if (grille[i][j].isJouable(grille[k][l].Contenu()))
										System.out.print("coucou");
								}
								if (grille[i][j].getLigne() == x + 1 && grille[i][j].getCol() == y - 1) {
									if (grille[i][j].isJouable(grille[k][l].Contenu()))
										System.out.print("coucou");
								}
								if (grille[i][j].getLigne() == x && grille[i][j].getCol() == y - 1) {
									if (grille[i][j].isJouable(grille[k][l].Contenu()))
										System.out.print("coucou");
								}
								if (grille[i][j].getLigne() == x - 1 && grille[i][j].getCol() == y - 1) {
									if (grille[i][j].isJouable(grille[k][l].Contenu()))
										System.out.print("coucou");
								}
								if (grille[i][j].getLigne() == x - 1 && grille[i][j].getCol() == y) {
									if (grille[i][j].isJouable(grille[k][l].Contenu()))
										System.out.print("coucou");
								}
							}
						}
					}
					System.out.print("|" + (grille[k][l].Contenu().getJoueur() + 1));
				} else
					System.out.print("|0");
			}
			System.out.println("|");
		}
		System.out.println("+-+-+-+-+-+-+-+");
		System.out.println();
		System.out.println();
	}

}
