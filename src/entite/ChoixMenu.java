package entite;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChoixMenu extends Group implements EventHandler<MouseEvent>{
	
	private int nbJoueur;
	private Image joueur;
	private ImageView imgv = new ImageView();
	private ImageView imgv2 = new ImageView();
	
	public ChoixMenu(int x, int y, int width, int height, int nbJoueur){
		this.nbJoueur = nbJoueur;
		init();
		if(nbJoueur == 1){
		imgv.setImage(joueur);
		imgv.setX(x+width/4);
		imgv.setY(y+height/4);
		imgv.setFitWidth(width/2);
		imgv.setFitHeight(height/2);
		}
		else {
			imgv.setImage(joueur);
			imgv.setX(x);
			imgv.setY(y+height/4);
			imgv.setFitWidth(width/2);
			imgv.setFitHeight(height/2);
			imgv2.setImage(joueur);
			imgv2.setX(x+width/2);
			imgv2.setY(y+height/4);
			imgv2.setFitWidth(width/2);
			imgv2.setFitHeight(height/2);
		}
		
		Rectangle r = new Rectangle(x, y, width, height);
		r.setArcWidth(15);
		r.setArcHeight(15);
		
		r.setFill(Color.TRANSPARENT);
		r.setStroke(Color.BLACK);


		this.getChildren().add(r);
		this.getChildren().add(imgv);
		this.getChildren().add(imgv2);
		
		this.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				r.setStroke(Color.RED);
				
			}
		});
		
		this.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				r.setStroke(Color.BLACK);
			}
		});
	}
	
	public void init(){
		if(nbJoueur == 1){
			joueur = new Image("1joueur.png");
		}
		else if(nbJoueur == 2){
			joueur = new Image("1joueur.png");
		}
	}

	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

}
