package com.kpetlak.arkanoid.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.kpetlak.arkanoid.assets.MenuScreenAssets;
import com.kpetlak.arkanoid.game.ArkanoidGame;
import com.kpetlak.arkanoid.model.GameButton;

public class MenuScreen extends AbstractScreen {
    private GameButton startButton;
    private GameButton exitButton;

    public MenuScreen(final ArkanoidGame game) {
        super(game, new MenuScreenAssets());//todo nowe assety do menu
        init();
    }

    protected void init() {
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        startButton = new GameButton("START", assets, 210, 250);
        startButton.getButton().addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                game.setScreen(new GamePlayScreen(game));
            }
        });
        exitButton = new GameButton("ZAMKNIJ", assets, 210, 140);
        exitButton.getButton().addListener(new ClickListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                setExit(true);
            }
        });
        stage.addActor(exitButton.getButton());
        stage.addActor(startButton.getButton());
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();
        batch.begin();
        stage.draw();
        batch.end();
    }

    private void update() {
        stage.act();
    }
}
