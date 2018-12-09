package com.kpetlak.arkanoid.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.kpetlak.arkanoid.assets.ScreenAssets;

public class GameButton {

    private TextButton button;

    public GameButton(String text, ScreenAssets assets, float x, float y, BitmapFont font) {
        Skin skin = new Skin();
        skin.add("normal", assets.manager.get("button/normal_button2.png", Texture.class));
        skin.add("hover", assets.manager.get("button/hover_button2.png", Texture.class));
        skin.add("pressed", assets.manager.get("button/pressed_button2.png", Texture.class));
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.getDrawable("normal");
        textButtonStyle.over = skin.getDrawable("hover");
        textButtonStyle.down = skin.getDrawable("pressed");
        textButtonStyle.font = font;

        button = new TextButton(text, textButtonStyle);
        button.setHeight(100);
        button.setWidth(300);
        button.setX(x);
        button.setY(y);
    }

    public TextButton getButton() {
        return button;
    }
}
