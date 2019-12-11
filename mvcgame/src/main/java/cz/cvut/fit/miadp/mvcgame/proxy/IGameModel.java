package cz.cvut.fit.miadp.mvcgame.proxy;

import cz.cvut.fit.miadp.mvcgame.command.AbsCommand;
import cz.cvut.fit.miadp.mvcgame.model.GameObject;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsModelInfo;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;

import java.util.List;

public interface IGameModel
{
    void moveCannonUp();
    void moveCannonDown();
    void cannonShoot();
    void cannonToggleMode();
    void registerCmd(AbsCommand cmd);
    void undoLastCmd();
	Object createMemento();
	void setMemento(Object memento);
    int getScore( );
    int getMaxX( );
    int getMaxY( );
    AbsCannon getCannon( );
    AbsModelInfo getInfo( );
    List<AbsEnemy> getEnemies( );
    void attachObserver( IObserver observer );
    void detachObserver( IObserver observer );
    void notifyObservers( );
    List<AbsMissile> getMissiles( );
    void aimCannonUp( );
    void aimCannonDown( );
    void incCannonPower( );
    void decCannonPower( );
    void switchMovementStrategy( );
    List<GameObject> getGameObjects( );
    IMovingStrategy getActiveMovementStrategy( );
    void incGravity( );
    void decGravity( );
    String getCannonActiveShootingMode( );
    float getGravity( );
    
}