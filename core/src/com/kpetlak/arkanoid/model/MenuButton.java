package com.kpetlak.arkanoid.model;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.kpetlak.arkanoid.assets.ScreenAssets;

public class MenuButton {

    private TextButton button;
    private TextButton.TextButtonStyle textButtonStyle;
    private Skin skin;


    public MenuButton(String text, ScreenAssets assets) {
        skin = new Skin();
        skin.add("up", assets.manager.get("button/normal_button.png", Texture.class));
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.getDrawable("up");
        BitmapFont bitmapFont = new BitmapFont();
        textButtonStyle.font = bitmapFont;
        //textButtonStyle.font = assets.manager.get("button/arial.bmp", BitmapFont.class);
        //textButtonStyle.down = skin.getDrawable("down-button");
        //textButtonStyle.checked = skin.getDrawable("checked-button");
        button = new TextButton(text, textButtonStyle);
        button.setHeight(100);
        button.setWidth(300);
    }

    public TextButton getButton() {
        return button;
    }
}
