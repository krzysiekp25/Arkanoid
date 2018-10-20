package com.kpetlak.arkanoid.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.kpetlak.arkanoid.assets.ScreenAssets;

public class Brick extends Image {

    public Brick(ScreenAssets assets) {
        super(assets.manager.get("bricks/brick.png", Texture.class));
    }
}
