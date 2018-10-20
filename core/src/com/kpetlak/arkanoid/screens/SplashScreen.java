package com.kpetlak.arkanoid.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.kpetlak.arkanoid.assets.GameplayScreenAssets;
import com.kpetlak.arkanoid.game.ArkanoidGame;

public class SplashScreen extends AbstractScreen {

    private Texture splashTexture;

    public SplashScreen(final ArkanoidGame game) {
        super(game, new GameplayScreenAssets());//todo stworzyc assety do splashscreen
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                game.setScreen(new MenuScreen(game));
            }
        }, 1);
    }

    protected void init() {
        splashTexture = new Texture("splash/doge.jpg");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(splashTexture, ArkanoidGame.WIDTH/2, ArkanoidGame.HEIGHT/2);
        batch.end();
    }
}
