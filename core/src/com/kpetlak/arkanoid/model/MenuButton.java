package com.kpetlak.arkanoid.model;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MenuButton {
    private TextButton labelToolTip;
    public MenuButton() {
        Skin skin = new Skin();
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        skin.add("white", new Texture(pixmap));
        skin.add("default", new BitmapFont());

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("white", new Color(0, 0, 0, 1));
        textButtonStyle.font = skin.getFont("default");
        skin.add("default", textButtonStyle);

        labelToolTip = new TextButton("TEST", skin);
        labelToolTip.setX(50);
        labelToolTip.setY(50);
        labelToolTip.setWidth(125);
        labelToolTip.setVisible(true);
        labelToolTip.getLabel().setWrap(true);
        labelToolTip.setHeight(labelToolTip.getLabel().getHeight());
    }

    public TextButton getLabelToolTip() {
        return labelToolTip;
    }
}
