package com.kpetlak.arkanoid.screens;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.kpetlak.arkanoid.assets.MenuScreenAssets;
import com.kpetlak.arkanoid.game.ArkanoidGame;
import com.kpetlak.arkanoid.model.GameButton;
import com.kpetlak.arkanoid.model.TextLabel;

public class MenuScreen extends AbstractScreen {
    private GameButton startButton;
    private GameButton exitButton;
    private BitmapFont buttonFont;
    private TextLabel textLabel;

    public MenuScreen(final ArkanoidGame game) {
        super(game, new MenuScreenAssets());
        init();
    }

    protected void init() {
        buttonFont = assets.manager.get("fonts/bondi48.fnt", BitmapFont.class);
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        startButton = new GameButton("START", assets, 210, 250, buttonFont);
        startButton.getButton().addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                game.setScreen(new GamePlayScreen(game));
            }
        });
        exitButton = new GameButton("ZAMKNIJ", assets, 210, 140, buttonFont);
        exitButton.getButton().addListener(new ClickListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                setExit(true);
            }
        });

        textLabel = new TextLabel("ARKANOID", 210, 360, buttonFont);
        stage.addActor(textLabel.getTextLabel());
        stage.addActor(exitButton.getButton());
        stage.addActor(startButton.getButton());
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
        stage.act();
    }
}
