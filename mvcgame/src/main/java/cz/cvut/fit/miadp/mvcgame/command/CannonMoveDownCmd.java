package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class CannonMoveDownCmd extends AbsCommand {

    public CannonMoveDownCmd( IGameModel rec ) {
        super( rec );
    }

    @Override
    public void execute() {
        this.receiver.moveCannonDown();
    }
}
