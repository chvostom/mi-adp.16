package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;

public class SimpleMovementStrategy implements IMovingStrategy {

    @Override
    public int nextPosX( int initX, float initPower, float initAngle, long lifetime, float gravity ){
        return ( int ) ( initX + ( lifetime * initPower * Math.cos( initAngle ) ) );
    }

    @Override
    public int nextPosY( int initY, float initPower, float initAngle, long lifetime, float gravity ){
        return ( int ) ( initY + ( lifetime * initPower * Math.sin( initAngle ) ) );
    }

    @Override
    public String getName( ){
        return "Simple";
    }

}