package cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyA;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;

public class Missile extends AbsMissile {
    protected Position initPosition;
    protected float initAngle;
    protected float initPower;
    protected float gravity;
    protected IMovingStrategy movementStrategy;

    public Missile( Position position, int skin, float initAngle, float initPower, IMovingStrategy movementStrategy, float gravity ){
        super( );
        this.initPosition = position;
        this.initAngle = initAngle;
        this.initPower = initPower;
        this.movementStrategy = movementStrategy;
        this.gravity = gravity;
        this.skin = skin;
        this.setX( initPosition.getX( ) );
        this.setY( initPosition.getY( ) );
    }

    public Missile( Missile missile ){
        super( missile );
        this.initPosition = missile.initPosition;
        this.initAngle = missile.initAngle;
        this.initPower = missile.initPower;
        this.gravity = missile.gravity;
        this.movementStrategy = missile.movementStrategy;
    }

    @Override
    public void move( ){
        long lifetime = this.getAge( );
        int newX = movementStrategy.nextPosX( initPosition.getX( ), initPower, initAngle, lifetime, gravity );
        int newY = movementStrategy.nextPosY( initPosition.getY( ), initPower, initAngle, lifetime, gravity );
        this.setX( newX );
        this.setY( newY );
    }
}
