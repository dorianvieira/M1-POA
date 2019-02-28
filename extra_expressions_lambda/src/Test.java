public class Test {
    public static void main(String[] args) throws NombreIncorrect {
	Titulaire x = new Prag("dupont");
	Titulaire y = new Mcf("Durand");
	Vacataire z = new Vacataire("Dubois");

	Departement info = new Departement();
	info.ajouter(z);
	info.ajouter(x);
	info.ajouter(y);
	System.out.println(info);
	System.out.println("nbheuresComp " + info.nbHeureCompAPayer());
	System.out.println("total " + info.prixHcAPayer());
	x.ajoutHeure(25);
	y.ajoutHeure(100);
	z.ajoutHeure(50);
	System.out.println(info);
	System.out.println("nbheuresComp " + info.nbHeureCompAPayer());
	System.out.println("total " + info.prixHcAPayer());
	x.ajoutHeure(320);
	y.ajoutHeure(296);
	z.ajoutHeure(50);
	System.out.println(info);
	System.out.println("nbheuresComp " + info.nbHeureCompAPayer());
	System.out.println("total " + info.prixHcAPayer());
	System.out.println("++++++++++++");
    }
}
