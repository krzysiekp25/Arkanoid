package com.kpetlak.arkanoid.model;

import com.badlogic.gdx.graphics.Texture;
import com.kpetlak.arkanoid.assets.ScreenAssets;

import java.util.ArrayList;
import java.util.List;

public class BrickList {
    private List<Brick> brickList;

    public BrickList(ScreenAssets assets) {
        Texture brickTexture = assets.manager.get("bricks/brick2.png", Texture.class);
        brickList = new ArrayList<>();
        for (int i = 0; i< 5; i++) {
            for (int j = 0; j<4; j++) {
                float x = i*1.1f*brickTexture.getWidth()+137.25f;
                float y = j*1.1f*brickTexture.getHeight()+240;
                brickList.add(new Brick(assets, x, y));
                //todo rozmieszczenie cegiel
            }
        }
    }

    public List<Brick> getBrickList() {
        return brickList;
    }
}
