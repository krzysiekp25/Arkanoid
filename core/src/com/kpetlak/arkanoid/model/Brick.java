package com.kpetlak.arkanoid.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.kpetlak.arkanoid.assets.ScreenAssets;

public class Brick extends Image {
    /*Vector2 leftDownCollisionPoint;
    Vector2 leftUpCollisionPoint;
    Vector2 rightDownCollisionPoint;
    Vector2 rightUpCollisionPoint;*/

    public Brick(ScreenAssets assets, float x, float y) {
        super(assets.manager.get("bricks/brick.png", Texture.class));
        setX(x);
        setY(y);
        //Texture ballTexture = assets.manager.get("ball/ball.png", Texture.class);

        /*leftDownCollisionPoint = new Vector2();
        leftDownCollisionPoint.x = getX();
        leftDownCollisionBox.y = getY();

        leftUpCollisionBox = new Rectangle();
        leftUpCollisionBox.x = getX();
        leftUpCollisionBox.y = getY()+getHeight()-ballTexture.getHeight();

        rightDownCollisionBox = new Rectangle();
        rightDownCollisionBox.x = getX()+getWidth()-ballTexture.getWidth();
        rightDownCollisionBox.y = getY();
        rightDownCollisionBox.width = ballTexture.getWidth();
        rightDownCollisionBox.height = ballTexture.getHeight();

        rightUpCollisionBox = new Rectangle();
        rightUpCollisionBox.x = getX()+getWidth()-ballTexture.getWidth();
        rightUpCollisionBox.y = getY()+getHeight()-ballTexture.getHeight();
        rightUpCollisionBox.width = ballTexture.getWidth();
        rightUpCollisionBox.height = ballTexture.getHeight();*/
    }

    /*public Rectangle getLeftDownCollisionBox() {
        return leftDownCollisionBox;
    }

    public Rectangle getLeftUpCollisionBox() {
        return leftUpCollisionBox;
    }

    public Rectangle getRightDownCollisionBox() {
        return rightDownCollisionBox;
    }

    public Rectangle getRightUpCollisionBox() {
        return rightUpCollisionBox;
    }*/
}
