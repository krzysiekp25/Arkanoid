package com.kpetlak.arkanoid;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.kpetlak.arkanoid.model.AbstractBall;

public class FakeBall extends AbstractBall {

    Vector2 vector;
    public FakeBall(Texture texture) {
        super(texture);
        vector = new Vector2(0.5f, 0.5f);
    }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public Vector2 getVector() {
        return vector;
    }
}
