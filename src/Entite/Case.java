
/**
 * Classe de gestion des Cases 
 * @author Romain Thuillez
 */

package Entite;

import javafx.scene.shape.Rectangle;

public class Case extends Rectangle{
	
	private Etat etat = Etat.LIBRE;
	private Etat stroke = Etat.stroke;
	private int ligne;
	private int col;
	private Pion pionPlace = null;

	public Case(double startX, double startY, double endX, double endY, int x, int y) {
		super(startX, startY, endX, endY);
	    this.setFill(etat.getCouleur());
	    this.setStroke(stroke.getCouleur());
	    this.ligne = x;
	    this.col = y;
	}

	public Etat getEtat() {
		return etat;
	}

	public void changeEtat() {
		if(this.etat == Etat.LIBRE)
			this.etat = Etat.J1;
		else
			this.etat = Etat.LIBRE;
		setFill(etat.getCouleur());
	}
	
	public void ispossible() {
		if(this.etat == Etat.possible)
			this.etat = Etat.LIBRE;
		else
			this.etat = Etat.possible;
		setFill(etat.getCouleur());
	}
	
	public void isimpossible() {
		if(this.etat == Etat.impossible)
			this.etat = Etat.LIBRE;
		else
			this.etat = Etat.impossible;
		setFill(etat.getCouleur());
	}
	
	public void resetColor(){
		this.etat = Etat.LIBRE;
		setFill(etat.getCouleur());
	}

	public int getLigne() {
		return ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public void placePion(Pion pion) {
		this.pionPlace = pion;
	}	
	
	public void supprPion(){
		this.pionPlace = null;
	}

	public boolean isJouable(Pion pion){
		
		if(pionPlace == null || ((pion.getTaille() == pionPlace.getTaille()-1) && (pion.getJoueur() != pionPlace.getJoueur())))
		return true;
		else return false;
	}
	

	

}
