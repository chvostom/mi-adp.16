package cz.cvut.fit.miadp.mvcgame;


import cz.cvut.fit.miadp.mvcgame.model.GameObjectTest;
import cz.cvut.fit.miadp.mvcgame.model.LifetimeLimitedGameObjectTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith( Suite.class )

@Suite.SuiteClasses( {
        GameObjectTest.class,
        LifetimeLimitedGameObjectTest.class
} )

public class ModelTestSuit {
}
