package com.kpetlak.arkanoid.manager;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable {

    public final AssetManager manager = new AssetManager();

    public void load() {
        //todo tekstury to narazie placeholdery i należy stworzyć własne ładne tekstury na koniec
        manager.load("ball/ball.png", Texture.class);
        manager.load("platform/platform.png", Texture.class);
        manager.load("bricks/brick.png", Texture.class);
    }
    @Override
    public void dispose() {
        manager.dispose();
    }
}
