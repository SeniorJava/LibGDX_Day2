package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Reload.A;
import com.mygdx.game.StartGame;
import com.uwsoft.editor.renderer.components.additional.ButtonComponent;
import com.uwsoft.editor.renderer.utils.ItemWrapper;


public class day2 extends Stage implements Screen  {

    StartGame game;
    private ItemWrapper root;
    private Viewport viewport;
    private ButtonComponent button = new ButtonComponent();

    public day2(StartGame startGame) {game=startGame;
    }

    @Override
    public void show() {
        viewport = new FitViewport(A.x_pit,A.y_pit);
        game.sh.loadScene("StartScreen", viewport);
        root = new ItemWrapper(game.sh.getRoot());

                ((OrthographicCamera) viewport.getCamera()).position.x = A.x_orig/2;

        Buttons();

    }

    @Override
    public void render(float delta) {

        System.out.print(Gdx.graphics.getFramesPerSecond() + "\n");
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.sh.getEngine().update(Gdx.graphics.getDeltaTime());

    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        //S.saveData();
        game.dispose();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {
       Buttons();
    }

    private void Buttons() {
        game. sh.addComponentsByTagName("button", button.getClass());
    }


}
