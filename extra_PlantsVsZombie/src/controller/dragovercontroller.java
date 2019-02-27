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
import view.Vue2;

public class dragovercontroller implements EventHandler<DragEvent> {


	
	
	public dragovercontroller() {
		
	}
	@Override
	public void handle(DragEvent event) {
		
		Dragboard db = event.getDragboard();

		//			System.out.println(e.getY());

		event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
	
		
		
		
	
		event.consume();
		
	}

}
