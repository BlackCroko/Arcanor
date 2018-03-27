package Entite;

public class Plateau {
	
	Pion[][] grille = new Pion[7][8]; 
	
	public Plateau(){
		System.out.print(grille.length+" and "+grille[0].length);
	}

}
