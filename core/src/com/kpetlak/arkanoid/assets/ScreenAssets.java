package com.kpetlak.arkanoid.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.Disposable;

public interface ScreenAssets extends Disposable {
    AssetManager manager = new AssetManager();
    void load();
}
