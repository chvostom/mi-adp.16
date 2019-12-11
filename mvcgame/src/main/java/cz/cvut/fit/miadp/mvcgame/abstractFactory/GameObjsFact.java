package cz.cvut.fit.miadp.mvcgame.abstractFactory;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCollision;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsModelInfo;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyA.*;
import cz.cvut.fit.miadp.mvcgame.strategy.EnemyMovementStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.SimpleMovementStrategy;

import java.util.Random;

public class GameObjsFact implements IGameObjsFact {

    private GameModel model;

    public GameObjsFact(GameModel model)
    {
        this.model = model;
    }

    @Override
    public AbsCannon createCannon( ){
        Cannon cannon = new Cannon( this );
        cannon.setX( cannon.getX( ) - 40 );
        cannon.setY( cannon.getY( ) + 100 );
        return cannon;
    }

    @Override
    public AbsEnemy createEnemy( ){
        Random rng = new Random( );
        int posX, posY;
        posY = rng.nextInt( this.model.getMaxY( ) - 110 ) + 120;
        posX = this.model.getCannon( ).getX( ) * 2 + rng.nextInt( this.model.getMaxX( ) - 50 - this.model.getCannon( ).getX( ) * 2 );
        int variation = rng.nextInt(1000) % 3 + 1 ;
        return new Enemy( new Position( posX, posY ), variation, new EnemyMovementStrategy( ), model.getGravity( ) );
    }

    @Override
    public AbsCollision createCollision( int x, int y ){
        Collision collision = new Collision( );
        collision.setX( x );
        collision.setY( y );
        return collision;
    }

    @Override
    public AbsMissile createMissile( ){
        Random rng = new Random( );
        Position position = new Position(
                this.model.getCannon( ).getX( ),
                this.model.getCannon( ).getY( )
        );
        return new Missile( position,
                rng.nextInt(100) % 4 + 1,
                this.model.getCannon( ).getAngle( ), this.model.getCannon( ).getPower( ),
                this.model.getActiveMovementStrategy( ), this.model.getGravity( ) );
    }

    @Override
    public AbsModelInfo createModelInfo( ){
        ModelInfo modelInfo = new ModelInfo( this.model );
        modelInfo.setX( 10 );
        modelInfo.setY( 10 );
        return modelInfo;
    }

}