public class Prag extends Titulaire {

    public Prag(String nom) {
	super(nom);
    }

    @Override
    public String toString() {
	return ("(prag)" + (super.toString() + "\n"));
    }

    @Override
    public int getServiceStatutaire() {
	return 384;
    }

}
