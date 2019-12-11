package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class UndoLastCmd extends AbsCommand {

    public UndoLastCmd( IGameModel rec ) {
        super( rec );
    }

    @Override
    public void execute( ) {
        this.receiver.undoLastCmd( );
    }
}
