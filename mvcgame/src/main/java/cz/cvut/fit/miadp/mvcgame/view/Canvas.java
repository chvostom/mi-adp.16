package cz.cvut.fit.miadp.mvcgame.view;

import cz.cvut.fit.miadp.mvcgame.visitor.GameRender;
import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.GameObject;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel implements IObserver {
    GameRender drawer = new GameRender();
    IGameModel model;

    public Canvas(int x, int y, int width, int height) {
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setLocation(x, y);
        //this.setBackground( Color.GRAY );
        this.setPreferredSize(new Dimension(width, height));
        this.setVisible(true);
    }

    public GameController createController() {
        return new GameController(this.model);
    }

    public void setModel(IGameModel model) {
        if (this.model != null && this.model != model) {
            this.model.detachObserver(this);
        }

        this.model = model;
        this.model.attachObserver(this);
    }

    @Override
    public void update() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawer.setGraphics((Graphics2D) g);

        if (this.model != null) {
            for (GameObject object : this.model.getGameObjects()) {
                object.accept(drawer);
            }
        }
    }
}

