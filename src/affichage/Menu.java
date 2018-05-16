package affichage;

import entite.Case;
import entite.Choix;
import entite.ChoixMenu;
import entite.Pion;
import entite.Plateau;
import entite.Score;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Menu extends Group implements EventHandler<MouseEvent> {

	int[] base = { 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4 };
	boolean[] possible = new boolean[9];
	Pion[] joueur1 = new Pion[12];
	Pion[] joueur2 = new Pion[12];
	Case[][] grille = new Case[8][7];
	int decalage;
	int tailleCase;
	int decalageTrait;
	Pion pionSelectionne;
	int point1 = 0;
	int point2 = 0;
	Score score = new Score();
	Choix C1;
	Choix C2;

	// Implementing Nodes for GridPane
	Label lblUserName = new Label("Username");
	final TextField txtUserName = new TextField();
	Label lblPassword = new Label("Password");
	final PasswordField pf = new PasswordField();
	Button btnLogin = new Button("Login");
	final Label lblMessage = new Label();

	String user = "JavaFX2";
	String pw = "password";
	String checkUser, checkPw;

	public Menu(int decalage, int tailleCase, int decalageTrait) {
		this.decalage = decalage;
		this.tailleCase = tailleCase;
		this.decalageTrait = decalageTrait;

		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(10, 50, 500, 222));

		// Adding HBox
		HBox hb = new HBox();
		hb.setPadding(new Insets(20, 20, 50, 70));

		ChoixMenu M1 = new ChoixMenu(100, 200, 200, 300, 1);
		ChoixMenu M2 = new ChoixMenu(430, 200, 200, 300, 2);

		/*
		 * //Reflection for gridPane Reflection r = new Reflection();
		 * r.setFraction(0.7f); gridPane.setEffect(r);
		 */

		// DropShadow effect
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetX(5);
		dropShadow.setOffsetY(5);

		// Adding text and DropShadow effect to it
		Text text = new Text("Arcanor");
		text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
		text.setEffect(dropShadow);

		// Adding text to HBox
		hb.getChildren().add(text);

		// Add ID's to Nodes
		bp.setId("bp");
		text.setId("text");

		// Action for btnLogin
		M1.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				generatePlateau();
			}
		});

		M2.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				generatePlateau();
			}
		});

		// Add HBox and GridPane layout to BorderPane Layout
		bp.setTop(hb);
		this.getChildren().add(bp);
		this.getChildren().add(M1);
		this.getChildren().add(M2);

		/*
		 * C1 = new Choix(0, tailleCase); C2 = new Choix(1, tailleCase);
		 * this.getChildren().add(C1); this.getChildren().add(C2);
		 * 
		 * C1.setOnMouseClicked(new EventHandler<MouseEvent>(){ public void
		 * handle(MouseEvent me){ generatePlateau(); } });
		 */
	}

	public void changJoueur() {
		/*
		 * Text text = new Text("Tour du joueur 1"); DropShadow dropShadow = new
		 * DropShadow(); dropShadow.setOffsetX(5); dropShadow.setOffsetY(5);
		 * 
		 * text.setLayoutY(300); text.setLayoutX(-100); text.setFill(Color.BLUE);
		 * text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
		 * text.setEffect(dropShadow); this.getChildren().add(text);
		 * 
		 * int tps = 3000; Timeline timeline = new Timeline(); timeline.getKeyFrames()
		 * .addAll(new KeyFrame(new Duration(tps), new
		 * KeyValue(text.translateXProperty(), 800))); timeline.setCycleCount(3);
		 * timeline.play();
		 */

	}

	public void generatePlateau() {
		Plateau plateau = new Plateau(decalage, tailleCase, decalageTrait);
		this.getChildren().clear();
		this.getChildren().addAll(plateau.dessinEnvironnement());
	}

	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub

	}

}
