package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class CannonMoveUpCmd extends AbsCommand
{
    public CannonMoveUpCmd( IGameModel rec ) {
        super( rec );
    }

    @Override
    public void execute( ) {
        this.receiver.moveCannonUp();
    }
}
