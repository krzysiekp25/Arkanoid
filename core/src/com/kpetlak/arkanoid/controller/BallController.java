package com.kpetlak.arkanoid.controller;

import com.badlogic.gdx.Gdx;
import com.kpetlak.arkanoid.game.ArkanoidGame;
import com.kpetlak.arkanoid.model.Ball;
import com.kpetlak.arkanoid.model.Platform;
import com.kpetlak.arkanoid.screens.GameplayScreen;

public class BallController {
    public void updatePosition(Ball ball) {
        ball.setX(ball.getX()+ball.getSpeed()*Gdx.graphics.getDeltaTime()*ball.getVector().x);
        ball.setY(ball.getY()+ball.getSpeed()*Gdx.graphics.getDeltaTime()*ball.getVector().y);
    }
    public void checkCollisionAndUpdate(Ball ball, Platform platform, GameplayScreen gameplayScreen) {
        checkWallCollisionAndUpdate(ball, gameplayScreen);
        checkPlatformCollisionAndUpdate(ball, platform);
    }

    private void checkPlatformCollisionAndUpdate(Ball ball, Platform platform) {
        if(ball.getY() <= (platform.getY() + platform.getHeight()) && (ball.getX()>= platform.getX() && (ball.getX() +ball.getWidth()) <= (platform.getX()+platform.getWidth()))) {
            ball.getVector().y *=-1;
            ball.setY(ball.getY() + (((platform.getY()+platform.getHeight()) - ball.getY())));
        }
    }

    private void checkWallCollisionAndUpdate(Ball ball, GameplayScreen gameplayScreen) {
        if(ball.getY()+ball.getHeight() >= ArkanoidGame.HEIGHT) {
            ball.getVector().y *=-1;
            ball.setY(ball.getY() - ((ball.getY() + ball.getHeight()) - ArkanoidGame.HEIGHT));
        }
        if(ball.getY() <= 0){
            gameplayScreen.lose();
        }
        if(ball.getX()+ball.getWidth() >= ArkanoidGame.WIDTH) {
            ball.getVector().x *=-1;
            ball.setX(ball.getX() - ((ball.getX()+ ball.getWidth())-ArkanoidGame.WIDTH));
        }
        if(ball.getX() <= 0) {
            ball.getVector().x *=-1;
            ball.setX(ball.getX() + ((0 - ball.getX())));
        }
    }
}
