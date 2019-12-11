package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import cz.cvut.fit.miadp.mvcgame.model.LifetimeLimitedGameObject;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

abstract public class AbsCollision extends LifetimeLimitedGameObject {

    public AbsCollision( ) {
        super( );
    }

    public AbsCollision( AbsCollision collision ) {
        super( collision );
    }

    public void accept( IVisitor visitor ) {
        visitor.visitCollision(this );
    }
}
