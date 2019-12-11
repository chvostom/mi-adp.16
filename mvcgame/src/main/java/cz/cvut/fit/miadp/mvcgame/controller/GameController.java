package cz.cvut.fit.miadp.mvcgame.controller;

import cz.cvut.fit.miadp.mvcgame.command.CannonMoveDownCmd;
import cz.cvut.fit.miadp.mvcgame.command.CannonMoveUpCmd;
import cz.cvut.fit.miadp.mvcgame.command.CannonShootCmd;
import cz.cvut.fit.miadp.mvcgame.command.UndoLastCmd;
import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

import java.awt.event.KeyEvent;

public class GameController {

    private IGameModel model;

    public GameController( IGameModel model ) {
        this.model = model;
    }

	public void handleKeyPress(String code) {

        switch(code){
            case "UP":
                this.model.registerCmd( new CannonMoveUpCmd( this.model ) );
                break;
            case "DOWN":
                this.model.registerCmd( new CannonMoveDownCmd( this.model ) );
                break;
            case "SPACE":
                this.model.registerCmd( new CannonShootCmd( this.model ) );
                break;
            case "M":
                this.model.cannonToggleMode();
                break;
            case "B":
                this.model.registerCmd( new UndoLastCmd( this.model ) );
                break;
            case "A":
                this.model.aimCannonUp( );
                break;
            case "Y":
                this.model.aimCannonDown( );
                break;
            case "P":
                this.model.incCannonPower( );
                break;
            case "L":
                this.model.decCannonPower( );
                break;
            case "G":
                this.model.incGravity( );
                break;
            case "H":
                this.model.decGravity( );
                break;
            case "D":
                this.model.switchMovementStrategy( );
                break;
            default: 
                //nothing
        }

	}

    public void onKeyPress( KeyEvent evt ){
        switch( evt.getKeyCode( ) ){
            case KeyEvent.VK_UP:
                this.model.registerCmd( new CannonMoveUpCmd( this.model ) );
                break;
            case KeyEvent.VK_DOWN:
                this.model.registerCmd( new CannonMoveDownCmd( this.model ) );
                break;
            case KeyEvent.VK_SPACE:
                this.model.registerCmd( new CannonShootCmd( this.model ) );
                break;
            case KeyEvent.VK_A:
                this.model.aimCannonUp( );
                break;
            case KeyEvent.VK_Y:
                this.model.aimCannonDown( );
                break;
            case KeyEvent.VK_P:
                this.model.incCannonPower( );
                break;
            case KeyEvent.VK_L:
                this.model.decCannonPower( );
                break;
            case KeyEvent.VK_G:
                this.model.incGravity( );
                break;
            case KeyEvent.VK_H:
                this.model.decGravity( );
                break;
            case KeyEvent.VK_M:
                this.model.switchMovementStrategy( );
                break;
            case KeyEvent.VK_D:
                this.model.cannonToggleMode( );
                break;
            case KeyEvent.VK_B:
                this.model.registerCmd( new UndoLastCmd( this.model ) );
                break;
            default:
                //nothing
        }


    }

	public void setModel( IGameModel model ) {
        this.model = model;
    }

    public IGameModel getModel( ) {
        return this.model;
    }

}
