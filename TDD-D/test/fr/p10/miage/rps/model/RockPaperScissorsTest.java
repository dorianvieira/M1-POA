package fr.p10.miage.rps.model;

import org.testng.annotations.*;


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

    /*DATAPROVIDER*/
    /*en dur*/
   /* @DataProvider(name="winData")
    public Object[ ][ ] createWinData() {
        return new Object[][] {
                {"paper", "rock"},
                {"scissors", "paper"},
                {"rock", "scissors"}
        } ;
    }

    @DataProvider(name="lostData")
    public Object[ ][ ] createLostData() {
        return new Object[][] {
                {"rock", "paper"},
                {"paper", "scissors"},
                {"scissors", "rock"}
        } ;
    }

    @DataProvider(name="tieData")
    public Object[ ][ ] createTieData() {
        return new Object[][] {
                {"rock", "rock"},
                {"scissors", "scissors"},
                {"paper", "paper"}
        } ;
    }*/

   /*en paramétré */
    /*CREATION DU DATA¨PROVIDER*/
    @DataProvider(name="winData")
    public Object[ ][ ] createWinData() {
        return new Object[][] {
                {RPSEnum.PAPER, RPSEnum.ROCK },
                {RPSEnum.SCISSORS,RPSEnum.PAPER},
                {RPSEnum.ROCK,RPSEnum.SCISSORS}
        } ;
    }

    @DataProvider(name="lostData")
    public Object[ ][ ] createLostData() {
        return new Object[][] {
                {RPSEnum.ROCK,RPSEnum.PAPER},
                {RPSEnum.PAPER,RPSEnum.SCISSORS},
                {RPSEnum.SCISSORS, RPSEnum.ROCK}
        } ;
    }

    @DataProvider(name="tieData")
    public Object[ ][ ] createTieData() {
        return new Object[][] {
                {RPSEnum.ROCK,RPSEnum.ROCK},
                {RPSEnum.SCISSORS,RPSEnum.SCISSORS},
                {RPSEnum.PAPER,RPSEnum.PAPER}
        } ;
    }

    /*APPEL DU DATAPROVIDER*/
    @Test(dataProvider = "winData")
    void testWinPlayDataProvider ( RPSEnum p1 , RPSEnum p2 ) {
        assertEquals(rps.play(p1,p2),WIN);

    }

    @Test(dataProvider = "lostData")
    void testLostPlayDataProvider ( RPSEnum p1 , RPSEnum p2 ) {
        assertEquals(rps.play(p1,p2),LOST);

    }

    @Test(dataProvider = "tieData")
    void testTiePlayDataProvider ( RPSEnum p1 , RPSEnum p2 ) {
        assertEquals(rps.play(p1,p2),TIE);

    }


}