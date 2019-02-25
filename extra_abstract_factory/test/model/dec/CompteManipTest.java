package model.dec;

import model.exceptions.InsufficientBalanceException;
import model.fact.CompteFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.DoublePredicate;
import java.util.stream.DoubleStream;

import static org.junit.jupiter.api.Assertions.*;

class CompteManipTest {

    CompteManip cm ;
    CompteManipTest(){
        cm = CompteFactory.INSTANCE.createCompteCourant("John Doe");    }

    /*@BeforeAll
    void setUpAll() {
        cm = CompteFactory.INSTANCE.createCompteCourant("John Doe");    }*/

    @BeforeEach
    void setUp() {
        cm.setBalance(1000.0d);
    }

    @AfterEach
    void tearDown() {
        cm.setBalance(0.0d);
    }
//
//    @Test
//    void withdrawShouldPassWith500Bal() throws InsufficientBalanceException {
//        double oldBal = cm.getBalance();
//        double amount = 500.0d;
//        double newBal = cm.withdraw(500.0d);
//        assertEquals(newBal, oldBal - amount );
//    }

    @ParameterizedTest
    @MethodSource("range500To1000")
    void withdrawWithParamShouldPass(double amount) throws InsufficientBalanceException {
        double oldBal = cm.getBalance();
        double newBal = cm.withdraw(500.0d);
        assertEquals(newBal, oldBal - amount );
    }
    static DoubleStream range500To1000(){
        //DoublePredicate dRange = d->d >= 500.0d && d <= 1000.0d;
        return DoubleStream.iterate(500.0d, n->n+100.0d).limit(6);
    }

    @ParameterizedTest
    @MethodSource("rangeForOverdraft")
    void withdrawWithParamExpectOverdraft(double amount){
        assertThrows(InsufficientBalanceException.class,()->cm.withdraw(amount));
    }

    static DoubleStream rangeForOverdraft(){
        return DoubleStream.iterate(1100.0d,n->n+100.0d).limit(3);
    }
}