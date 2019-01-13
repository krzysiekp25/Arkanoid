package com.kpetlak.arkanoid.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

//FOR TEST PURPOSE
public abstract class AbstractPlatform extends Image {

    public AbstractPlatform(Texture texture) {
        super(texture);
    }

    public abstract int getSpeed();
}
