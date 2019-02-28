import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Predicate;

public class Essai {

	public static void main(String[] args) {
		Enseignant x, y, z, t;
		Cours c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14;
		Departement info;

		x = new Prag("Homps");
		y = new Mcf("Simonot");
		z = new Vacataire("Aquil");
		t = new Vacataire("Picton");

		c1 = new Cours("M212", x, Niveau.L1);
		c5 = new Cours("M213", x, Niveau.L1);
		c6 = new Cours("M214", z, Niveau.L1);
		c2 = new Cours("M212", y, Niveau.L3);
		c7 = new Cours("M216", z, Niveau.L3);
		c3 = new Cours("M310", y, Niveau.L2);
		c4 = new Cours("M213", x, Niveau.L2);
		c9 = new Cours("M214", y, Niveau.L2);
		c8 = new Cours("M215", y, Niveau.L2);
		c10 = new Cours("M215", x, Niveau.M1);
		c11 = new Cours("M212", z, Niveau.M1);
		c12 = new Cours("M211", x, Niveau.M1);
		c13 = new Cours("M213", y, Niveau.M2);
		c14 = new Cours("M212", z, Niveau.M2);

		info = new Departement();
		info.ajouter(x);
		info.ajouter(y);
		info.ajouter(z);

		info.ajouter(c1);
		info.ajouter(c2);
		info.ajouter(c3);
		info.ajouter(c4);
		info.ajouter(c5);
		info.ajouter(c6);
		info.ajouter(c7);
		info.ajouter(c8);
		info.ajouter(c9);
		info.ajouter(c10);
		info.ajouter(c11);
		info.ajouter(c12);
		info.ajouter(c13);
		info.ajouter(c14);

		System.out.println("L1:");
		System.out.println(info.cherche(new ConditionNiveau(Niveau.L1)));
		System.out.println("Tous sauf L1:");
		System.out.println(info.cherche(new ConditionTousSaufNiveau(Niveau.L1)));

		System.out.println("2 Niveau:");
		ArrayList<Niveau> n = new ArrayList<Niveau>();
		n.add(Niveau.L1);
		n.add(Niveau.M1);
		System.out.println(info.cherche(new ConditionNiveauEtNiveau(n)));
		System.out.println(info.cherche(c -> c.getResponsable().getNom().equals("Homps")));

		System.out.println("Test Par Niveau et Nom");
		SortedSet<Cours> s = new TreeSet<>((x1, x2) -> Cours.comparerParNiveauPuisNom(c1, c14));
		s.add(c14);
		s.add(c1);
		System.out.println(s);
	}
}