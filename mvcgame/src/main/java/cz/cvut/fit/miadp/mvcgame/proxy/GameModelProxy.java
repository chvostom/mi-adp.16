package cz.cvut.fit.miadp.mvcgame.proxy;

import cz.cvut.fit.miadp.mvcgame.command.AbsCommand;
import cz.cvut.fit.miadp.mvcgame.command.CannonMoveUpCmd;
import cz.cvut.fit.miadp.mvcgame.model.GameObject;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsModelInfo;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameModelProxy implements IGameModel {
    private IGameModel subject;

    public GameModelProxy(IGameModel subject) {
        this.subject = subject;
    }

    @Override
    public void incGravity( ){
        this.subject.incGravity( );
    }

    @Override
    public String getCannonActiveShootingMode( ){
        return this.subject.getCannonActiveShootingMode( );
    }

    @Override
    public float getGravity( ){
        return this.subject.getGravity( );
    }

    @Override
    public void decGravity( ){
        this.subject.decGravity( );
    }

    @Override
    public int getScore( ){
        return this.subject.getScore( );
    }

    @Override
    public int getMaxX( ){
        return this.subject.getMaxX( );
    }

    @Override
    public int getMaxY( ){
        return this.subject.getMaxY( );
    }

    @Override
    public AbsCannon getCannon( ){
        return this.subject.getCannon( );
    }

    @Override
    public AbsModelInfo getInfo( ){
        return this.subject.getInfo( );
    }

    @Override
    public List<AbsEnemy> getEnemies( ){
        return this.subject.getEnemies( );
    }

    @Override
    public void moveCannonUp( ){
        this.subject.moveCannonUp( );
    }

    @Override
    public void moveCannonDown( ){
        this.subject.moveCannonDown( );
    }

    @Override
    public void cannonShoot( ){
        this.subject.cannonShoot( );
    }

    @Override
    public void attachObserver( IObserver observer ){
        this.subject.attachObserver( observer );
    }

    @Override
    public void detachObserver( IObserver observer ){
        this.subject.detachObserver( observer );
    }

    @Override
    public void notifyObservers( ){
        this.subject.notifyObservers( );
    }

    @Override
    public List<AbsMissile> getMissiles( ){
        return this.subject.getMissiles( );
    }

    @Override
    public void aimCannonUp( ){
        this.subject.aimCannonUp( );
    }

    @Override
    public void aimCannonDown( ){
        this.subject.aimCannonDown( );
    }

    @Override
    public void incCannonPower( ){
        this.subject.incCannonPower( );
    }

    @Override
    public void decCannonPower( ){
        this.subject.decCannonPower( );
    }

    @Override
    public void switchMovementStrategy( ){
        this.subject.switchMovementStrategy( );
    }

    @Override
    public List<GameObject> getGameObjects( ){
        return this.subject.getGameObjects( );
    }

    @Override
    public IMovingStrategy getActiveMovementStrategy( ){
        return this.subject.getActiveMovementStrategy( );
    }

    @Override
    public void cannonToggleMode( ){
        this.subject.cannonToggleMode( );
    }

    @Override
    public void registerCmd( AbsCommand command ){
        this.subject.registerCmd( command );
    }

    @Override
    public Object createMemento( ){
        return this.subject.createMemento( );
    }

    @Override
    public void undoLastCmd( ){
        this.subject.undoLastCmd();
    }

    @Override
    public void setMemento( Object memento ){
        this.subject.setMemento( memento );
    }

}