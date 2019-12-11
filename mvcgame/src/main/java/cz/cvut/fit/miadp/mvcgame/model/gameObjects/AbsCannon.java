package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import java.util.List;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.GameObject;
import cz.cvut.fit.miadp.mvcgame.model.LifetimeLimitedGameObject;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsCannon extends LifetimeLimitedGameObject {

    public AbsCannon( ) {
        super( );
    }

    public AbsCannon( AbsCannon cannon ) {
        super( cannon );
    }

    public void accept( IVisitor visitor ) {
        visitor.visitCannon(this );
    }


    public abstract List<AbsMissile> shoot();
    public abstract void toggleMode();

	public abstract AbsMissile primitiveShoot();
    public abstract void useSingleMode();
    public abstract void useDoubleMode();

	public abstract String getModeName();
	public abstract void aimUp( );
	public abstract void aimDown( );
    public abstract void incPower( );
    public abstract void decPower( );

    public float getPower( ){
        return this.power;
    }

    public float getAngle( ){
        return this.angle;
    }

    protected float power = MvcGameConfig.INIT_POWER;
    protected float angle = MvcGameConfig.INIT_ANGLE;

}
