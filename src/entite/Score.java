package entite;

import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Score extends Group{
	int score;
	private Color couleur = Color.BLUE;
	Text joueur1=new Text("Blanc ");
	Text joueur2=new Text("Noir ");
	Text total=new Text();
	Line trait = new Line(180,48,290,48);

	public Score() {
		
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetX(5);
		dropShadow.setOffsetY(5);
		
	    total.setLayoutY(40);
	    total.setLayoutX(172); 
	    total.setFill(couleur);
	    total.setFont(new Font("Arial",50));
	    total.setText(joueur1.getText()+"0 - 0 "+joueur2.getText());
//	    
	   // Line trait = new Line(440,48,500,48);
	    trait.setStroke(couleur);
	    trait.setStrokeWidth(3);
	    this.getChildren().add(total);
	    this.getChildren().add(trait);
	}
	
	public void setScore(int a, int b) {
		total.setText(joueur1.getText()+""+a+" - "+b+" "+joueur2.getText());
	    joueur1.setFill(Color.RED);
	}
	
	public void switchTrait(int j){
		if(j == 0){
		trait.setStartX(180);
		trait.setEndX(290);
		}
		else {
			trait.setStartX(440);
			trait.setEndX(500);
		}
	}
	
}