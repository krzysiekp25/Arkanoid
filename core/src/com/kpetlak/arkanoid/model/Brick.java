package com.kpetlak.arkanoid.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.kpetlak.arkanoid.assets.ScreenAssets;

public class Brick extends Image {
    private boolean deleted;
    private static int brickLeft = 0;

    public Brick(ScreenAssets assets, float x, float y) {
        super(assets.manager.get("bricks/brick.png", Texture.class));
        setX(x);
        setY(y);
        deleted = false;
        brickLeft++;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
        brickLeft--;
    }

    public static int getBrickLeft() {
        return brickLeft;
    }

    public static void setBrickLeft(int brickLeft) {
        Brick.brickLeft = brickLeft;
    }
}
