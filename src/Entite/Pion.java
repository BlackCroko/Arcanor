package Entite;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Pion extends Circle{
	
	boolean selected;
	/**numero du joueur associe*/
	int joueur;
	/**couleur courante du jeton*/
	Color cj;
	/**couleur pour joueur 1*/
	public static Color couleurJ1 = Color.SNOW;
	/**couleur pour joueur 2*/
	public static Color couleurJ2 = Color.DARKSLATEGRAY;
	/**couleur pour joueur 1 si jeton selectionne*/
	public static Color couleurJ1Selected = Color.GAINSBORO;
	/**couleur pour joueur 2 si jeton selectionne*/
	public static Color couleurJ2Selected = Color.FORESTGREEN;
	
	private Etat etat;
	private Etat stroke = Etat.stroke;
	
	private int ligne;
	private int col;

	public Pion(double startX, double startY, double taille, int _joueur, int ligne, int col) {
		super(startX, startY, taille);
	   /* this.setFill(Couleur.getCouleur());
	    this.setStroke(stroke.getCouleur());*/
	    joueur = _joueur;
	    selected = false;
	    getColorPion();
	    setFill(cj);
	    this.ligne = ligne;
	    this.col = col;
	  }
	   
	  /**active ou desactive la selection du jeton*/
	  public void switchSelected()
	  {
	    selected = !selected;
	    getColorPion();
	  }
	   
	  /**definit la bonne couleur pour le jeton en fonction du joueur et de son état sélectionné ou non
	  *@return la couleur du jeton*/
	  private Color getColorPion()
	  {
	    cj =  (selected? (joueur==0?couleurJ1Selected:couleurJ2Selected) : (joueur==0?couleurJ1:couleurJ2));
	    return cj;
	  }
	   
	  /**remplit le disque avec la couleur courante*/
	  public void colorPion()
	  {
	    setFill(cj);
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

	public Color getCj() {
		return cj;
	}

	public void setCj(Color cj) {
		this.cj = cj;
	}

	  
}