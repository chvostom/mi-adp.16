package cz.cvut.fit.miadp.mvcgame.bridge;

import cz.cvut.fit.miadp.mvcgame.model.Position;

public interface IGameGraphicsImplementor
{
    void drawImage(String path , Position pos );
    void drawText(String text , Position  pos);
    void drawLine(Position startPos , Position  endPos );
	void clearRect(int i, int j, int maxX, int maxY);
}