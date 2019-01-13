package com.kpetlak.arkanoid.controller;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.kpetlak.arkanoid.FakeBall;
import com.kpetlak.arkanoid.FakePlatform;
import com.kpetlak.arkanoid.GameTest;
import com.kpetlak.arkanoid.game.ArkanoidGame;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlatformControllerTest extends GameTest {

    @Test
    public void checkPlatformCollisionWithRightWallAndUpdate() {

        Texture texture = new Texture(100, 15, Pixmap.Format.RGB888);

        FakePlatform fakePlatform = new FakePlatform(texture);
        fakePlatform.setX(ArkanoidGame.WIDTH+10);

        PlatformController platformController = new PlatformController();

        platformController.checkCollisionAndUpdate(fakePlatform);
        assertEquals(ArkanoidGame.WIDTH, fakePlatform.getX()+fakePlatform.getWidth(), 0.1);


    }

    @Test
    public void checkPlatformCollisionWithLeftWallAndUpdate() {

        Texture texture = new Texture(100, 15, Pixmap.Format.RGB888);

        FakePlatform fakePlatform = new FakePlatform(texture);
        fakePlatform.setX(-10);

        PlatformController platformController = new PlatformController();

        platformController.checkCollisionAndUpdate(fakePlatform);
        assertEquals(0, fakePlatform.getX(), 0.1);


    }

    @Test
    public void checkCollisionWithLeftWallBeforeStartAndUpdate() {

        Texture fakePlatformTexture = new Texture(100, 15, Pixmap.Format.RGB888);
        Texture fakeBallTexture = new Texture(14, 14, Pixmap.Format.RGB888);

        FakePlatform fakePlatform = new FakePlatform(fakePlatformTexture);
        fakePlatform.setX(-10);
        FakeBall fakeBall = new FakeBall(fakeBallTexture);
        fakeBall.setX(-8);

        PlatformController platformController = new PlatformController();

        platformController.checkCollisionBeforeStartAndUpdate(fakePlatform, fakeBall);
        assertEquals(0, fakePlatform.getX(), 0.1);
        assertEquals(2, fakeBall.getX(), 0.1);
    }

    @Test
    public void checkCollisionWithRightWallBeforeStartAndUpdate() {

        Texture fakePlatformTexture = new Texture(100, 15, Pixmap.Format.RGB888);
        Texture fakeBallTexture = new Texture(14, 14, Pixmap.Format.RGB888);

        FakePlatform fakePlatform = new FakePlatform(fakePlatformTexture);
        fakePlatform.setX(ArkanoidGame.WIDTH+10);
        FakeBall fakeBall = new FakeBall(fakeBallTexture);
        fakeBall.setX(ArkanoidGame.WIDTH+8);

        PlatformController platformController = new PlatformController();

        platformController.checkCollisionBeforeStartAndUpdate(fakePlatform, fakeBall);
        assertEquals(ArkanoidGame.WIDTH, fakePlatform.getX()+fakePlatform.getWidth(), 0.1);
        assertEquals(ArkanoidGame.WIDTH-2, fakeBall.getX()+fakePlatform.getWidth(), 0.1);
    }
}