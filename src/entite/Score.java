package entite;

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
	    this.setLayoutY(50);
	    this.setLayoutX(310); 
	    this.setFill(Color.BLUE);
	    this.setFont(new Font("Arial",50));
	    this.setText(0+" - "+0);
	    //this.setTextAlignment(TextAlignment.CENTER);
	}
}