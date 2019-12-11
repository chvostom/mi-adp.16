package cz.cvut.fit.miadp.mvcgame.model;


public abstract class LifetimeLimitedGameObject extends GameObject
{
    protected long created;

    public LifetimeLimitedGameObject( ){
        super( );
        created = System.currentTimeMillis( );
    }

    public LifetimeLimitedGameObject( LifetimeLimitedGameObject lifetimeLimitedGameObject ){
        super( lifetimeLimitedGameObject );
        created = lifetimeLimitedGameObject.created;
    }

    public long getAge( ){
        return System.currentTimeMillis( ) - this.created;
    }


}