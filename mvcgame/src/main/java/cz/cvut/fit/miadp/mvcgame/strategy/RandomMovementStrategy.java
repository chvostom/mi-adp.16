package cz.cvut.fit.miadp.mvcgame.strategy;

import java.util.Random;

public class RandomMovementStrategy implements IMovingStrategy{

    private Random rng = new Random( );

    @Override
    public int nextPosX( int initX, float initPower, float initAngle, long lifetime, float gravity ){
        return ( rng.nextInt( 50 ) - 5 ) + initX + ( int ) ( lifetime * initPower * Math.cos( initAngle ) );
    }

    @Override
    public int nextPosY( int initY, float initPower, float initAngle, long lifetime, float gravity ){
        return ( rng.nextInt( 50 ) - 5 ) + initY + ( int ) ( lifetime * initPower * Math.sin( initAngle ) );
    }

    @Override
    public String getName( ){
        return "Random";
    }
}
