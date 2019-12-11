package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import cz.cvut.fit.miadp.mvcgame.model.GameObject;
import cz.cvut.fit.miadp.mvcgame.model.LifetimeLimitedGameObject;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

abstract public class AbsEnemy extends LifetimeLimitedGameObject {

    public AbsEnemy( ) {
        super( );
    }

    public AbsEnemy( AbsEnemy enemy ) {
        super( enemy );
    }

    public void accept( IVisitor visitor ) {
        visitor.visitEnemy(this );
    }
}
