package cz.cvut.fit.miadp.mvcgame.model;

public class Position
{
    private int dimX = 0;
	private int dimY = 0;
	
	public Position()
	{
	}

	public Position(Position pos2)
	{
		this.dimX = pos2.getX();
		this.dimY = pos2.getY();
	}

	public Position(int posX, int posY)
	{
		this.dimX = posX;
		this.dimY = posY;
	}

	public int getX() {
		return dimX;
	}
    
    public int getY() {
		return dimY;
	}
    
    public void setY(int y) {
		this.dimY = y;
	}
    
    public void setX(int x) {
		this.dimX = x;
	}

	public void move(int dx, int dy) {
		this.dimX += dx;
		this.dimY += dy;
	}


}