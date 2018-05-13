package entite;

import java.util.ArrayList;

public class IA {

	ArrayList<Grille> fils = new ArrayList<Grille>();
	Grille G = new Grille();

	public IA(Grille grille) {
		G = grille;
	}

	public void solve() {
		
		for (int k = 0; k < G.getGrille().length; k++) {
			System.out.println("+-+-+-+-+-+-+-+");
			for (int l = 0; l < G.getGrille()[k].length; l++) {
				if (G.getGrille()[k][l].Contenu() != null) {
					if (G.getGrille()[k][l].Contenu().getJoueur() == 1) {
						int x = G.getGrille()[k][l].Contenu().getLigne();
						int y = G.getGrille()[k][l].Contenu().getCol();
						System.out.println("    "+k+"    "+l);
						System.out.println("    "+x+"    "+y);
						for (int i = 0; i < G.getGrille().length; i++) {
							for (int j = 0; j < G.getGrille()[i].length; j++) {

								if (G.getGrille()[i][j].getLigne() == x + 1 && G.getGrille()[i][j].getCol() == y + 1) {
									if (G.getGrille()[i][j].isJouable(G.getGrille()[k][l].Contenu())){
										fils.add(G.deplacement(x, y, x + 1, y + 1, false));
									System.out.println("test1");
									}
								}
								if (G.getGrille()[i][j].getLigne() == x && G.getGrille()[i][j].getCol() == y + 1) {
									if (G.getGrille()[i][j].isJouable(G.getGrille()[k][l].Contenu()))
										fils.add(G.deplacement(x, y, x, y + 1, false));
								}
								if (G.getGrille()[i][j].getLigne() == x - 1 && G.getGrille()[i][j].getCol() == y + 1) {
									if (G.getGrille()[i][j].isJouable(G.getGrille()[k][l].Contenu()))
//										fils.add(G.deplacement(x, y, x - 1, y + 1, false));
										System.out.print("");
								}
								if (G.getGrille()[i][j].getLigne() == x + 1 && G.getGrille()[i][j].getCol() == y) {
									if (G.getGrille()[i][j].isJouable(G.getGrille()[k][l].Contenu()))
//										fils.add(G.deplacement(x, y, x + 1, y, false));
										System.out.print("");
								}
								if (G.getGrille()[i][j].getLigne() == x + 1 && G.getGrille()[i][j].getCol() == y - 1) {
									if (G.getGrille()[i][j].isJouable(G.getGrille()[k][l].Contenu()))
//										fils.add(G.deplacement(x, y, x + 1, y - 1, false));
									System.out.print("");
								}
								if (G.getGrille()[i][j].getLigne() == x && G.getGrille()[i][j].getCol() == y - 1) {
									if (G.getGrille()[i][j].isJouable(G.getGrille()[k][l].Contenu()))
//										fils.add(G.deplacement(x, y, x, y - 1, false));
										System.out.print("");
								}
								if (G.getGrille()[i][j].getLigne() == x - 1 && G.getGrille()[i][j].getCol() == y - 1) {
									if (G.getGrille()[i][j].isJouable(G.getGrille()[k][l].Contenu()))
										//fils.add(G.deplacement(x, y, x - 1, y - 1, false));
										System.out.print("");
								}
								if (G.getGrille()[i][j].getLigne() == x - 1 && G.getGrille()[i][j].getCol() == y) {
									if (G.getGrille()[i][j].isJouable(G.getGrille()[k][l].Contenu()))
//										fils.add(G.deplacement(x, y, x - 1, y, false));
										System.out.print("");
								}
							}
						}
					}
					System.out.print("|" + (G.getGrille()[k][l].Contenu().getJoueur() + 1));
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
