package com.kpetlak.arkanoid.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.kpetlak.arkanoid.assets.ScreenAssets;

public class Platform extends Image {
    private int speed = 500;

    public Platform(ScreenAssets assets) {
        //todo wyglad platformy
        super(assets.manager.get("platform/platform2.png", Texture.class));
    }

    public int getSpeed() {
        return speed;
    }
}
