package entite;

import java.util.ArrayList;


public class IA {

	ArrayList<Grille3D> fils = new ArrayList<Grille3D>();
	Grille3D G;
	boolean extraire = false;
	Heuristique heuristique = new Heuristique();
	
	private int profondeur = 2;

	public IA(Grille grille) {
		G = new Grille3D(grille);
	}
	
	public IA(Grille3D grille){
		G = grille;
	}

	public CoupJoue solve(int joueur) {
		Grille3D deplacement;
		double max = Heuristique.MIN_NOTE;
		ArrayList<Grille3D> fils = G.generatePossibilite(joueur);
		deplacement = fils.get(0);
		for(int i=1; i < fils.size() ; i++){
			double valeur = this.alphabeta(fils.get(i), joueur, profondeur);
			if(max < valeur){
				max = valeur;
				deplacement = fils.get(i);
			}
		}
		return deplacement.getCoup();
	}
	
	private double alphabeta(Grille3D grille, int joueur, int profondeur){
		double alpha =Heuristique.MIN_NOTE;
		double beta=Heuristique.MAX_NOTE;
		return this.min(grille, joueur, profondeur, alpha, beta);
	}

	/**
	 * Applique la partie min, de minmax
	 */
	private double min(Grille3D grille, int joueur,  int profondeur, double alpha, double beta){
		if(profondeur != 0){
			double valeurDeJeu = Heuristique.MAX_NOTE;
			ArrayList<Grille3D> filsmin = new ArrayList<Grille3D>();
			filsmin = grille.generatePossibilite(joueur);
			for(int i=1; i < filsmin.size() ; i++){
						valeurDeJeu = Math.min(valeurDeJeu, this.max(filsmin.get(i), joueur, profondeur-1, alpha, beta));
						if(alpha >= valeurDeJeu){
							return valeurDeJeu; // Coupure alpha
						}
						
		               beta = Math.min(beta, valeurDeJeu);
			}
			return valeurDeJeu;
		}else{
			return this.heuristique.noteGrille(grille.getGrille(), joueur );
		}
	}

	/**
	 * Applique la partie max de minmax
	 */
	private double max(Grille3D grille, int joueur, int profondeur, double alpha, double beta){
		if(profondeur != 0){
			double valeurDeJeu = Heuristique.MIN_NOTE;
			ArrayList<Grille3D> filsmax = new ArrayList<Grille3D>();
			filsmax = grille.generatePossibilite(joueur);
			for(int i=0; i < filsmax.size(); i++){
						valeurDeJeu = Math.max(valeurDeJeu, this.min(filsmax.get(i), joueur, profondeur-1, alpha, beta));
						if(valeurDeJeu >= beta){
							return valeurDeJeu; // Coupure beta
						}
						alpha = Math.max(alpha	, valeurDeJeu);
			}
			return valeurDeJeu;
		}else{
			return this.heuristique.noteGrille(grille.getGrille(), joueur);
		}
	}

}
