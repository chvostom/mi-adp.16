package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import cz.cvut.fit.miadp.mvcgame.model.GameObject;
import cz.cvut.fit.miadp.mvcgame.model.LifetimeLimitedGameObject;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsMissile extends LifetimeLimitedGameObject {

    public AbsMissile( ) {
        super( );
    }

    public AbsMissile( AbsMissile missile ) {
        super( missile );
    }

    public void accept( IVisitor visitor ) {
        visitor.visitMissile(this );
    }
}
