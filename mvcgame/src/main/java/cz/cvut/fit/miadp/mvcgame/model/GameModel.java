package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.*;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

import cz.cvut.fit.miadp.mvcgame.abstractFactory.GameObjsFact;
import cz.cvut.fit.miadp.mvcgame.abstractFactory.IGameObjsFact;
import cz.cvut.fit.miadp.mvcgame.command.AbsCommand;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyA.*;
import cz.cvut.fit.miadp.mvcgame.observer.IObservable;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.NormalMovementStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.RandomMovementStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.SimpleMovementStrategy;

public class GameModel implements IGameModel, IObservable {

    private int score = MvcGameConfig.INIT_SCORE;

    private Queue<AbsCommand> unexecutedCmds = new LinkedBlockingQueue<>();
    private Stack<AbsCommand> executedCmds = new Stack<>();


    private AbsCannon cannon;
    private List<AbsEnemy> enemies;
    private List<AbsMissile> missiles;
    private List<AbsCollision> collisions;
    private AbsModelInfo modelInfo;

    private List<IObserver> myObservers;
    private IGameObjsFact goFact;

    private List<IMovingStrategy> movementStrategies;
    private int activeMovementStrategyIndex = 0;

    private float gravity = MvcGameConfig.INIT_GRAVITY;

    private Timer timer;

    public GameModel() {
        this.myObservers = new ArrayList<>();
        this.goFact = new GameObjsFact(this);
        this.cannon = goFact.createCannon();
        this.modelInfo = goFact.createModelInfo();
        this.enemies = new ArrayList<>();
        this.missiles = new ArrayList<>();
        this.collisions = new ArrayList<>();
        this.movementStrategies = new ArrayList<>( );
        this.movementStrategies.add( new SimpleMovementStrategy( ) );
        this.movementStrategies.add( new RandomMovementStrategy( ) );
        this.movementStrategies.add( new NormalMovementStrategy( ) );
        this.initGame( );
        this.timeTick( );
    }


    @Override
    public void moveCannonUp() {
        int y = this.cannon.getY( );
        y -= MvcGameConfig.MOVE_STEP;
        if( y > MvcGameConfig.CANNON_MAX_Y_MARGIN ){
            this.cannon.setY( y );
            this.notifyObservers( );
        }
    }

    @Override
    public void moveCannonDown( ){
        int y = this.cannon.getY( );
        y += MvcGameConfig.MOVE_STEP;

        if( y < +MvcGameConfig.MAX_Y - MvcGameConfig.CANNON_MAX_Y_MARGIN ){
            this.cannon.setY( y );

            this.notifyObservers( );
        }

    }


    @Override
    public List<GameObject> getGameObjects() {
        List<GameObject> objs = new ArrayList<>();
        objs.addAll(this.enemies);
        objs.addAll(this.missiles);
        objs.addAll(this.collisions);
        objs.add(this.cannon);
        objs.add(this.modelInfo);
        return objs;
    }

    public void timeTick() {
        timer = new Timer( );
        timer.schedule( new TimerTask( ){
            @Override
            public void run( ){
                processCmds( );
                moveGameObjects( );
            }
        }, 0, MvcGameConfig.TIMER_TICK );
    }


    private void processCmds() {
        while( ! this.unexecutedCmds.isEmpty() ){
            AbsCommand command = unexecutedCmds.poll( );
            executedCmds.push( command );
            command.doExecute();
        }
        notifyObservers( );
    }

    private void moveMissiles( ) {
        for ( AbsMissile missile : this.missiles ) {
            missile.move( );
        }
    }

    private void moveEnemies( ){
        for( AbsEnemy enemy : this.enemies ){
            enemy.move( );
        }
    }

    private void moveGameObjects( ){
        moveEnemies( );
        moveMissiles( );
        destroyInvisibleGameObjects( );
        handleCollisions( );
        notifyObservers( );
    }

    // ### Private domain methods END

    // ### Observer BEGIN

