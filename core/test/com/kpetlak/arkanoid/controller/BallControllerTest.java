package com.kpetlak.arkanoid.controller;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.kpetlak.arkanoid.FakeBall;
import com.kpetlak.arkanoid.FakePlatform;
import com.kpetlak.arkanoid.GameTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BallControllerTest extends GameTest {

    @Test
    public void checkCollisionAndUpdate() {

    }

    @Test
    public void setStartingVector() {
        Texture fakePlatformTexture = new Texture(100, 15, Pixmap.Format.RGB888);
        Texture fakeBallTexture = new Texture(14, 14, Pixmap.Format.RGB888);

        FakePlatform fakePlatform = new FakePlatform(fakePlatformTexture);
        fakePlatform.setX(20);
        FakeBall fakeBall = new FakeBall(fakeBallTexture);
        fakeBall.setX(60);

        BallController ballController = new BallController();

        ballController.setStartingVector(fakeBall, fakePlatform);
        assertEquals(-0.3, fakeBall.getVector().x, 0.1);
        assertEquals(0.7, fakeBall.getVector().y, 0.1);
    }
}