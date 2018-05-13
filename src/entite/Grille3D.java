package entite;

public class Grille3D {

	private int[][][] grille = new int[8][7][4];

	public Grille3D(Grille G) {
		Case[][] g = G.getGrille();
		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g[i].length; j++) {
				int k = 0;
				if (g[i][j].Contenu() != null) {
					Pion pion = g[i][j].Contenu();
						grille[i][j][k] = pion.getJoueur()*4+pion.getPoint();
						System.out.print(grille[i][j][k]);
					while(pion.getFils() != null){
						k++;
						pion = pion.getFils();
						grille[i][j][k] = pion.getJoueur()*4+pion.getPoint();
						System.out.print(grille[i][j][k]);
					}
				}
			}
			System.out.println("");
		}
		descente(0, 0);
	}
	
	public void deplacement(int x1, int y1, int x2, int y2, boolean extraire) {
		if(extraire || grille[x2][y2][0] != 0){
			descente(x2, y2);
			grille[x2][y2][0] = grille[x1][y1][0];
			remonter(x1, y1);
		}
		else {
			for(int i = 0; i < 4; i++){
				grille[x2][y2][i] = grille[x1][y1][i];
				grille[x1][y1][i] = 0;
			}
		}
	}
	
	public void remonter(int x, int y){	
		for(int i = 0; i < 3; i++){
			grille[x][y][i] = grille[x][y][i+1];
		}
	}
	
	public void descente(int x, int y){
		System.out.println("");		
		for(int i = 3; i > 0; i--){
			grille[x][y][i] = grille[x][y][i-1];
			System.out.println(grille[x][y][i]);
		}
		System.out.println(grille[x][y][0]);
	}
	

}
