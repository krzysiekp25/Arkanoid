package com.kpetlak.arkanoid.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.kpetlak.arkanoid.game.ArkanoidGame;
import com.kpetlak.arkanoid.model.Ball;
import com.kpetlak.arkanoid.model.Brick;
import com.kpetlak.arkanoid.model.Platform;
import com.kpetlak.arkanoid.screens.GamePlayScreen;

import java.util.List;
import java.util.logging.Logger;

public class BallController {
    private Logger logger = Logger.getLogger("Ball controller");
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
            float overlappedWidth;
            float overlappedHeight;
            if(ball.getVector().x <0) {
                overlappedWidth = (platform.getX()+platform.getWidth() - ball.getX());
                overlappedHeight = (platform.getY()+platform.getHeight() - ball.getY());
            } else {
                overlappedWidth = (ball.getX()+ball.getWidth() - platform.getX());
                overlappedHeight = (platform.getY()+platform.getHeight() - ball.getY());
            }
            if (overlappedWidth > overlappedHeight) {
                correctBallVector(ball, platform);
                correctBallPositionToPlatform(ball, platform);
            }
        }
    }

    private void correctBallPositionToPlatform(Ball ball, Platform platform) {
        ball.setY(platform.getY()+platform.getHeight());
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
            Brick.setBrickLeft(0);
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

    public void checkBrickCollisionAndUpdate(Ball ball, List<Brick> brickList, Stage stage, GamePlayScreen gamePlayScreen) {
        for (Brick brick: brickList) {
            if(!brick.isDeleted() && ball.getX()+ball.getWidth() >= brick.getX() && ball.getX() <= brick.getX()+brick.getWidth()) {
                if(ball.getY() <= brick.getY()+ brick.getHeight() && ball.getY()+ball.getHeight() >= brick.getY()){//sprawdzam czy kolizja y
                    if(ball.getVector().y < 0 && ball.getVector().x >=0) {
                        float szerokosc = (ball.getX()+ball.getWidth())-brick.getX();
                        float wysokosc = (brick.getY()+brick.getHeight()) - ball.getY();
                        if(szerokosc > wysokosc) {
                            logger.info("gorna");
                            ball.getVector().y *=-1;
                            ball.setY(ball.getY() + ((brick.getY()+brick.getHeight())-ball.getY()));
                        } else {
                            logger.info("lewa");
                            ball.getVector().x *=-1;
                            ball.setX(ball.getX() - ((ball.getX()+ball.getWidth()) - brick.getX()));
                        }
                        //lewy gorny
                    } else if(ball.getVector().y >= 0 && ball.getVector().x >=0) {
                        float szerokosc = (ball.getX()+ball.getWidth())-brick.getX();
                        float wysokosc = (ball.getY()+ball.getHeight()) - brick.getY();
                        if(szerokosc > wysokosc) {
                            logger.info("dolna");
                            ball.getVector().y *=-1;
                            ball.setY(ball.getY() - ((ball.getY()+ball.getHeight()) - brick.getY()));
                        } else {
                            logger.info("lewa");
                            ball.getVector().x *=-1;
                            ball.setX(ball.getX() - ((ball.getX()+ball.getWidth()) - brick.getX()));
                        }
                        //lewy dolny
                    } else if(ball.getVector().y >= 0 && ball.getVector().x <0) {
                        float szerokosc = (brick.getX()+brick.getWidth())-ball.getX();
                        float wysokosc = (ball.getY()+ball.getHeight()) - brick.getY();
                        if(szerokosc > wysokosc) {
                            logger.info("dolna");
                            ball.getVector().y *=-1;
                            ball.setY(ball.getY() - ((ball.getY()+ball.getHeight()) - brick.getY()));
                        } else {
                            logger.info("prawa");
                            ball.getVector().x *=-1;
                            ball.setX(ball.getX() + ((brick.getX()+brick.getWidth()) - ball.getX()));
                        }
                        //prawy dolny
                    } else {
                        float szerokosc = (brick.getX()+brick.getWidth())-ball.getX();
                        float wysokosc = (brick.getY()+brick.getHeight()) - ball.getY();
                        if(szerokosc > wysokosc) {
                            logger.info("gorna");
                            ball.getVector().y *=-1;
                            ball.setY(ball.getY() + ((brick.getY()+brick.getHeight())-ball.getY()));
                        } else {
                            logger.info("prawa");
                            ball.getVector().x *=-1;
                            ball.setX(ball.getX() + ((brick.getX()+brick.getWidth()) - ball.getX()));
                        }
                        //prawy gorny
                    }
                    for (Actor actor: stage.getActors()) {
                        if(actor.getX() == brick.getX() && actor.getY() == brick.getY()) {
                            actor.remove();
                            brick.setDeleted(true);
                            if(Brick.getBrickLeft() == 0) {
                                gamePlayScreen.win();
                            }
                        }
                    }
                }
            }
        }
    }
}
