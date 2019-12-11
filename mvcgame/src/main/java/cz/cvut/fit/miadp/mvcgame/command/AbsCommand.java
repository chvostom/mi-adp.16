package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public abstract class AbsCommand
{
    protected IGameModel receiver;
    protected Object memento;

    public AbsCommand(IGameModel rec)
    {
        this.receiver = rec;
    }

    public void doExecute()
    {
        this.memento = this.receiver.createMemento();
        this.execute();
    }

    public void unexecute()
    {
        if( this.memento == null ) {
            return;
        }
        this.receiver.setMemento( this.memento );
    }

    public abstract void execute( );
}