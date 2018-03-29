package Entite;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Choix extends Rectangle{
	
	int id;
	Color Libre = Color.GREY;
	Color select = Color.DARKGOLDENROD;
	boolean selected = false;

	public Choix(int id, int tailleCase) {
		super(100, tailleCase*8, 150, 50);
		if(id == 0){
			selected = true;
			this.setX(100);
			this.setFill(select);
		}
		else{
			this.setX(tailleCase*6);
			this.setFill(Libre);
		}
	}
	
	public void switchColor(){
		if(selected){
			this.setFill(Libre);
			selected = false;
		}
		else{
			this.setFill(select);
			selected = true;
		}
	}

	public boolean isSelected() {
		return selected;
	}
	
	
}
