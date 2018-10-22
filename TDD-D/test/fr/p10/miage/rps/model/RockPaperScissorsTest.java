package fr.p10.miage.rps.model;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import static fr.p10.miage.rps.model.Result.TIE;
import static fr.p10.miage.rps.model.Result.LOST;
import static fr.p10.miage.rps.model.Result.WIN;
import static org.testng.Assert.*;

/*click droit puis run sur test pour lancer le test*/
public class RockPaperScissorsTest {
/*il faut ajouter en parametre en haut à droite dans prferences sissors paper et rock*/
    RockPaperScissors rps;

    @BeforeMethod
    public void setUp() throws Exception {
        rps = new RockPaperScissors();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        rps=null;
    }

    @Test
    public void testPlay() {
    }

    /*@Test
    public void testWinPlay() throws Exception{
        assertEquals(rps.play(RPSEnum.ROCK, RPSEnum.SCISSORS),WIN);

        //si on met WIN le test échoue si LOST le test est ok car on retourne LOST dans play de la classe RockPaperScissorcs
    }*/

    /* @Test
    public void testPlay2() throws Exception{
        assertEquals(WIN,rps.play(RPSEnum.ROCK, RPSEnum.SCISSORS));
    }*/

    @Parameters({"paper","rock"})
    @Test
    public void testWinPlay(String p1, String p2) throws Exception{
        assertEquals(rps.play(RPSEnum.valueOf(p1), RPSEnum.valueOf(p2)),WIN);
    }

    @Parameters({"paper","paper"})
    @Test
    public void testTiePlay(String p1, String p2) throws Exception{
        assertEquals(rps.play(RPSEnum.valueOf(p1), RPSEnum.valueOf(p2)),TIE);
    }

    @Parameters({"paper","scissors"})
    @Test
    public void testLostPlay(String p1, String p2) throws Exception{
        assertEquals(rps.play(RPSEnum.valueOf(p1), RPSEnum.valueOf(p2)),LOST);
    }

}