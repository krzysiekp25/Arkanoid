package com.kpetlak.arkanoid.controller;

import com.badlogic.gdx.Gdx;
import com.kpetlak.arkanoid.game.ArkanoidGame;
import com.kpetlak.arkanoid.model.Ball;
import com.kpetlak.arkanoid.model.Platform;
import com.kpetlak.arkanoid.screens.GamePlayScreen;

import java.util.logging.Logger;

public class BallController {
    Logger logger = Logger.getLogger("Ball controller");
    public void updatePosition(Ball ball) {
        ball.setX(ball.getX()+ball.getSpeed()*Gdx.graphics.getDeltaTime()*ball.getVector().x);
        ball.setY(ball.getY()+ball.getSpeed()*Gdx.graphics.getDeltaTime()*ball.getVector().y);
    }

    public void checkCollisionAndUpdate(Ball ball, Platform platform, GamePlayScreen gamePlayScreen) {
        checkWallCollisionAndUpdate(ball, gamePlayScreen);
        checkPlatformCollisionAndUpdate(ball, platform);
    }

    private void checkPlatformCollisionAndUpdate(Ball ball, Platform platform) {
        if(ball.getY() <= (platform.getY() + platform.getHeight()) && (ball.getX()+ball.getWidth()>= platform.getX() && (ball.getX() -ball.getWidth()) <= (platform.getX()+platform.getWidth()))) {
            correctBallVector(ball, platform);
        }
    }

    private void correctBallVector(Ball ball, Platform platform) {
        ball.getVector().y *=-1;
        float correction;
        if(ball.getX()>(platform.getWidth()/2+platform.getX())) {
            if (ball.getX() > (platform.getWidth()*3/5)+platform.getX()) {
                if (ball.getX() > (platform.getWidth()*4/5)+platform.getX()) {
                    //>4/5
                    correction = ball.getVector().x+0.2f;
                } else {
                    //>3/5
                    correction = 0.1f;
                }
            } else {
                correction = 0.05f;
                //>1/2
            }
        } else {
            if(ball.getX() <= (platform.getWidth()*2/5)+platform.getX()){
                if(ball.getX() <= (platform.getWidth()*1/5)+platform.getX()){
                    //<=1/5
                    correction = -0.2f;
                }else {
                    //<=2/5
                    correction = -0.1f;
                }
            } else {
                //<=1/2
                correction = -0.05f;
            }
        }
        if(Math.abs(correction+ball.getVector().x) <=0.99) {
            ball.getVector().x = ball.getVector().x + correction;
            ball.getVector().y = 1 - Math.abs(ball.getVector().x);
            logger.info("x: "+ball.getVector().x);
            logger.info("y: "+ball.getVector().y);
        }
    }

    private void checkWallCollisionAndUpdate(Ball ball, GamePlayScreen gamePlayScreen) {
        if(ball.getY()+ball.getHeight() >= ArkanoidGame.HEIGHT) {
            ball.getVector().y *=-1;
            ball.setY(ball.getY() - ((ball.getY() + ball.getHeight()) - ArkanoidGame.HEIGHT));
            return;
        }
        if(ball.getY() <= 0){
            gamePlayScreen.lose();
            return;
        }
        if(ball.getX()+ball.getWidth() >= ArkanoidGame.WIDTH) {
            ball.getVector().x *=-1;
            ball.setX(ball.getX() - ((ball.getX()+ ball.getWidth())-ArkanoidGame.WIDTH));
            return;
        }
        if(ball.getX() <= 0) {
            ball.getVector().x *=-1;
            ball.setX(ball.getX() + ((0 - ball.getX())));
        }
    }

    public void setStartingVector(Ball ball, Platform platform) {
        if(ball.getX()>(platform.getWidth()/2+platform.getX())) {
            if (ball.getX() > (platform.getWidth()*3/5)+platform.getX()) {
                if (ball.getX() > (platform.getWidth()*4/5)+platform.getX()) {
                    //>4/5
                    ball.getVector().x = 0.6f;
                    ball.getVector().y = 0.4f;
                } else {
                    //>3/5
                    ball.getVector().x = 0.3f;
                    ball.getVector().y = 0.7f;
                }
            } else {
                ball.getVector().x = 0.15f;
                ball.getVector().y = 0.85f;
                //>1/2
            }
        } else {
            if(ball.getX() <= (platform.getWidth()*2/5)+platform.getX()){
                if(ball.getX() <= (platform.getWidth()*1/5)+platform.getX()){
                    //<=1/5
                    ball.getVector().x = -0.6f;
                    ball.getVector().y = 0.4f;
                }else {
                    //<=2/5
                    ball.getVector().x = -0.3f;
                    ball.getVector().y = 0.7f;
                }
            } else {
                //<=1/2
                ball.getVector().x = -0.15f;
                ball.getVector().y = 0.85f;
            }
        }
    }
}
