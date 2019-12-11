package cz.cvut.fit.miadp.mvcgame.state;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;

public class DoubleShootingMode implements IShootingMode {

    @Override
    public void shoot(AbsCannon cannon) {
        cannon.aimUp( );
        cannon.primitiveShoot( );
        cannon.aimDown( );
        cannon.aimDown( );
        cannon.primitiveShoot( );
        cannon.aimUp( );
    }

    @Override
    public void nextMode(AbsCannon cannon) {
        cannon.useSingleMode();

    }

    @Override
    public String getName() {
        return "DoubleShootingMode";
    }

}