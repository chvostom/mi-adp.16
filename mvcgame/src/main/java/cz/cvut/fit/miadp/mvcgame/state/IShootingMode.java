package cz.cvut.fit.miadp.mvcgame.state;

import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCannon;

public interface IShootingMode {
    void shoot( AbsCannon cannon );
    void nextMode( AbsCannon cannon );
    String getName( );
}
