package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.*;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class GameRender implements IVisitor {

    private Graphics2D g;
    private IGameGraphics gr;

    private BufferedImage cannonImage;
    private BufferedImage enemyImage1;
    private BufferedImage enemyImage2;
    private BufferedImage enemyImage3;
    private BufferedImage missileImage1;
    private BufferedImage missileImage2;
    private BufferedImage missileImage3;
    private BufferedImage missileImage4;
    private BufferedImage collisionImage;

    MediaPlayer mp1 = new MediaPlayer(new Media(getClass().getResource("/sounds/collision1.mp3").toString()));
    MediaPlayer mp2 = new MediaPlayer(new Media(getClass().getResource("/sounds/collision2.mp3").toString()));


    public GameRender( ){
        try{
            cannonImage = ImageIO.read( getClass( ).getResourceAsStream( "/images/cannon.png" ) );
            enemyImage1 = ImageIO.read( getClass( ).getResourceAsStream( "/images/enemy1.png" ) );
            enemyImage2 = ImageIO.read( getClass( ).getResourceAsStream( "/images/enemy2.png" ) );
            enemyImage3 = ImageIO.read( getClass( ).getResourceAsStream( "/images/enemy3.png" ) );
            missileImage1 = ImageIO.read( getClass( ).getResourceAsStream("/images/missile1.png") );
            missileImage2 = ImageIO.read( getClass( ).getResourceAsStream( "/images/missile2.png" ) );
            missileImage3 = ImageIO.read( getClass( ).getResourceAsStream( "/images/missile3.png" ) );
            missileImage4 = ImageIO.read( getClass( ).getResourceAsStream( "/images/missile4.png" ) );
            collisionImage = ImageIO.read( getClass( ).getResourceAsStream( "/images/collision.png" ) );

        } catch( IOException ex ){
            ex.printStackTrace( System.err );
        }
    }

    public void setGraphics( Graphics2D g ){
        this.g = g;
    }

    public void drawCannon( Graphics2D g, AbsCannon cannon ){

        AffineTransform backup = g.getTransform( );

        AffineTransform transform = AffineTransform.getRotateInstance( cannon.getAngle( ),
                cannon.getX( ) + ( cannonImage.getWidth( ) / 4.0 ),
                cannon.getY( ) + ( cannonImage.getHeight( ) / 4.0 ) );

        g.setTransform( transform );

        g.drawImage( cannonImage,
                cannon.getX( ) - cannonImage.getWidth( ) / 2,
                cannon.getY( ) - cannonImage.getHeight( ) / 2, null );

        g.setTransform( backup );
    }

    public void drawMissile( Graphics2D g, AbsMissile missile ){
        BufferedImage missileImage;
        if ( missile.getSkin( ) == 1 ) {
            missileImage = missileImage1;
        }
        else if ( missile.getSkin( ) == 2 ) {
            missileImage = missileImage2;
        }
        else if ( missile.getSkin( ) == 3 ) {
            missileImage = missileImage3;
        }
        else {
            missileImage = missileImage4;
        }
        g.drawImage( missileImage,
                missile.getX( ) - missileImage.getWidth( ) / 2,
                missile.getY( ) - missileImage.getHeight( ) / 2, null );
    }

    public void drawEnemy( Graphics2D g, AbsEnemy enemy ){

        BufferedImage enemyImage;
        if( enemy.getSkin( ) == 1 ){
            enemyImage = enemyImage1;
        }
        else if( enemy.getSkin( ) == 2 ){
            enemyImage = enemyImage2;
        }
        else{
            enemyImage = enemyImage3;
        }

        g.drawImage( enemyImage,
                enemy.getX( ) - enemyImage2.getWidth( ) / 2,
                enemy.getY( ) - enemyImage2.getHeight( ) / 2, null );
    }

    public void drawCollision( Graphics2D g, AbsCollision collision ){
        g.drawImage( collisionImage,
                collision.getX( ) - collisionImage.getWidth( ) / 2,
                collision.getY( ) - collisionImage.getHeight( ) / 2, null );
    }

    public void drawInfo( Graphics2D g, AbsModelInfo info ){
        g.drawString( info.getText( ), info.getX( ), info.getY( ) );
    }

    public void playCollisionSound( ) {
        Random rng = new Random( );
        if ( rng.nextInt(100) % 2 == 0 ) {
            mp1.stop( );
            mp2.stop( );
            mp1.play( );
        }
        else {
            mp1.stop( );
            mp2.stop( );
            mp2.play( );
        }
    }

    @Override
    public void visitCannon( AbsCannon cannon ){
        if( g == null ){
            return;
        }
        drawCannon( g, cannon );
    }

    @Override
    public void visitCollision( AbsCollision collision ){
        if( g == null ){
            return;
        }
        this.playCollisionSound( );
        drawCollision( g, collision );
    }

    @Override
    public void visitEnemy( AbsEnemy enemy ){
        if( g == null ){
            return;
        }
        drawEnemy( g, enemy );
    }

    @Override
    public void visitMissile( AbsMissile missile ){
        if( g == null ){
            return;
        }
        drawMissile( g, missile );
    }

    @Override
    public void visitModelInfo( AbsModelInfo modelInfo ){
        if( g == null ){
            return;
        }
        drawInfo( g, modelInfo );
    }

    @Override
    public void setGraphics(IGameGraphics gr)
    {
        this.gr = gr;
    }
}
