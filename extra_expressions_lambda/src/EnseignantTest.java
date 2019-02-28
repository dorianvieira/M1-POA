/*
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EnseignantTest {

    private Enseignant prag;
    private Enseignant mcf;
    private Enseignant vacataire;

    @Before
    public void setUp() {
	prag = new Prag("Homps");
	mcf = new Mcf("simonot");
	vacataire = new Vacataire("Aquil");

    }

    @Test(expected = NombreIncorrect.class)
    public void testAjout() throws NombreIncorrect {
	vacataire.ajoutHeure(-5);
    }

    @Test
    public void testAjoutCorrcet() throws NombreIncorrect {
	vacataire.ajoutHeure(12);
	assertEquals(12, vacataire.getHeuresEffectuees());
	vacataire.ajoutHeure(190);
	assertEquals(202, vacataire.getHeuresEffectuees());
    }

    @Test
    public void testHeureComp() throws NombreIncorrect {
	vacataire.ajoutHeure(130);
	assertEquals(130, vacataire.heureComp());
	prag.ajoutHeure(100);
	assertEquals(0, prag.heureComp());
	mcf.ajoutHeure(100);
	assertEquals(0, prag.heureComp());
	prag.ajoutHeure(100);
	assertEquals(0, prag.heureComp());
	mcf.ajoutHeure(100);
	assertEquals(8, mcf.heureComp());
	prag.ajoutHeure(200);
	assertEquals(16, prag.heureComp());

    }

}
*/