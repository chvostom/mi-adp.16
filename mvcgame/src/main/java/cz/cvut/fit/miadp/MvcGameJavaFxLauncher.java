package cz.cvut.fit.miadp;

import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.proxy.GameModelProxy;
import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;
import cz.cvut.fit.miadp.mvcgame.view.MainWindow;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

import cz.cvut.fit.miadp.mvcgame.MvcGame;
import cz.cvut.fit.miadp.mvcgame.bridge.GameGraphics;
import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphicsImplementor;
import cz.cvut.fit.miadp.mvcgame.bridge.JavaFxGraphics;

import javax.swing.*;

public class MvcGameJavaFxLauncher extends Application {

    private static final MvcGame theMvcGame = new MvcGame();

    @Override
    public void init() {
        theMvcGame.init();
    }

    @Override
    public void start(Stage stage) {
        String winTitle = theMvcGame.getWindowTitle();
        int winWidth = theMvcGame.getWindowWidth();
        int winHeigth = theMvcGame.getWindowHeight();

        stage.setTitle( winTitle );

        Group root = new Group();
        Scene theScene = new Scene( root );
        stage.setScene( theScene );
            
        Canvas canvas = new Canvas( winWidth, winHeigth );
        root.getChildren().add( canvas );
            
        GraphicsContext gc = canvas.getGraphicsContext2D();
        IGameGraphicsImplementor gr_impl = new JavaFxGraphics(gc);
        IGameGraphics gr = new GameGraphics(gr_impl);

        ArrayList<String> pressedKeysCodes = new ArrayList<String>();
 
        theScene.setOnKeyPressed(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
 
                    // only add once... prevent duplicates
                    if ( !pressedKeysCodes.contains(code) )
                        pressedKeysCodes.add( code );
                }
            }
        );
 
        theScene.setOnKeyReleased(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    pressedKeysCodes.remove( code );
                }
            }
        );

        // the game-loop
        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                // Clear the canvas
                // gc.clearRect(0, 0, winWidth, winHeigth);
    
                theMvcGame.processPressedKeys(pressedKeysCodes);
                theMvcGame.update();
                theMvcGame.render(gr);
            }
        }.start();
            
        stage.show();
    }

    public static void main(String[] args) {
                final IGameModel model = new GameModel( );
                final IGameModel proxy = new GameModelProxy( model );
                SwingUtilities.invokeLater(new Runnable( ){
                    @Override
                    public void run( ){
                        new MainWindow( proxy ).setVisible( true );
                    }} );
                //launch();
    }

}