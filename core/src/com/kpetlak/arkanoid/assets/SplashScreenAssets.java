package com.kpetlak.arkanoid.assets;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class SplashScreenAssets implements ScreenAssets {
    @Override
    public void load() {
        manager.load("fonts/bondi48.fnt", BitmapFont.class);
    }

    @Override
    public void dispose() {
        manager.dispose();
    }
}
