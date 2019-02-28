public class Mcf extends Titulaire {

    public Mcf(String nom) {
	super(nom);
    }

    @Override
    public String toString() {
	return ("(Mcf) " + (super.toString() + "\n"));

    }

    @Override
    public int getServiceStatutaire() {
	return 192;
    }

}
