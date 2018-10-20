package com.kpetlak.arkanoid.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.kpetlak.arkanoid.game.ArkanoidGame;
import com.kpetlak.arkanoid.assets.GameplayScreenAssets;
import com.kpetlak.arkanoid.model.Ball;
import com.kpetlak.arkanoid.model.Brick;
import com.kpetlak.arkanoid.model.Platform;

import java.util.ArrayList;
import java.util.List;

public class GameplayScreen extends AbstractScreen {
    private Ball ball;
    private Platform platform;
    private List<List<Brick>> bricks;


    public GameplayScreen(ArkanoidGame game) {
        super(game, new GameplayScreenAssets());
    }

    protected void init() {
        initBall();
        initPlatform();
        initBricks();
    }

    private void initBricks() {
        bricks = new ArrayList<List<Brick>>();
        for (int i = 0; i< 5; i++) {
            bricks.add(new ArrayList<Brick>());
            for (int j = 0; j<4; j++) {
                bricks.get(i).add(new Brick(assets));
                bricks.get(i).get(j).setX(i*1.1f*assets.manager.get("bricks/brick.png", Texture.class).getWidth()+200);
                bricks.get(i).get(j).setY(j*1.1f*assets.manager.get("bricks/brick.png", Texture.class).getHeight()+300);
                stage.addActor(bricks.get(i).get(j));
            }
        }
    }

    private void initPlatform() {
        platform = new Platform(assets);
        stage.addActor(platform);
    }

    private void initBall() {
        ball = new Ball(assets);
        ball.setX(50);
        ball.setY(50);
        stage.addActor(ball);
    }


    @Override
    public void render(float delta) {
        super.render(delta);
        update();
        batch.begin();
        stage.draw();
        batch.end();
    }

    private void update() {
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            ball.setX(ball.getX()-ball.getSpeed()*Gdx.graphics.getDeltaTime());
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            ball.setX(ball.getX()+ball.getSpeed()*Gdx.graphics.getDeltaTime());
        }

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            platform.setX(platform.getX()-platform.getSpeed()*Gdx.graphics.getDeltaTime());
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            platform.setX(platform.getX()+platform.getSpeed()*Gdx.graphics.getDeltaTime());
        }
        stage.act();
    }
}
