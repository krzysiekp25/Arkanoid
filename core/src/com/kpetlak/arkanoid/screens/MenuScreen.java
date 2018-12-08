package com.kpetlak.arkanoid.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.kpetlak.arkanoid.assets.GameplayScreenAssets;
import com.kpetlak.arkanoid.assets.MenuScreenAssets;
import com.kpetlak.arkanoid.game.ArkanoidGame;
import com.kpetlak.arkanoid.model.MenuButton;

public class MenuScreen extends AbstractScreen {
    private MenuButton menuButton;

    public MenuScreen(final ArkanoidGame game) {
        super(game, new MenuScreenAssets());//todo nowe assety do menu
        init();
    }

    protected void init() {
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        menuButton = new MenuButton("start", assets);
        stage.addActor(menuButton.getButton());
        menuButton.getButton().addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new GameplayScreen(game));
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        /*exitButton = new TextButton("ZAMKNIJ", new TextButton.TextButtonStyle());
        stage.addActor(exitButton);*/
    }

    //todo abstrakcyjna metoda render
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
