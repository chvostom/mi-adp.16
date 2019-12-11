package cz.cvut.fit.miadp.mvcgame.abstractFactory;

import cz.cvut.fit.miadp.mvcgame.model.gameObjects.*;

public interface IGameObjsFact
{
    AbsCannon createCannon();
    AbsEnemy createEnemy();
    AbsCollision createCollision( int x, int y);
    AbsMissile createMissile();
    AbsModelInfo createModelInfo();
}
