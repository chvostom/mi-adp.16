package cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyA;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fit.miadp.mvcgame.abstractFactory.IGameObjsFact;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.state.DoubleShootingMode;
import cz.cvut.fit.miadp.mvcgame.state.IShootingMode;
import cz.cvut.fit.miadp.mvcgame.state.SimpleShootingMode;

public class Cannon extends AbsCannon {

    private IGameObjsFact goFact;
    private ArrayList<AbsMissile> batch;
    private IShootingMode mode;

    private static IShootingMode SINGLE_MODE = new SimpleShootingMode();
    private static IShootingMode DOUBLE_MODE = new DoubleShootingMode();

    public Cannon( IGameObjsFact goFact ) {
        super( );
        this.goFact = goFact;
        this.useSingleMode();
    }

    public Cannon( Cannon cannon ){
        super( cannon );
        this.goFact = cannon.goFact;
        this.power = cannon.power;
        this.angle = cannon.angle;
        this.mode = cannon.mode;
    }

    @Override
    public void move( ){

    }

    @Override
    public List<AbsMissile> shoot( ) {
        this.batch = new ArrayList<AbsMissile>( );
        this.mode.shoot(this );
        return this.batch;
    }

    public void toggleMode( ) {
        this.mode.nextMode(this);
    }


    @Override
    public AbsMissile primitiveShoot() {
        AbsMissile m = this.goFact.createMissile();
        m.setX( this.getX( ) );
        m.setY( this.getY( ) );
        this.batch.add( m );
        return m;
    }


    @Override
    public void useSingleMode() {
        this.mode = SINGLE_MODE;

    }

    @Override
    public void useDoubleMode() {
        this.mode = DOUBLE_MODE;

    }

    @Override
    public String getModeName() {
        return this.mode.getName();
    }

    @Override
    public void decPower( ){
        if( this.power - MvcGameConfig.POWER_STEP < MvcGameConfig.FLOAT_COMPARISON_EPSILON ){
            // Power shouldn't be lower or equal to zero
            return;
        }

        this.power -= MvcGameConfig.POWER_STEP;
        this.power = ( float ) ( Math.round( this.power * Math.pow( 10, MvcGameConfig.FLOAT_ROUNDING_SCALE ) ) / Math.pow( 10, MvcGameConfig.FLOAT_ROUNDING_SCALE ) );
    }

    @Override
    public void incPower( ){
        this.power += MvcGameConfig.POWER_STEP;
        this.power = ( float ) ( Math.round( this.power * Math.pow( 10, MvcGameConfig.FLOAT_ROUNDING_SCALE ) ) / Math.pow( 10, MvcGameConfig.FLOAT_ROUNDING_SCALE ) );
    }

    @Override
    public void aimDown( ){
        if( this.angle + MvcGameConfig.ANGLE_STEP > 1.5f ){
            return;
        }
        this.angle += MvcGameConfig.ANGLE_STEP;
        this.angle = ( float ) ( Math.round( this.angle * Math.pow( 10, MvcGameConfig.FLOAT_ROUNDING_SCALE ) ) / Math.pow( 10, MvcGameConfig.FLOAT_ROUNDING_SCALE ) );
    }

    @Override
    public void aimUp( ){
        if( this.angle - MvcGameConfig.ANGLE_STEP < -1.5f ){
            return;
        }
        this.angle -= MvcGameConfig.ANGLE_STEP;
        this.angle = ( float ) ( Math.round( this.angle * Math.pow( 10, MvcGameConfig.FLOAT_ROUNDING_SCALE ) ) / Math.pow( 10, MvcGameConfig.FLOAT_ROUNDING_SCALE ) );
    }

}
