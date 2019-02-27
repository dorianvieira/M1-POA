package view;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.*;
import controller.dragcontroller;
import controller.dragdroppedcontroller;
import controller.dragovercontroller;
import controller.soleilcontroller;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Vue2 extends Application {
	private Jeu jeu;
	private soleilcontroller scontroller;
	private Group root;


	@Override
	public void init() throws Exception {
		jeu = new Jeu(900,6);
		jeu.Initialisation2();
	}


	@Override
	public void start(Stage theStage)
	{
		theStage.setTitle( "Plants VS Zombies" );

		this.root = new Group();
		Scene theScene = new Scene(root,900,800);
		Image background = new Image("view/wallp.png");
		ImageView iv1 = new ImageView();
		iv1.setImage(background);
		Label nbTour =new Label(""+this.jeu.getCagnotte());
		//nbTour.setPrefWidth(10);
		nbTour.setFont(new Font(20));
		// img bottom peashooter
		StackPane i1 = new StackPane();
		Image pois = new Image("imgs/peashooter.png");
		ImageView pois1 = new  ImageView(pois);
		i1.getChildren().add(pois1);
	
		i1.setMaxSize(90, 160);
		i1.setTranslateX(-170);
		// img bottom tournesol
		StackPane i2 = new StackPane();
		Image tournesol = new Image("imgs/tournesol.png");
		ImageView tournesol1 = new  ImageView(tournesol);
		i2.getChildren().add(tournesol1);
		
		i2.setMaxSize(90, 160);
		i2.setTranslateX(-75);
		// img bottom noix
		StackPane i3 = new StackPane();
		Image noix = new Image("imgs/noix.png");
		ImageView noix1 = new  ImageView(noix);
		i3.getChildren().add(noix1);
	
		i3.setMaxSize(90, 160);
		i3.setTranslateX(20);
		
		// img bottom 
		
		StackPane i4 = new StackPane();
		Image chomper = new Image("imgs/Chomper.png");
		ImageView chomper1 = new ImageView(chomper);
		i4.getChildren().add(chomper1);
		i4.setMaxSize(90, 160);
		i4.setTranslateX(100);
		Label cent= new Label("100");
		Label cinquante = new Label("50");
		Label cinquantebis = new Label("50");
		Label deuxcent = new Label("200");
		

		Canvas canvas = new Canvas( this.jeu.getEnvironnement().getLargeurJardin(), this.jeu.getEnvironnement().nbreLigne()*100);
		root.getChildren().add(iv1);
		root.getChildren().add(canvas);


		Image down = new Image("imgs/getcard.png");
		ImageView iv2 = new ImageView();
		iv2.setImage(down);
		StackPane drag = new StackPane();
		//    HBox drag = new HBox();
		BorderPane sun = new BorderPane();
		root.getChildren().add(drag);
		drag.setTranslateY(600);
		drag.getChildren().add(sun);
		drag.getChildren().add(iv2);
		drag.getChildren().add(i1);
		i1.getChildren().add(cent);
		cent.setTranslateY(50);
		cent.setTextFill(Color.WHITE);
		drag.getChildren().add(i2);
		i2.getChildren().add(cinquante);
		cinquante.setTranslateY(50);
		cinquante.setTextFill(Color.WHITE);
		drag.getChildren().add(i3);
		i3.getChildren().add(cinquantebis);
		cinquantebis.setTranslateY(50);
		cinquantebis.setTextFill(Color.WHITE);
		drag.getChildren().add(i4);
		i4.getChildren().add(deuxcent);
		deuxcent.setTranslateY(50);
		deuxcent.setTextFill(Color.WHITE);
		sun.setTop(nbTour);

		i1.setId("pois");
		i2.setId("tournesol");
		i3.setId("noix");
		i4.setId("chomper");
		
		i1.setOnDragDetected(new dragcontroller(i1, pois));
		i2.setOnDragDetected(new dragcontroller(i2, tournesol));
		i3.setOnDragDetected(new dragcontroller(i3, noix));
		i4.setOnDragDetected(new dragcontroller(i4, chomper));
		theScene.setOnDragOver(new dragovercontroller());

		theScene.setOnDragDropped(new dragdroppedcontroller(jeu));


		nbTour.setTranslateX(90);
		nbTour.setTranslateY(150);
		createcontroller();



		GraphicsContext gc = canvas.getGraphicsContext2D();

		Timeline gameLoop = new Timeline();
		gameLoop.setCycleCount( Timeline.INDEFINITE );

		final long timeStart = System.currentTimeMillis();

		KeyFrame kf = new KeyFrame(
				Duration.seconds(0.117),
				new EventHandler<ActionEvent>()
				{
					public void handle(ActionEvent ae)
					{
						if(jeu.estFini()) {
							gameLoop.stop();
							System.out.println("FINI");



						}
						else{
						
							// Clear the canvas
							gc.clearRect(0, 0, jeu.getEnvironnement().getLargeurJardin(), jeu.getEnvironnement().nbreLigne()*100);
							Perso p;
							nbTour.setText(""+jeu.getCagnotte());
							//	ligne.setText("Nb Projectille:"+jeu.getEnvironnement().nbProjectile());
							for (int i = 0; i < jeu.getEnvironnement().nbreLigne(); i++) { for (int j = 0; j < jeu.getEnvironnement().getLignePersos(i) .size(); j++) {
								p = jeu.getEnvironnement().getLignePersos(i).get(j);
								gc.drawImage(new Image(fichierImageDe(p)),p.getX(), (p.getLigne() * 100));
							}
							}
							
							for (Soleil s : jeu.getEnvironnement().getSoleils()) {
								if (s.getEstRecupere()==false) {
									gc.drawImage(new Image("imgs/soleil.png"),s.getX(), (s.getLigne() * 100));

								}
								
							}

							jeu.unTour();
						}
					}
				});

		gameLoop.getKeyFrames().add( kf );
		gameLoop.play();
		theStage.setScene( theScene );
		theStage.setResizable(false);
		theStage.show();



	}

	public void createcontroller () {
		scontroller = new soleilcontroller(jeu);
		root.setOnMouseClicked(scontroller);
	}

	public Jeu getJeu() {
		return this.jeu;
	}

	public String fichierImageDe(Perso p){
		if (p instanceof PistePois) {
			return "imgs/peashooter.png";
		}
		
		
		if (p instanceof ZombieExplosif) {
			return "imgs/explosif.png";
		}
		if(p instanceof ZombieCasque){
			return "imgs/zombie_casque.png";
		}
		
		if (p instanceof Projectile) {
			return "imgs/pea.png";
		}

		if (p instanceof Soleil) {
			return "imgs/soleil.png";
		}
		if (p instanceof Noix) {
			return "imgs/noix.png";
		}
		if (p instanceof Tournesol) {
			return "imgs/tournesol.png";
		}
		if (p instanceof Chomper) {
			return "imgs/Chomper.png";
		}
		if (p instanceof Zombie) {
			if(p instanceof Perchiste && p.getAccessoire().possedeAccessoire()){
				return "imgs/perchiste.png";
			}
			else if (p instanceof ZombiePogo && p.getAccessoire().possedeAccessoire()) {
				return "imgs/pogo.png";
				
			}
			return "imgs/Zombie.png";
		}

		else return "";
	}
}





