package entite;

import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Score extends Text{
	int score;

	public void setScore(int a, int b) {
		this.setText(a+" - "+b);
	}

	public Score() {
		
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetX(5);
		dropShadow.setOffsetY(5);
		
	    this.setLayoutY(40);
	    this.setLayoutX(310); 
	    this.setFill(Color.BLUE);
	    this.setFont(new Font("Arial",50));
	    this.setText(0+" - "+0);
	    this.setEffect(dropShadow);
	    //this.setTextAlignment(TextAlignment.CENTER);
	}
}