package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class LifetimeLimitedGameObjectTest {

    @Test
    public void getLifetime( ){
        LifetimeLimitedGameObject lao = new LifetimeLimitedGameObject( ){
            @Override
            public void move( ){

            }

            @Override
            public void accept( IVisitor visitor ){

            }
        };
        long age1 = lao.getAge( );
        int wait = new Random( ).nextInt( 500 );
        try{
            Thread.sleep( wait );
        }catch( InterruptedException ex ){
            Thread.currentThread( ).interrupt( );
        }
        long age2 = lao.getAge( );
        assertTrue( age1 + wait <= age2 );
    }
}
