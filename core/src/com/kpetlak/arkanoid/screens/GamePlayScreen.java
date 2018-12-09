package com.kpetlak.arkanoid.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.kpetlak.arkanoid.controller.BallController;
import com.kpetlak.arkanoid.controller.BrickController;
import com.kpetlak.arkanoid.controller.PlatformController;
import com.kpetlak.arkanoid.game.ArkanoidGame;
import com.kpetlak.arkanoid.assets.GamePlayScreenAssets;
import com.kpetlak.arkanoid.model.*;

import java.util.List;

public class GamePlayScreen extends AbstractScreen {
    private Ball ball;
    private Platform platform;
    //todo lista czy cos innego?
    private List<List<Brick>> bricks;
    private BrickList brickList;
    private BallController ballController;
    private PlatformController platformController;
    private GameButton gameEndButton;
    //todo prawdopodobnie do usuniecia ze wzgledu na to ze to pilka kontroluje bloczek jesli chodzi o usuniecie i tak dalej
    private BrickController brickController;
    private boolean gameStarted;
    private boolean endGame;
    private BitmapFont endGameButtonFont;


    public GamePlayScreen(ArkanoidGame game) {
        super(game, new GamePlayScreenAssets());
    }

    protected void init() {
        ballController = new BallController();
        platformController = new PlatformController();
        brickController = new BrickController();
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
        /*bricks = new ArrayList<List<Brick>>();
        for (int i = 0; i< 5; i++) {
            bricks.add(new ArrayList<Brick>());
            for (int j = 0; j<4; j++) {
                bricks.get(i).add(new Brick(assets));
                bricks.get(i).get(j).setX(i*1.1f*assets.manager.get("bricks/brick.png", Texture.class).getWidth()+200);
                bricks.get(i).get(j).setY(j*1.1f*assets.manager.get("bricks/brick.png", Texture.class).getHeight()+300);
                stage.addActor(bricks.get(i).get(j));
            }
        }*/
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
