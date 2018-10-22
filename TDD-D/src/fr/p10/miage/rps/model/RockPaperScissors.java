package fr.p10.miage.rps.model;

public class RockPaperScissors{//générer des tests il faut alt + entrée puis create test et créer un dossier test dans au même niveau que src et
    //ensuite mark directory as test

    Result play(RPSEnum p1, RPSEnum p2) {
        if (p1.equals(p2))
            return Result.TIE;
        if (p1.equals(RPSEnum.PAPER) && p2.equals(RPSEnum.ROCK))
            return Result.WIN;
        else
            return Result.LOST;
    }
}
