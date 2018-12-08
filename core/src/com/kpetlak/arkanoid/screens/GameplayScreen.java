package com.kpetlak.arkanoid.screens;

import com.badlogic.gdx.graphics.Texture;
import com.kpetlak.arkanoid.controller.BallController;
import com.kpetlak.arkanoid.controller.BrickController;
import com.kpetlak.arkanoid.controller.PlatformController;
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
    private BallController ballController;
    private PlatformController platformController;
    private BrickController brickController;


    public GameplayScreen(ArkanoidGame game) {
        super(game, new GameplayScreenAssets());
    }

    protected void init() {
        ballController = new BallController();
        platformController = new PlatformController();
        brickController = new BrickController();
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

    public void win() {
        //todo wyświetlić napis i przycisk na planszy poinformowac o wygranej
    }

    public void lose() {
        //todo wyswietlic napis i przycisk o wygranej
        game.setScreen(new MenuScreen(game));
    }

    private void update() {

        ballController.updatePosition(ball);
        platformController.updatePosition(platform);
        ballController.checkCollisionAndUpdate(ball, platform, this);
        platformController.checkCollisionAndUpdate(platform);

        stage.act();
    }
}
