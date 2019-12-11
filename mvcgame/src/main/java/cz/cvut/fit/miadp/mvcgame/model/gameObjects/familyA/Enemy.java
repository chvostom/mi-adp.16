package cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyA;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;

public class Enemy extends AbsEnemy {
    private Position initPosition;
    private IMovingStrategy movementStrategy;
    private float gravity;
    private long lifetimeMod = Integer.MAX_VALUE;

    public Enemy(Position position, int skin, IMovingStrategy movementStrategy, float gravity ){
        super( );
        this.initPosition = position;
        this.skin = skin;
        this.movementStrategy = movementStrategy;
        this.gravity = gravity;
    }

    public Enemy(Enemy enemy ){
        super( enemy );
        this.initPosition = enemy.initPosition;
        this.lifetimeMod = enemy.lifetimeMod;
        this.gravity = enemy.gravity;
        this.movementStrategy = enemy.movementStrategy;
    }

    @Override
    public void move( ){
        long remainder = 0;
        try{
            remainder = this.getAge( ) % lifetimeMod;
        }
        catch( ArithmeticException e ){
            System.out.println( this.getAge( ) );
            System.out.println( this.lifetimeMod );
        }
        this.setX( this.movementStrategy.nextPosX( initPosition.getX( ), MvcGameConfig.INIT_ENEMY_JUMP_POWER, ( float ) -( ( 1f / 2f ) * Math.PI ), remainder, this.gravity ) );
        int newY = this.movementStrategy.nextPosY( initPosition.getY( ), MvcGameConfig.INIT_ENEMY_JUMP_POWER, ( float ) -( ( 1f / 2f ) * Math.PI ), remainder, this.gravity );
        if( newY == initPosition.getY( ) ){
            this.lifetimeMod = this.getAge( );
        }
        this.setY( newY );
    }
}
