package cz.cvut.fit.miadp.mvcgame;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith( Suite.class )

@Suite.SuiteClasses( {
        AbstractFactoryTestSuit.class,
        ModelTestSuit.class,
        StrategyTestSuit.class
} )

public class TestSuit {
}
