package cz.cvut.fit.miadp.mvcgame.strategy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class SimpleMovementStrategyTest {

    @Test
    public void nextPosX( ){
        SimpleMovementStrategy strategy = new SimpleMovementStrategy( );
        int newX = strategy.nextPosX( 50, 0.5f, ( float ) -( ( 1f / 2f ) * Math.PI ), 0, 10.0f );
        assertEquals( 50, newX );
        newX = strategy.nextPosX( 50, 0.5f, ( float ) -( ( 1f / 2f ) * Math.PI ), 150, 10.0f );
        assertTrue( newX > 40 && newX < 60 );
        newX = strategy.nextPosX( 50, 0.5f, ( float ) -( ( 1f / 2f ) * Math.PI ), 600, 10.0f );
        assertTrue( newX > 40 && newX < 60 );
    }

    @Test
    public void nextPosY( ){
        SimpleMovementStrategy strategy = new SimpleMovementStrategy( );
        int newY = strategy.nextPosY( 50, 0.5f, 0.0f, 0, 10.0f );
        assertEquals( 50, newY );
        newY = strategy.nextPosY( 50, 0.5f, 0.0f, 150, 10.0f );
        assertEquals( 50, newY );
    }

    @Test
    public void getName( ){
        assertEquals( "Simple", new SimpleMovementStrategy( ).getName( ) );
        assertNotEquals( "S1mple", new SimpleMovementStrategy( ).getName( ) );
    }
}
