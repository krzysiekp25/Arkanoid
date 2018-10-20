package com.kpetlak.arkanoid.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.kpetlak.arkanoid.game.ArkanoidGame;


public abstract class AbstractScreen implements Screen {
    protected SpriteBatch batch;
    protected ArkanoidGame game;
    protected Stage stage;

    public AbstractScreen(ArkanoidGame game) {
        this.game = game;
        stage = new Stage(new StretchViewport(ArkanoidGame.WIDTH, ArkanoidGame.HEIGHT));
        batch = new SpriteBatch();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        clearScreen();
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(0, 1, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void pause() {
        game.setPaused(true);
    }

    @Override
    public void resume() {
        game.setPaused(false);
    }

    @Override
    public void dispose() {
        game.dispose();
    }

    @Override
    public void hide() {

    }

    @Override
    public void resize(int width, int height) {

    }
}
