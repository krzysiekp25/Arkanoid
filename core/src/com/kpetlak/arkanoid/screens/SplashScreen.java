package com.kpetlak.arkanoid.screens;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Timer;
import com.kpetlak.arkanoid.assets.SplashScreenAssets;
import com.kpetlak.arkanoid.game.ArkanoidGame;
import com.kpetlak.arkanoid.model.TextLabel;

public class SplashScreen extends AbstractScreen {

    private BitmapFont font;
    private TextLabel splashInfo;

    public SplashScreen(final ArkanoidGame game) {
        super(game, new SplashScreenAssets());
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                game.setScreen(new MenuScreen(game));
            }
        }, 3);
    }

    protected void init() {
        font = assets.manager.get("fonts/bondi48.fnt", BitmapFont.class);
        splashInfo = new TextLabel("Krzysztof Petlak\nprzedstawia", 210, 250, font);
        stage.addActor(splashInfo.getTextLabel());
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        stage.draw();
        batch.end();
    }
}