    @Override
    public void attachObserver( IObserver observer ){
        if( !this.myObservers.contains( observer ) ){
            this.myObservers.add( observer );
        }
    }

    @Override
    public void detachObserver( IObserver observer ){
        this.myObservers.remove( observer );
    }

    @Override
    public void notifyObservers( ){
        for( IObserver observer : this.myObservers ){
            observer.update( );
        }
    }

    @Override
    public void cannonShoot() {
        this.missiles.addAll(this.cannon.shoot());
        this.notifyObservers();
    }

    @Override
    public void cannonToggleMode() {
        this.cannon.toggleMode();
        this.notifyObservers();
    }

    @Override
    public void decCannonPower( ){
        this.cannon.decPower( );
        notifyObservers( );
    }

    @Override
    public void incCannonPower( ){
        this.cannon.incPower( );
        notifyObservers( );
    }

    @Override
    public void aimCannonDown( ){
        this.cannon.aimDown( );
        notifyObservers( );
    }

    @Override
    public void aimCannonUp( ){
        this.cannon.aimUp( );
        notifyObservers( );
    }

    // ### Observer END

    @Override
    public Object createMemento( ){
        Memento memento = new Memento( );
        memento.score = this.score;
        memento.cannon = this.cannon;
        memento.info = this.modelInfo ;
        memento.enemies.addAll(enemies);
        memento.missiles.addAll(missiles);
        memento.collisions.addAll(collisions);
        memento.gameObjectsFactory = goFact;
        memento.movementStrategies.addAll( movementStrategies );
        memento.activeMovementStrategyIndex = activeMovementStrategyIndex;
        memento.gravity = gravity;
        memento.observers.addAll( myObservers );
        memento.unexecutedCommands.addAll( unexecutedCmds );
        memento.executedCommands.addAll( executedCmds );
        return memento;
    }

    private class Memento{
        public int score;
        public AbsCannon cannon;
        public AbsModelInfo info;
        public List<AbsEnemy> enemies = new ArrayList<>( );
        public List<AbsMissile> missiles = new ArrayList<>( );
        public List<AbsCollision> collisions = new ArrayList<>( );
        public IGameObjsFact gameObjectsFactory;
        public List<IMovingStrategy> movementStrategies = new ArrayList<>( );
        public int activeMovementStrategyIndex = 0;
        public float gravity = MvcGameConfig.INIT_GRAVITY;
        public List<IObserver> observers = new ArrayList<>( );
        public Queue<AbsCommand> unexecutedCommands = new LinkedBlockingQueue<>( );
        public Stack<AbsCommand> executedCommands = new Stack<>( );
    }

    @Override
    public void setMemento( Object memento ){
        Memento m = ( Memento ) memento;
        this.score = m.score;
        this.cannon = m.cannon;
        this.modelInfo = m.info;
        this.enemies = new ArrayList<>( );
        this.enemies.addAll( m.enemies );
        this.missiles = new ArrayList<>( );
        this.missiles.addAll( m.missiles );
        this.collisions = new ArrayList<>( );
        this.collisions.addAll( m.collisions );
        this.goFact = m.gameObjectsFactory;
        this.movementStrategies = m.movementStrategies;
        this.activeMovementStrategyIndex = m.activeMovementStrategyIndex;
        this.gravity = m.gravity;
        this.myObservers = m.observers;
        this.unexecutedCmds = new LinkedBlockingQueue<>( );
        this.unexecutedCmds.addAll( m.unexecutedCommands );
        this.executedCmds = new Stack<>( );
        this.executedCmds.addAll( m.executedCommands );
        if( !this.executedCmds.empty( ) ){
            this.executedCmds.pop( );
        }

    }

    public String getCannonActiveShootingMode( ){
        return this.cannon.getModeName( );
    }

    @Override
    public void registerCmd( AbsCommand command ) {
        this.unexecutedCmds.add( command );

    }

    @Override
    public void undoLastCmd() {
        this.executedCmds.pop( );
        if( !executedCmds.empty( ) ){
            AbsCommand command = this.executedCmds.pop( );
            command.unexecute( );
        }
        this.notifyObservers();
    }

