package entite;

import java.util.ArrayList;

public class IA {

	ArrayList<Grille3D> fils = new ArrayList<Grille3D>();
	Grille3D G;
	boolean extraire = false;

	public IA(Grille grille) {
		G = new Grille3D(grille);
	}
	
	public IA(Grille3D grille){
		G = grille;
	}

	public void solve(int joueur) {
		G.solve(1, 0);
		/*for (int i = 0; i < G.getGrille().length; i++) {
			for (int j = 0; j < G.getGrille()[i].length; j++) {
				if ((G.getGrille()[i][j][0] - 1) / 4 == joueur) {
					for(int k = 0; k < 2; k++){
						if(k == 0)
							extraire = false;
						else extraire = true;
					if (G.isJouable(i, j, i + 1, j + 1, joueur)) {
						 fils.add(G.deplacement(i, j, i + 1, j + 1, extraire));
					}
					if (G.isJouable(i, j, i, j + 1, joueur)) {
						fils.add(G.deplacement(i, j, i, j + 1, extraire));
					}
					if (G.isJouable(i, j, i - 1, j + 1, joueur)) {
						 fils.add(G.deplacement(i, j, i - 1, j + 1, extraire));
					}
					if (G.isJouable(i, j, i + 1, j, joueur)) {
						 fils.add(G.deplacement(i, j, i + 1, j, extraire));
					}
					if (G.isJouable(i, j, i + 1, j - 1, joueur)) {
						 fils.add(G.deplacement(i, j, i + 1, j - 1, extraire));
					}
					if (G.isJouable(i, j, i, j - 1, joueur)) {
						 fils.add(G.deplacement(i, j, i, j - 1, extraire));
					}
					if (G.isJouable(i, j, i - 1, j - 1, joueur)) {
						 fils.add(G.deplacement(i, j, i - 1, j - 1, extraire));
					}
					if (G.isJouable(i, j, i - 1, j, joueur)) {
						 fils.add(G.deplacement(i, j, i - 1, j, extraire));
					}
					}
				}
			}
		}
		
		for(int z = 0; z < fils.size(); z++){
			if(joueur == 0){
				joueur = 1;
			}else 
				joueur = 0;
			fils.get(z).
		}*/

	}

}
