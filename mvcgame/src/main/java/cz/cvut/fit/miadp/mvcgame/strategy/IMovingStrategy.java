package cz.cvut.fit.miadp.mvcgame.strategy;


public interface IMovingStrategy {
    int nextPosX( int initX, float initPower, float initAngle, long lifetime, float gravity );
    int nextPosY( int initY, float initPower, float initAngle, long lifetime, float gravity );
    String getName( );
}