package entite;

import javax.swing.ImageIcon;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Choix extends ImageView{
	
	private Image img1;
	private Image img1S;
	private Image img2;
	private Image img2S;
	private int id;
	private Color Libre = Color.GREY;
	private Color select = Color.DARKGOLDENROD;
	private boolean selected = false;

	public Choix(int id, int tailleCase) {
		this.id = id;
		init();
		if(id == 0){
			selected = true;
			this.setImage(img1S);
			this.setX(75);
			this.setY(tailleCase*8);
		}
		else{
			this.setImage(img2);
			this.setX(tailleCase*6-tailleCase/2);
			this.setY(tailleCase*8);
		}
	}
	
	public void switchColor(){
		if(selected){
			selected = false;
			if(id == 0)
			this.setImage(img1);
			else
				this.setImage(img2);
		}
		else{
			selected = true;
			if(id == 0)
				this.setImage(img1S);
			else
				this.setImage(img2S);
		}
	}

	public boolean isSelected() {
		return selected;
	}
	
	public void init(){
		img1 = new Image("Choix1.png");
		img1S = new Image("Choix1S.png");
		img2 = new Image("Choix2.png");
		img2S = new Image("Choix2S.png");
	}
	
}
