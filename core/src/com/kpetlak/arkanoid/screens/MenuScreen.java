package com.kpetlak.arkanoid.screens;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

import com.badlogic.gdx.utils.Timer;
import com.kpetlak.arkanoid.assets.GameplayScreenAssets;
import com.kpetlak.arkanoid.game.ArkanoidGame;

public class MenuScreen extends AbstractScreen {
    private BitmapFont font;

    public MenuScreen(final ArkanoidGame game) {
        super(game, new GameplayScreenAssets());//todo nowe assety do menu
        init();
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                game.setScreen(new GameplayScreen(game));
            }
        }, 1);
    }

    protected void init() {
        font = new BitmapFont();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        font.draw(batch, "Menu", ArkanoidGame.WIDTH/2, ArkanoidGame.HEIGHT/2);
        batch.end();
    }
}
