package model;

public class Casque implements Accessoire {
	private boolean existAccessoire;
	
	public Casque(){
		this.existAccessoire = true;
	}
	
	public void perdAccessoire(){
		this.existAccessoire = false;
	}
	
	public boolean possedeAccessoire(){
		return this.existAccessoire;
	}
}