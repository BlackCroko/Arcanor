package Entity;

import javafx.scene.paint.Color;

public enum Etat {LIBRE(Color.BURLYWOOD), J1(Color.BLUE), J2(Color.WHITE), possible(Color.LIGHTGREEN), impossible(Color.LIGHTCORAL), stroke(Color.BLACK);
	  Color couleur;
	  Etat(Color _couleur){couleur = _couleur;}
	  public Color getCouleur(){return couleur;}
	}