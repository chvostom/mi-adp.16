package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;

public class NormalMovementStrategy implements IMovingStrategy{

    @Override
    public int nextPosX( int initX, float initPower, float initAngle, long lifetime, float gravity ){
        return initX + ( int ) ( initPower * lifetime * Math.cos( initAngle ) );
    }

    @Override
    public int nextPosY( int initY, float initPower, float initAngle, long lifetime, float gravity ){
        float gravityCoefficient = ( 0.5f * gravity * ( float ) Math.pow( lifetime, 2 ) ) / MvcGameConfig.GRAVITY_DIVIDE_CONSTANT;
        return initY + ( int ) ( ( initPower * lifetime * Math.sin( initAngle ) ) + ( gravityCoefficient ) );
    }

    @Override
    public String getName( ) {
        return "Normal";
    }
}