    public List<AbsCollision> getCollisions( ){
        return this.collisions;
    }

    private void handleCollisions( ){
        List<AbsMissile> missilesToRemove = new ArrayList<>( );
        List<AbsEnemy> enemiesToRemove = new ArrayList<>( );
        for( AbsMissile missile : this.missiles ){
            for( AbsEnemy enemy : this.enemies ){
                if( missile.collidesWith( enemy ) ){
                    missilesToRemove.add( missile );
                    enemiesToRemove.add( enemy );
                    this.score++;
                    collisions.add( goFact.createCollision( enemy.getX( ), enemy.getY( ) ) );
                }

            }
        }
        List<AbsCollision> collisionsToRemove = new ArrayList<>( );
        for( AbsCollision collision : this.collisions ){
            if( collision.getAge( ) > MvcGameConfig.COLLISION_LIFETIME ){
                collisionsToRemove.add( collision );
            }
        }
        for( AbsCollision collision : collisionsToRemove ){
            this.collisions.remove( collision );
        }
        for( AbsEnemy enemy : enemiesToRemove ){
            this.enemies.remove( enemy );
        }
        for( AbsMissile missile : missilesToRemove ){
            this.missiles.remove( missile );
        }
        this.notifyObservers( );
    }

    public float getGravity( ){
        return gravity;
    }

    @Override
    public void incGravity( ){
        this.gravity += MvcGameConfig.GRAVITY_STEP;
    }

    @Override
    public void decGravity( ){
        this.gravity -= MvcGameConfig.GRAVITY_STEP;
    }


    private void destroyInvisibleGameObjects( ){
        HashSet<AbsMissile> missilesToRemove = new HashSet<>( );

        for( AbsMissile missile : this.missiles ){
            if( missile.getX( ) < -MvcGameConfig.INVISIBILITY_TOLERANCE_X
                    || missile.getX( ) > this.getMaxX( ) + MvcGameConfig.INVISIBILITY_TOLERANCE_X ){
                missilesToRemove.add( missile );
            }

            if( missile.getY( ) < -MvcGameConfig.INVISIBILITY_TOLERANCE_Y
                    || missile.getY( ) > this.getMaxY( ) + MvcGameConfig.INVISIBILITY_TOLERANCE_Y ){
                missilesToRemove.add( missile );
            }
        }

        for( AbsMissile missile : missilesToRemove ){
            missiles.remove( missile );
        }
    }

    public void initGame( ){
        this.cannon = goFact.createCannon( );
        this.modelInfo = goFact.createModelInfo( );
        for( int i = 0; i < MvcGameConfig.MAX_ENEMIES; i++ ){
            enemies.add( goFact.createEnemy( ) );
            try{
                Thread.sleep( new Random( ).nextInt( 50 ) );
            }catch( InterruptedException ex ){
                Thread.currentThread( ).interrupt( );
            }
        }
    }

    @Override
    public int getScore( ){
        return score;
    }

    @Override
    public int getMaxX( ){
        return MvcGameConfig.MAX_X;
    }

    @Override
    public int getMaxY( ){
        return MvcGameConfig.MAX_Y;
    }

    @Override
    public AbsCannon getCannon( ){
        return this.cannon;
    }

    @Override
    public AbsModelInfo getInfo( ){
        return this.modelInfo;
    }

    @Override
    public List<AbsEnemy> getEnemies( ){
        return this.enemies;
    }

    @Override
    public List<AbsMissile> getMissiles( ){
        return this.missiles;
    }


    @Override
    public IMovingStrategy getActiveMovementStrategy( ){
        return this.movementStrategies.get( this.activeMovementStrategyIndex );
    }

    @Override
    public void switchMovementStrategy( ){
        this.activeMovementStrategyIndex = ( this.activeMovementStrategyIndex + 1 ) % this.movementStrategies.size( );
        this.notifyObservers( );
    }
}
