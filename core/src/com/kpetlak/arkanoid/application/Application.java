package com.kpetlak.arkanoid.application;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kpetlak.arkanoid.manager.Assets;
import com.kpetlak.arkanoid.model.Ball;
import com.kpetlak.arkanoid.model.Brick;
import com.kpetlak.arkanoid.model.Platform;

import java.util.ArrayList;
import java.util.List;

public class Application extends ApplicationAdapter {

	private Assets assets;
	private SpriteBatch batch;
	private Ball ball;
	private Platform platform;
	private List<List<Brick>> bricks;

	@Override
	public void create () {
		assets = new Assets();
		assets.load();
		assets.manager.finishLoading();
		if(assets.manager.update())
		{
			loadData();
			init();
		}
	}

	@Override
	public void render () {
		update();

		Gdx.gl.glClearColor(0, 1, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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

	private void loadData() {

	}

	private void init() {
		batch = new SpriteBatch();
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

	private void update() {
		handleInput();
	}

	private void handleInput() {
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			platform.x -= platform.getSpeed() * Gdx.graphics.getDeltaTime();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			platform.x += platform.getSpeed() * Gdx.graphics.getDeltaTime();
		}
	}
}
