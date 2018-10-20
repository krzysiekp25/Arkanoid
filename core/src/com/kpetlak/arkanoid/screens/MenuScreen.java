package com.kpetlak.arkanoid.screens;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

import com.kpetlak.arkanoid.game.ArkanoidGame;

public class MenuScreen extends AbstractScreen {
    private BitmapFont font;

    public MenuScreen(ArkanoidGame game) {
        super(game);
        init();
    }

    private void init() {
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
