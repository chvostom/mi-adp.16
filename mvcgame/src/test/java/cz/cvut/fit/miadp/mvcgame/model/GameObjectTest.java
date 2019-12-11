package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyA.Enemy;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyA.Missile;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;

@RunWith( MockitoJUnitRunner.class )
public class GameObjectTest {

    @Test
    public void collidesWith( ){
        IMovingStrategy strategy = mock( IMovingStrategy.class );
        GameObject gameObject1 = new Missile( new Position(0,0), 1, 0, 0, strategy, 0 );
        GameObject gameObject2 = new Enemy( new Position(0,0), 1, strategy, 0.0f );
        gameObject1.setX( 50 );
        gameObject1.setY( 50 );
        gameObject2.setX( gameObject1.getX( ) + MvcGameConfig.COLLIDE_FACTOR - 10 );
        gameObject2.setY( gameObject1.getY( ) + MvcGameConfig.COLLIDE_FACTOR - 10 );
        Assert.assertTrue( gameObject1.collidesWith( gameObject2 ) );
        gameObject2.setX( gameObject1.getX( ) + MvcGameConfig.COLLIDE_FACTOR );
        gameObject2.setY( gameObject1.getY( ) + MvcGameConfig.COLLIDE_FACTOR );
        Assert.assertTrue( gameObject1.collidesWith( gameObject2 ) );
        gameObject2.setX( gameObject1.getX( ) + MvcGameConfig.COLLIDE_FACTOR + 10 );
        gameObject2.setY( gameObject1.getY( ) + MvcGameConfig.COLLIDE_FACTOR + 10 );
        Assert.assertFalse( gameObject1.collidesWith( gameObject2 ) );
    }
}
