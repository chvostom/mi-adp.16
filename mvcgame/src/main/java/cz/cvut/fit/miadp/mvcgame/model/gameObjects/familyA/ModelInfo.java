package cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyA;

import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsModelInfo;
import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class ModelInfo extends AbsModelInfo
{
    private IGameModel model;

    public ModelInfo( IGameModel model ){
        super( );
        this.model = model;
    }

    public ModelInfo( ModelInfo modelInfo ){
        super( modelInfo );
        this.model = modelInfo.model;
    }

    @Override
    public void move( ){

    }

    public String getText( ){
        return "Score: " + this.model.getScore( ) + " "
                + "Cannon Y: " + this.model.getCannon( ).getY( ) + " "
                + "Cannon Power: " + this.model.getCannon( ).getPower( ) + " "
                + "Cannon Angle: " + this.model.getCannon( ).getAngle( ) + " "
                + "Active Missiles: " + this.model.getMissiles( ).size( ) + " "
                + "Active strategy: " + this.model.getActiveMovementStrategy( ).getName( ) + " "
                + "Active mode: " + this.model.getCannonActiveShootingMode( ) + " "
                + "Gravity: " + this.model.getGravity( );
    }

}
