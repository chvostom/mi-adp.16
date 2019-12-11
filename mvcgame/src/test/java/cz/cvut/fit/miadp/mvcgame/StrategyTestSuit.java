package cz.cvut.fit.miadp.mvcgame;


import cz.cvut.fit.miadp.mvcgame.strategy.EnemyMovementStrategyTest;
import cz.cvut.fit.miadp.mvcgame.strategy.RandomMovementStrategyTest;
import cz.cvut.fit.miadp.mvcgame.strategy.SimpleMovementStrategyTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith( Suite.class )

@Suite.SuiteClasses( {
        EnemyMovementStrategyTest.class,
        RandomMovementStrategyTest.class,
        SimpleMovementStrategyTest.class
} )

public class StrategyTestSuit {
}
