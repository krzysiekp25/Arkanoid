package com.kpetlak.arkanoid.screens;

import com.kpetlak.arkanoid.assets.ScreenAssets;
import com.kpetlak.arkanoid.game.ArkanoidGame;
import com.kpetlak.arkanoid.assets.GameplayScreenAssets;
import com.kpetlak.arkanoid.model.Ball;
import com.kpetlak.arkanoid.model.Brick;
import com.kpetlak.arkanoid.model.Platform;

import java.util.ArrayList;
import java.util.List;

public class GameplayScreen extends AbstractScreen {
    private ScreenAssets assets;
    private Ball ball;
    private Platform platform;
    private List<List<Brick>> bricks;


    public GameplayScreen(ArkanoidGame game) {
        super(game);
        assets = new GameplayScreenAssets();
        assets.load();
        assets.manager.finishLoading();
        if(assets.manager.update()) {
            init();
        }
    }

    private void init() {
        ball = new Ball(assets);
        ball.setX(50);
        ball.setY(50);

        platform = new Platform(assets);

        bricks = new ArrayList<List<Brick>>();
        for (int i = 0; i< 5; i++) {
            bricks.add(new ArrayList<Brick>());
            for (int j = 0; j<4; j++) {
                bricks.get(i).add(new Brick(assets));
                bricks.get(i).get(j).setX(i*1.1f*bricks.get(i).get(j).getTexture().getWidth()+200);
                bricks.get(i).get(j).setY(j*1.1f*bricks.get(i).get(j).getTexture().getHeight()+300);
            }
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(ball.getTexture(), ball.x, ball.y);
        batch.draw(platform.getTexture(), platform.x, platform.y);
        for (List<Brick> list: bricks) {
            for (Brick brick : list) {
                batch.draw(brick.getTexture(), brick.x, brick.y);
            }

        }
        batch.end();
    }
}
