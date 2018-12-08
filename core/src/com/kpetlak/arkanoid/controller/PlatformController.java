package com.kpetlak.arkanoid.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.kpetlak.arkanoid.game.ArkanoidGame;
import com.kpetlak.arkanoid.model.Platform;

public class PlatformController {
    //todo przechowuje instancje platformy i wywołuje metody przekształcające platformę, które aktualnie wykonywane są w application
    //todo tak samo dla piłeczki i brick
    public void updatePosition(Platform platform) {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            platform.setX(platform.getX()-platform.getSpeed()*Gdx.graphics.getDeltaTime());
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            platform.setX(platform.getX()+platform.getSpeed()*Gdx.graphics.getDeltaTime());
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
}
