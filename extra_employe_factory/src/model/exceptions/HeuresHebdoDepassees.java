package model.exceptions;

import java.lang.Exception;

public final class HeuresHebdoDepassees extends Exception {
	
	public HeuresHebdoDepassees(){
		super();
	}
	public HeuresHebdoDepassees(String message){
		super(message);
	}
}