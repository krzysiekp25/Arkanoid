package com.kpetlak.arkanoid.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.kpetlak.arkanoid.assets.ScreenAssets;

public class Ball extends Image {
    private int speed = 500;
    private Vector2 vector;

    public Ball(ScreenAssets assets) {
        super(assets.manager.get("ball/ball.png", Texture.class));
        vector = new Vector2(0.5f, 0.5f);
    }

    public int getSpeed() {
        return speed;
    }

    public Vector2 getVector() {
        return vector;
    }
}
