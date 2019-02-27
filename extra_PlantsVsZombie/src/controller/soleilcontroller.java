package controller;


import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Jeu;
import model.Soleil;


public class soleilcontroller implements EventHandler<MouseEvent> {
	private Jeu jeu;
	
	public soleilcontroller( Jeu jeu) {
		this.jeu = jeu;
	}
	
	@Override
	public void handle(MouseEvent event) {
		Soleil soleil = null;
		
		ArrayList<Soleil> liste = jeu.getEnvironnement().getSoleils();
		for(Soleil s : liste){
			if(((event.getX()<=s.getX()+30) && (event.getX()>=s.getX()+5)) && ((event.getY()<=(s.getLigne()*120)+10)&& (event.getY()>=(s.getLigne()*100)+10)) && !s.getEstRecupere()){
				soleil = s;
			}
		}
		
		if(soleil!=null){
			this.jeu.setCagnotte(soleil.getGain());
			soleil.setEstRecupere(true);
		}
		
	}
//	private Soleil s;
//	private Vue2 v;
//
//	public soleilcontroller (Soleil s, Vue2 v) {
//		this.s = s;
//		this.v = v;
//	}
//
//	@Override
//	public void handle(MouseEvent event) {
//		
//		
//		int x =(int) event.getX();
//		int y =(int) event.getY();
//		
//		
//		
//		ArrayList< Soleil> listeS=v.getJeu().getEnvironnement().getSoleils();
//		
//		
//		
//		
//		for(Soleil s : listeS){
//			
//			if(s.getX()==x && s.getLigne()==y ){
//				
//				if (s.getEstRecupere() == false){
//					
//					v.getJeu().setCagnotte(s.getGain());
//					s.setEstRecupere(true);
//				}
//				
//				
//			}
//			
//			
//			
//			
//			
//			
//			
//		}
//
//
//
//		if(((event.getX()<=s.getX()+30) && (event.getX()>=s.getX()+5)) && ((event.getY()<=(s.getLigne()*120)+10)&& (event.getY()>=(s.getLigne()*100)+10))) {
//			if (s.getEstRecupere() == false){
//				
//				v.getJeu().setCagnotte(s.getGain());
//				s.setEstRecupere(true);
//			}
//			//s.setEstRecupere(true);
//
//		}
//
//
//
//	}
	
	
	
	
	
	
	
	
	



}