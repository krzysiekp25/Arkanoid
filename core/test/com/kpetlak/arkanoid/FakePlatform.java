package com.kpetlak.arkanoid;

import com.badlogic.gdx.graphics.Texture;
import com.kpetlak.arkanoid.model.AbstractPlatform;

public class FakePlatform extends AbstractPlatform {

    public FakePlatform(Texture texture) {
        super(texture);
    }

    @Override
    public int getSpeed() {
        return 0;
    }
}
