package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCollision;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsModelInfo;


public interface IVisitor
{
    void visitCannon( AbsCannon go );
    void visitCollision( AbsCollision go );
    void visitEnemy( AbsEnemy go );
    void visitMissile( AbsMissile go );
    void visitModelInfo( AbsModelInfo go );
    void setGraphics( IGameGraphics gr );
}