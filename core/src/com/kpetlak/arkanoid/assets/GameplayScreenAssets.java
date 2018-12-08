package com.kpetlak.arkanoid.assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;

public class GameplayScreenAssets implements Disposable, ScreenAssets {

    public void load() {
        //todo tekstury to narazie placeholdery i należy stworzyć własne ładne tekstury na koniec
        manager.load("ball/ball.png", Texture.class);
        manager.load("platform/platform.png", Texture.class);
        manager.load("bricks/brick.png", Texture.class);
        manager.load("button/normal_button2.png", Texture.class);
        manager.load("button/hover_button2.png", Texture.class);
        manager.load("button/pressed_button2.png", Texture.class);
    }
    @Override
    public void dispose() {
        manager.dispose();
    }
}
