package com.kpetlak.arkanoid.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.kpetlak.arkanoid.assets.ScreenAssets;
import com.kpetlak.arkanoid.game.ArkanoidGame;


public abstract class AbstractScreen implements Screen {
    protected ScreenAssets assets;
    protected SpriteBatch batch;
    protected ArkanoidGame game;
    protected Stage stage;
    private OrthographicCamera camera;
    private boolean exit;

    public AbstractScreen(ArkanoidGame game, ScreenAssets assets) {
        this.game = game;
        createCamera();
        stage = new Stage(new StretchViewport(ArkanoidGame.WIDTH, ArkanoidGame.HEIGHT));
        batch = new SpriteBatch();
        Gdx.input.setInputProcessor(stage);
        exit = false;
        loadAssets(assets);
        if(this.assets.manager.update()) {
            init();
        }
    }


    private void loadAssets(ScreenAssets assets) {
        this.assets = assets;
        this.assets.load();
        this.assets.manager.finishLoading();
    }

    private void createCamera() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, ArkanoidGame.WIDTH, ArkanoidGame.HEIGHT);
        camera.update();
    }

    protected abstract void init();

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        clearScreen();
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        if(isExit()) {
            dispose();
            Gdx.app.exit();
        }
    }

    private void clearScreen() {
        //todo specyfikacja
        Gdx.gl.glClearColor(95/255f, 158/255f, 160/255f, 0);
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
        assets.dispose();
        batch.dispose();
        stage.dispose();
    }

    @Override
    public void hide() {

    }

    @Override
    public void resize(int width, int height) {

    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }
}
