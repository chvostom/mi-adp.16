package cz.cvut.fit.miadp.mvcgame.strategy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class RandomMovementStrategyTest {

    @Test
    public void nextPosX( ){
        RandomMovementStrategy strategy = new RandomMovementStrategy( );
        int newX = strategy.nextPosX( 50, 0.5f, ( float ) -( 1f / 2f * Math.PI ), 0, 10.0f );
        assertTrue( newX >= 40 );
        newX = strategy.nextPosX( 50, 0.5f, ( float ) -( 1f / 2f * Math.PI ), 150, 10.0f );
        assertTrue( newX >= 60 );
    }

    @Test
    public void nextPosY( ){
        RandomMovementStrategy strategy = new RandomMovementStrategy( );
        int newY = strategy.nextPosY( 50, 0.5f, 0.0f, 0, 10.0f );
        assertTrue( newY >= 45 && newY <= 95 );
        newY = strategy.nextPosY( 50, 0.5f, 0.0f, 150, 10.0f );
        assertTrue( newY >= 45 && newY <= 95 );
    }

    @Test
    public void getName( ){
        assertEquals( "Random", new RandomMovementStrategy( ).getName( ) );
        assertNotEquals( "Randbloom", new RandomMovementStrategy( ).getName( ) );
    }
}
