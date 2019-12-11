package cz.cvut.fit.miadp.mvcgame.view;

import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.GameObject;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.proxy.GameModelProxy;
import cz.cvut.fit.miadp.mvcgame.visitor.GameRender;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;
// import javafx.scene.canvas.GraphicsContext;

public class GameView implements IObserver {

	private GameModel model;	
	private IGameGraphics gr;
	private int updateCnt;
	private IVisitor renderer;


	public GameView(GameModel model) {
		this.model = model;
		
		// this.model.setView(this);
		this.model.attachObserver(this);

		this.updateCnt = 1;

		this.renderer = new GameRender();
	}

	public void setGraphics(IGameGraphics gr)
	{
		this.gr = gr;
		this.renderer.setGraphics(gr);
	}

	public GameController makeController() {
		return new GameController( new GameModelProxy(this.model) );
	}

	@Override
	public void update() {
		this.updateCnt++;
	}

	public void render() {
		if(this.updateCnt > 0)
		{
			this.gr.clearRect(0, 0, MvcGameConfig.MAX_X, MvcGameConfig.MAX_Y);

            for(GameObject obj : this.model.getGameObjects())
            {
                obj.accept(this.renderer);
            }

			//
			this.updateCnt = 0;
		}
	}

}
