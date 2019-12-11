package cz.cvut.fit.miadp.mvcgame.abstractFactory;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsEnemy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith( MockitoJUnitRunner.class )
public class GameObjsFactTest {

    @Test
    public void createCannon( ){
        GameModel model = mock( GameModel.class );
        when( model.getMaxY( ) ).thenReturn( MvcGameConfig.MAX_Y );
        GameObjsFact go = new GameObjsFact( model );
        AbsCannon cannon = go.createCannon( );
        assertEquals( 60, cannon.getX( ) );
        assertTrue( cannon.getY( ) > MvcGameConfig.CANNON_MAX_Y_MARGIN );
        assertTrue( cannon.getY( ) < model.getMaxY( ) - MvcGameConfig.CANNON_MAX_Y_MARGIN );
    }

    @Test
    public void createEnemy( ){
        GameModel model = mock( GameModel.class );
        when( model.getMaxX( ) ).thenReturn( MvcGameConfig.MAX_X );
        when( model.getMaxY( ) ).thenReturn( MvcGameConfig.MAX_Y );
        GameObjsFact go = new GameObjsFact( model );
        AbsCannon cannon = mock( AbsCannon.class );
        when( cannon.getX( ) ).thenReturn( 60 );
        when( model.getCannon( ) ).thenReturn( cannon );
        AbsEnemy enemy = go.createEnemy( );
        assertTrue( enemy.getX( ) > 0 && enemy.getX( ) < model.getMaxX( ) );
        assertTrue( enemy.getY( ) > 0 && enemy.getY( ) < model.getMaxY( ) );
    }

}
