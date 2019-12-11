package cz.cvut.fit.miadp.mvcgame.view;

import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainWindow extends JFrame {


    public MainWindow( final IGameModel model ){
        try{
            Canvas view = new Canvas( 0, 0, model.getMaxX( ), model.getMaxY( ) );
            // wire MVC
            final GameController controller = view.createController( );
            controller.setModel( model );
            view.setModel( model );

            this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            this.setTitle( "The MI-ADP.16 MvcGame" );
            this.setResizable( false );

            Dimension obrazovka = Toolkit.getDefaultToolkit( ).getScreenSize( );
            this.setLocation(
                    ( int ) ( obrazovka.getWidth( ) / 2 - ( model.getMaxX( ) / 2 ) ),
                    ( int ) ( obrazovka.getHeight( ) / 2 - ( model.getMaxY( ) / 2 ) ) );

            this.addKeyListener( new KeyAdapter( ){
                @Override
                public void keyPressed( KeyEvent evt ){
                    controller.onKeyPress( evt );

                }
            } );

            this.add( view );
            this.pack( );
        } catch( Exception ex ){
            ex.printStackTrace( System.err );
        }
    }

    public void showHelp( ){
        JOptionPane.showMessageDialog( this,
                "Controls: \n"
                        + "here goes some description..." );
    }
}
