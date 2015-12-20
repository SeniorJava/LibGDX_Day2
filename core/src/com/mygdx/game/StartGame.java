package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.Reload.A;

import com.mygdx.game.Screens.Sample;
import com.uwsoft.editor.renderer.SceneLoader;

public class StartGame extends Game {

	public StartGame() {}

	public SceneLoader sh;


	@Override
	public void create() {

		A.x_pit=(float)(Gdx.graphics.getWidth()* A.y_orig)/Gdx.graphics.getHeight();if(A.x_pit<= A.x_orig) A.x_pit= A.x_orig;
		A.y_pit=(float)(Gdx.graphics.getHeight()*A.x_orig)/Gdx.graphics.getWidth();if(A.y_pit<= A.y_orig) A.y_pit= A.y_orig;
		//S.loadData();

		sh = new SceneLoader();

		setScreen(new Sample(this));

	}

}
