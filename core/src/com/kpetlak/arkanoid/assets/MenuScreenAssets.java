package com.kpetlak.arkanoid.assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Disposable;

public class MenuScreenAssets implements Disposable, ScreenAssets {

    @Override
    public void load() {
        manager.load("button/normal_button2.png", Texture.class);
        manager.load("button/hover_button2.png", Texture.class);
        manager.load("button/pressed_button2.png", Texture.class);
        manager.load("fonts/bondi48.fnt", BitmapFont.class);
        //manager.load("button/arial.bmp", BitmapFont.class);
    }

    @Override
    public void dispose() {
        manager.dispose();
    }
}
