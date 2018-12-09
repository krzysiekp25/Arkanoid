package com.kpetlak.arkanoid.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.kpetlak.arkanoid.controller.BallController;
import com.kpetlak.arkanoid.controller.PlatformController;
import com.kpetlak.arkanoid.game.ArkanoidGame;
import com.kpetlak.arkanoid.assets.GamePlayScreenAssets;
import com.kpetlak.arkanoid.model.*;

public class GamePlayScreen extends AbstractScreen {
    private Ball ball;
    private Platform platform;
    private BrickList brickList;
    private BallController ballController;
    private PlatformController platformController;
    private GameButton gameEndButton;

    private boolean gameStarted;
    private boolean endGame;
    private BitmapFont endGameButtonFont;


    public GamePlayScreen(ArkanoidGame game) {
        super(game, new GamePlayScreenAssets());
    }

    protected void init() {
        ballController = new BallController();
        platformController = new PlatformController();
        gameStarted = false;
        initPlatform();
        initBall();
        initBricks();
        endGameButtonFont = assets.manager.get("fonts/bondi18.fnt", BitmapFont.class);
    }

    private void initBricks() {
        brickList = new BrickList(assets);
        for (Brick brick : brickList.getBrickList()) {
            stage.addActor(brick);
        }
    }

    private void initPlatform() {
        platform = new Platform(assets);
        platform.setX(ArkanoidGame.WIDTH/2 - platform.getWidth()/2);
        stage.addActor(platform);
    }

    private void initBall() {
        ball = new Ball(assets);
        ball.setX(MathUtils.random(platform.getX(), (platform.getX()+platform.getWidth())-ball.getWidth()));
        ball.setY(platform.getHeight());
        ballController.setStartingVector(ball, platform);
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
        gameEndButton = new GameButton("Wygrana!\nPrzejdz do menu glownego.", assets, 210, 190, endGameButtonFont);
        setEndGame();
        stage.addActor(gameEndButton.getButton());
        gameEndButton.getButton().addListener(new ClickListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                game.setScreen(new MenuScreen(game));
            }
        });
    }

    public void lose() {
        gameEndButton = new GameButton("Przegrana!\nPrzejdz do menu glownego.", assets, 210, 190, endGameButtonFont);
        setEndGame();
        stage.addActor(gameEndButton.getButton());
        gameEndButton.getButton().addListener(new ClickListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                game.setScreen(new MenuScreen(game));
            }
        });
    }
    private void setEndGame() {
        stage.clear();
        endGame = true;
    }

    private void update() {

        if(!endGame) {
            if (!gameStarted && Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
                gameStarted = true;
            }
            if (gameStarted) {
                ballController.updatePosition(ball);
                platformController.updatePosition(platform);
                ballController.checkCollisionAndUpdate(ball, platform, this);
                platformController.checkCollisionAndUpdate(platform);
                ballController.checkBrickCollisionAndUpdate(ball, brickList.getBrickList(), stage, this);
            } else {
                platformController.updatePositionBeforeStart(platform, ball);
                platformController.checkCollisionBeforeStartAndUpdate(platform, ball);
            }
        }
        stage.act();
    }
}
