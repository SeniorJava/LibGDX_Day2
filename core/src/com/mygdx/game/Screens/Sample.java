package com.mygdx.game.Screens;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import com.mygdx.game.Reload.A;
import com.mygdx.game.StartGame;
import com.uwsoft.editor.renderer.components.DimensionsComponent;
import com.uwsoft.editor.renderer.components.TransformComponent;
import com.uwsoft.editor.renderer.components.additional.ButtonComponent;
import com.uwsoft.editor.renderer.data.CompositeItemVO;
import com.uwsoft.editor.renderer.data.ProjectInfoVO;
import com.uwsoft.editor.renderer.utils.ItemWrapper;

import java.util.Random;


public class Sample extends Stage implements Screen  {

    StartGame game;
    private ItemWrapper root;
    private Viewport viewport;
    private ButtonComponent button = new ButtonComponent();

    public Sample(StartGame startGame) {game=startGame;
    }

    @Override
    public void show() {
        viewport = new FitViewport(A.x_pit,A.y_pit);
        game.sh.loadScene("MainScene", viewport);
        root = new ItemWrapper(game.sh.getRoot());

        root.getChild("Back").getEntity().getComponent(DimensionsComponent.class).width=A.x_pit;
        root.getChild("Back").getEntity().getComponent(DimensionsComponent.class).height=A.y_pit;
        root.getChild("Back").getEntity().getComponent(TransformComponent.class).x=(A.x_orig-A.x_pit)/2;
        root.getChild("Back").getEntity().getComponent(TransformComponent.class).y=0;

        root.getChild("tree").getEntity().getComponent(DimensionsComponent.class).width+=200;
        root.getChild("tree").getEntity().getComponent(DimensionsComponent.class).height+=200;
        root.getChild("tree").getEntity().getComponent(TransformComponent.class).x=0;
                ((OrthographicCamera) viewport.getCamera()).position.x = A.x_orig/2;

        Buttons();

    }

    @Override
    public void render(float delta) {

        System.out.print(Gdx.graphics.getFramesPerSecond() + "\n");
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        root.getChild("sky1").getEntity().getComponent(TransformComponent.class).x-=2;
        if(root.getChild("sky1").getEntity().getComponent(TransformComponent.class).x
                +root.getChild("sky1").getEntity().getComponent(DimensionsComponent.class).width
                <=(A.x_orig-A.x_pit)/2)
            root.getChild("sky1").getEntity().getComponent(TransformComponent.class).x=A.x_pit + ((A.x_orig - A.x_pit) / 2);

        root.getChild("up").getEntity().getComponent(TransformComponent.class).y-=4;
        if(root.getChild("up").getEntity().getComponent(TransformComponent.class).y
                +root.getChild("up").getEntity().getComponent(DimensionsComponent.class).height
                <=(A.y_orig-A.y_pit)/2)
            root.getChild("up").getEntity().getComponent(TransformComponent.class).y=A.y_pit + ((A.y_orig - A.y_pit) / 2);

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
