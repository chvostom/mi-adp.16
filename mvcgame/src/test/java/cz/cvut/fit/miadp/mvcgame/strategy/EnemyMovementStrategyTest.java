package cz.cvut.fit.miadp.mvcgame.strategy;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class EnemyMovementStrategyTest {

    @Test
    public void getName( ){
        EnemyMovementStrategy strat = new EnemyMovementStrategy( );
        assertEquals( "Enemy", strat.getName( ) );
        assertNotEquals( "Enemies", strat.getName( ) );

    }

    @Test
    public void nextPosX( ){
        EnemyMovementStrategy strat = new EnemyMovementStrategy( );
        Random rng = new Random( );
        int newX = strat.nextPosX( 0, 0, 0, 0, 0 );
        assertEquals( 0, newX );
        newX = strat.nextPosX( 50, rng.nextInt( 300 ), rng.nextInt( 300 ), rng.nextInt( 300 ), rng.nextInt( 300 ) );
        assertEquals( 50, newX );
    }

    @Test
    public void nextPosY( ){
        EnemyMovementStrategy strat = new EnemyMovementStrategy( );
        long lifetime = 0;
        int newY = strat.nextPosY( 0, 0.5f, ( float ) -( 1f / 2f * Math.PI ), lifetime, 10.0f );
        assertEquals( 0, newY );
        lifetime += 50;
        newY = strat.nextPosY( 300, 0.5f, ( float ) -( 1f / 2f * Math.PI ), lifetime, 10.0f );
        assertNotEquals( 300, newY );
        lifetime += 80000;
        newY = strat.nextPosY( 300, 0.5f, ( float ) -( 1f / 2f * Math.PI ), lifetime, 10.0f );
        assertEquals( 300, newY );
    }
}
