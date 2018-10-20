package com.kpetlak.arkanoid.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.kpetlak.arkanoid.assets.ScreenAssets;

public class Platform extends Rectangle {
    private Texture texture;
    private int speed = 500;

    public Platform(ScreenAssets assets) {
        this.texture = assets.manager.get("platform/platform.png", Texture.class);
    }

    public Texture getTexture() {
        return texture;
    }

    public int getSpeed() {
        return speed;
    }
}
