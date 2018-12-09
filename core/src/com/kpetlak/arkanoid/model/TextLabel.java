package com.kpetlak.arkanoid.model;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;

public class TextLabel {
    private Label textLabel;

    public TextLabel(String text, float x, float y, BitmapFont font) {
        Label.LabelStyle style = new Label.LabelStyle();
        style.font = font;
        textLabel = new Label(text, style);

        textLabel.setX(x);
        textLabel.setY(y);
        textLabel.setWidth(300);
        textLabel.setHeight(100);
        textLabel.setAlignment(Align.center);
    }

    public Label getTextLabel() {
        return textLabel;
    }
}
