package model;

public class Perche implements Accessoire {
	private boolean existAccessoire;
	
	public Perche(){
		this.existAccessoire = true;
	}
	
	public void perdAccessoire(){
		this.existAccessoire = false;
	}
	
	public boolean possedeAccessoire(){
		return this.existAccessoire;
	}
}