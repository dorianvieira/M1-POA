/*
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Set;
import java.util.SortedSet;



public class DepartementTest {
	private Enseignant x, y, z, t;
	private Cours c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14;
	private Departement info;

	@Before
	public void setUp() throws Exception {
		x = new Prag("Homps");
		y = new Mcf("Simonot");
		z = new Vacataire("Aquil");
		t = new Vacataire("Picton");
		x.ajoutHeure(200);
		y.ajoutHeure(100);
		z.ajoutHeure(56);
		t.ajoutHeure(40);

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
	}

	@Test
	public void testLesCoursDeMaster() {
		Set<Cours> res = info.lesCoursDeMaster();
		assertEquals(5, res.size());
		assertTrue(res.contains(c10));
		assertTrue(res.contains(c11));
		assertTrue(res.contains(c12));
		assertTrue(res.contains(c13));
		assertTrue(res.contains(c14));
	}

	@Test
	public void testlesCoursDeEnseignant() {
		Set<Cours> res = info.lesCoursDeEnseignant("Homps");
		assertEquals(5, res.size());
		assertTrue(res.contains(c1));
		assertTrue(res.contains(c5));
		assertTrue(res.contains(c4));
		assertTrue(res.contains(c10));
		assertTrue(res.contains(c12));
	}

	@Test
	public void testlesNomsCoursDeEnseignant() {
		Set<String> res = info.lesNomsCoursDeEnseignant("Homps");
		assertEquals(5, res.size());
		assertTrue(res.contains("M212"));
		assertTrue(res.contains("M213"));
		assertTrue(res.contains("M215"));
		assertTrue(res.contains("M211"));
	}

	@Test
	public void testnbreCoursL2() {
		assertEquals(4, info.nbreCoursL2());
	}

	@Test
	public void testlesIntitulesDeCours() {
		Set<String> res = info.lesIntitulesDeCours();
		assertEquals(7, res.size());
		assertTrue(res.contains("M211"));
		assertTrue(res.contains("M212"));
		assertTrue(res.contains("M213"));
		assertTrue(res.contains("M214"));
		assertTrue(res.contains("M215"));
		assertTrue(res.contains("M216"));
		assertTrue(res.contains("M310"));
	}

	@Test
	public void testlesIntitulesDeCoursTrie() {
		SortedSet<String> res = info.lesIntitulesDeCoursTrie();
		assertEquals(7, res.size());
		String[] tab1 = new String[7];
		String[] tab = res.toArray(tab1);
		assertEquals("M211", tab[0]);
		assertEquals("M212", tab[1]);
		assertEquals("M213", tab[2]);
		assertEquals("M214", tab[3]);
		assertEquals("M215", tab[4]);
		assertEquals("M216", tab[5]);
		assertEquals("M310", tab[6]);
	}

	@Test
	public void testlesCoursParNiveauPuisNom() {
		SortedSet<Cours> res = info.lesCoursParNiveauPuisNom();
		assertEquals(14, res.size());
		Cours[] tab1 = new Cours[14];
		Cours[] tab = res.toArray(tab1);
		Cours[] tabAttendu = { c1, c5, c6, c4, c9, c8, c3, c2, c7, c12, c11,
				c10, c14, c13 };
		assertArrayEquals(tabAttendu, tab);
	}

	// faire définir le test les noms des enseignants triés par nom

	@Test
	public void testlesResponsablesL2NomPuisIdentifiant() throws Exception {
		Enseignant nouveauHomps = new Mcf("Homps");
		info.ajouter(nouveauHomps);
		info.ajouter(new Cours("A123", nouveauHomps, Niveau.L2));
		SortedSet<Enseignant> res = info.lesResponsablesL2NomPuisIdentifiant();
		Enseignant[] tabAttendu = { x, nouveauHomps, y };
		Enseignant[] tab1 = new Enseignant[3];
		Enseignant[] tab = res.toArray(tab1);
		assertArrayEquals(tabAttendu, tab);
	}

	@Test
	public void testNbreResponsable() {
		assertEquals(3, info.nbreResponsable());
	}

	@Test
	public void testenseignantsSansHeuresCompTrieHeuresFaitesPuisNom()
			throws Exception {
		Enseignant nouveauSimonot = new Mcf("Simonot");
		info.ajouter(nouveauSimonot);
		nouveauSimonot.ajoutHeure(100);
		Set<Enseignant> res = info
				.enseignantsSansHeuresCompTrieHeuresFaitesPuisNom();
		Enseignant[] tabAttendu = { y, nouveauSimonot, x };
		Enseignant[] tab1 = new Enseignant[3];
		Enseignant[] tab = res.toArray(tab1);
		assertArrayEquals(tabAttendu, tab);
	}
}
*/