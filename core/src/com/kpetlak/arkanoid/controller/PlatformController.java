package com.kpetlak.arkanoid.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.kpetlak.arkanoid.game.ArkanoidGame;
import com.kpetlak.arkanoid.model.Ball;
import com.kpetlak.arkanoid.model.Platform;

public class PlatformController {
    public void updatePosition(Platform platform) {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            platform.setX(platform.getX()-platform.getSpeed()*Gdx.graphics.getDeltaTime());
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            platform.setX(platform.getX()+platform.getSpeed()*Gdx.graphics.getDeltaTime());
        }
    }

    public void updatePositionBeforeStart(Platform platform, Ball ball) {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            platform.setX(platform.getX()-platform.getSpeed()*Gdx.graphics.getDeltaTime());
            ball.setX(ball.getX()-platform.getSpeed()*Gdx.graphics.getDeltaTime());
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            platform.setX(platform.getX()+platform.getSpeed()*Gdx.graphics.getDeltaTime());
            ball.setX(ball.getX()+platform.getSpeed()*Gdx.graphics.getDeltaTime());
        }
    }

    public void checkCollisionAndUpdate(Platform platform) {

        if(platform.getX() <= 0) {
            platform.setX(platform.getX() + (0-platform.getX()));
        }
        if((platform.getX()+platform.getWidth()) >= ArkanoidGame.WIDTH) {
            platform.setX(platform.getX() - ((platform.getX()+platform.getWidth())-ArkanoidGame.WIDTH));
        }
    }

    public void checkCollisionBeforeStartAndUpdate(Platform platform, Ball ball) {
        if(platform.getX() <= 0) {
            float offset = (0-platform.getX());
            platform.setX(platform.getX() + offset);
            ball.setX(ball.getX() + offset);
        }
        if((platform.getX()+platform.getWidth()) >= ArkanoidGame.WIDTH) {
            float offset = (platform.getX()+platform.getWidth())-ArkanoidGame.WIDTH;
            platform.setX(platform.getX() - offset);
            ball.setX(ball.getX() - offset);
        }
    }
}
