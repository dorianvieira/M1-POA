package controller;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import model.Chomper;
import model.Jeu;
import model.Noix;
import model.PistePois;
import model.Tournesol;
import view.Vue2;

public class dragdroppedcontroller implements EventHandler<DragEvent> {

	private Jeu j;


	public dragdroppedcontroller(Jeu j) {
		this.j = j;
	}
	@Override
	public void handle(DragEvent event) {

		int ligne=1;
		int colonne=(int)event.getX()-40;
		String type = event.getDragboard().getString();


		if (event.getX()>=60 && event.getX() <= 790) { // x
			if (event.getY()>= 80 && event.getY()<= 580){ // y

				if (event.getY()<=180){ // ligne
					ligne=1;
				} else if (event.getY()<=278) {
					ligne=2;
				} else if (event.getY()<=371) {
					ligne=3;
				} else if (event.getY()<=464){
					ligne=4;
				} else if (event.getY()<=581) {
					ligne=5;
				}
				switch (type) {
				case "pois":
					if (j.getCagnotte()>=100){
						j.addUnePlante(new PistePois(ligne, colonne, j.getEnvironnement()) );
						j.resetCagnotte(100);
					}
					break;
				case "noix":
					if (j.getCagnotte()>=50){
						j.addUnePlante(new Noix(ligne, colonne, j.getEnvironnement()) );
						j.resetCagnotte(50);
					}
					break;
				case "tournesol":
					if (j.getCagnotte()>=50){
						j.addUnePlante(new Tournesol(ligne, colonne, j.getEnvironnement()) );
						j.resetCagnotte(50);
					}
					break;
				case "chomper":
					if (j.getCagnotte()>=200){
						j.addUnePlante(new Chomper(ligne, colonne, j.getEnvironnement()) );
						j.resetCagnotte(200);
					}
					break;
				}





			}

		}


	}

}
