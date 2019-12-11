package cz.cvut.fit.miadp.mvcgame.bridge;

import cz.cvut.fit.miadp.mvcgame.model.Position;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class JavaFxGraphics implements IGameGraphicsImplementor {
    protected GraphicsContext gc;

    public JavaFxGraphics(GraphicsContext gc)
    {   
        this.gc = gc;
    }

    @Override
    public void drawImage(String path, Position pos) {
        this.gc.drawImage(
            new Image(path),
            pos.getX(), pos.getY()
        );

    }

    @Override
    public void drawText(String text, Position pos) {
        this.gc.fillText(text, pos.getX(), pos.getY());
    }

    @Override
    public void drawLine(Position startPos, Position endPos) {
        this.gc.strokeLine(startPos.getX(), startPos.getY(), endPos.getX(), endPos.getY());
    }

    @Override
    public void clearRect(int i, int j, int maxX, int maxY) {
        this.gc.clearRect(i,j,maxX,maxY);

    }

}