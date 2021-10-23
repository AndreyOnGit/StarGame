package ru.gb.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.gb.base.Sprite;
import ru.gb.math.Rect;

public class Logo extends Sprite {

    private Vector2 vectorVelocity, endPoint;
    private float speed, scaleOfLogo;

    public Logo(Texture texture) {
        super(new TextureRegion(texture));
        endPoint = new Vector2();
        vectorVelocity = new Vector2();
        speed = 0.01f;
        scaleOfLogo = 0.25f;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(worldBounds.getHeight()*scaleOfLogo);
        pos.set(worldBounds.pos);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        endPoint.set(touch);
        vectorVelocity.set(touch.cpy().sub(pos)).setLength(speed);
        return false;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if (endPoint.dst(pos) > speed) pos.add(vectorVelocity);
        else pos.set(endPoint);
    }
}