package model;

public class Noix extends Plante {
	
	
	
	public Noix (int ligne ,int x ,Environnement environnement ){
		super(ligne , 80,x ,0,new GVieBasic(150), environnement );
	}
	
	public void evolue(){}

}