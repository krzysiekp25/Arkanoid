package com.kpetlak.arkanoid.assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Disposable;

public class MenuScreenAssets implements Disposable, ScreenAssets {

    @Override
    public void load() {
        manager.load("button/normal_button.png", Texture.class);
        //manager.load("button/arial.bmp", BitmapFont.class);
    }

    @Override
    public void dispose() {

    }
}
