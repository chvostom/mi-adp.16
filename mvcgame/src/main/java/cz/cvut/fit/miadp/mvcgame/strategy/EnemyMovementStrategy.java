package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;

public class EnemyMovementStrategy implements IMovingStrategy{

    @Override
    public String getName( ){
        return "Enemy";
    }

    @Override
    public int nextPosX( int initX, float initPower, float initAngle, long lifetime, float gravity ){
        return initX;
    }

    @Override
    public int nextPosY( int initY, float initPower, float initAngle, long lifetime, float gravity ){
        float gravityCoefficient = ( 0.35f * gravity * ( float ) Math.pow( lifetime, 2 ) ) / MvcGameConfig.GRAVITY_DIVIDE_CONSTANT;
        int newY = initY + ( int ) ( ( initPower * lifetime * Math.sin( initAngle ) ) + ( gravityCoefficient ) );
        if( newY >= initY ){
            return initY;
        }
        else {
            return newY;
        }

    }

}
