package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class GameObject
{
    private Position position;
    protected int skin;

    public int getX( ) {
        return this.position.getX( );
    }

    public int getY( ) {
        return this.position.getY( );
    }

    public void setX( int x ) {
        this.position.setX( x );
    }

    public void setY( int y ) {
        this.position.setY( y );
    }

    public GameObject( ){
        skin = 1;
        position = new Position(100,100 );
    }

    public GameObject( GameObject gameObject ){
        this.skin = gameObject.skin;
        this.position = gameObject.position;
    }

    public int getSkin( ){
        return this.skin;
    }

    public void setSkin( int skin ){
        this.skin = skin;
    }

    public boolean collidesWith( GameObject object ){
        boolean collides = false;
        int aX = this.getX( );
        int aY = this.getY( );
        int bX = object.getX( );
        int bY = object.getY( );
        if( ( Math.abs( aX - bX ) <= MvcGameConfig.COLLIDE_FACTOR ) && ( Math.abs( aY - bY ) <= MvcGameConfig.COLLIDE_FACTOR ) ){
            collides = true;
        }
        return collides;
    }

    abstract public void move( );
    public abstract void accept( IVisitor visitor );

}