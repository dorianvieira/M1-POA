package model;

public class Pogo implements Accessoire {
	private boolean existAccessoire;
	
	public Pogo(){
		this.existAccessoire = true;
	}
	
	public void perdAccessoire(){
		this.existAccessoire = false;
	}
	
	public boolean possedeAccessoire(){
		return this.existAccessoire;
	}
}