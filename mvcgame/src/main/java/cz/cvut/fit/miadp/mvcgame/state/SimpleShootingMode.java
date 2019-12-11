package cz.cvut.fit.miadp.mvcgame.state;

import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCannon;

public class SimpleShootingMode implements IShootingMode {

    @Override
    public void shoot( AbsCannon cannon ) {
        cannon.primitiveShoot( );
    }

    @Override
    public void nextMode( AbsCannon cannon ) {
        cannon.useDoubleMode( );
    }

    @Override
    public String getName( ) {
        return "SimpleShootingMode";
    }

}