package com.kpetlak.arkanoid.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.kpetlak.arkanoid.manager.Assets;

public class Brick extends Rectangle {
    private Texture texture;

    public Brick(Assets assets) {
        this.texture = assets.manager.get("bricks/brick.png", Texture.class);
    }

    public Texture getTexture() {
        return texture;
    }
}
