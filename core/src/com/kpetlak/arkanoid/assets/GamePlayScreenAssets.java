package com.kpetlak.arkanoid.assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Disposable;

public class GamePlayScreenAssets implements Disposable, ScreenAssets {

    public void load() {

        manager.load("ball/ball.png", Texture.class);
        manager.load("platform/platform2.png", Texture.class);
        manager.load("bricks/brick2.png", Texture.class);
        manager.load("button/normal_button2.png", Texture.class);
        manager.load("button/hover_button2.png", Texture.class);
        manager.load("button/pressed_button2.png", Texture.class);
        manager.load("fonts/bondi18.fnt", BitmapFont.class);
    }
    @Override
    public void dispose() {
        manager.dispose();
    }
}
