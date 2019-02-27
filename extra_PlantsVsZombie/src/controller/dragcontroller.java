package controller;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import view.Vue2;

public class dragcontroller implements EventHandler<MouseEvent> {

	private StackPane s;
	private Image i;



	public dragcontroller(StackPane s,Image i) {
		this.s=s;
		this.i=i;
	}
	@Override
	public void handle(MouseEvent event) {

		Dragboard db = s.startDragAndDrop(TransferMode.MOVE);
		ClipboardContent content = new ClipboardContent();

		String id = s.getId();
		content.putImage(i);
		switch (id) {
		case "pois":content.putString("pois");
		break;
		case "tournesol":content.putString("tournesol");
		break;
		case "noix":content.putString("noix");
		break;
		case "chomper":content.putString("chomper");
		break;
		}

		db.setContent(content);






	}

}