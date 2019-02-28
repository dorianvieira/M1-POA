public class Vacataire extends Enseignant {

    public Vacataire(String nom) {
	super(nom);
    }

    @Override
    public int heureComp() {
	return this.getHeuresEffectuees();
    }

    @Override
    public String toString() {
	return ("(vacataire) " + (super.toString() + "\n"));
    }
}
