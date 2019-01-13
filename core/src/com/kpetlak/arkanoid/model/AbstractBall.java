package com.kpetlak.arkanoid.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public abstract class AbstractBall extends Image {
    public AbstractBall(Texture texture) {
        super(texture);
    }

    public abstract int getSpeed();

    public abstract Vector2 getVector();
}
