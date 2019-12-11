package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import cz.cvut.fit.miadp.mvcgame.model.GameObject;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsModelInfo extends GameObject {

    public AbsModelInfo( ) {
        super( );
    }

    public AbsModelInfo( AbsModelInfo modelInfo ) {
        super( modelInfo );
    }

    public void accept( IVisitor visitor ) {
        visitor.visitModelInfo(this );
    }

    public abstract String getText();
}
