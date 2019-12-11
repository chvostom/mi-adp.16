package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class CannonShootCmd extends AbsCommand {

    public CannonShootCmd( IGameModel rec ) {
        super( rec );
    }

    @Override
    public void execute( ) {
        this.receiver.cannonShoot( );
    }
}
