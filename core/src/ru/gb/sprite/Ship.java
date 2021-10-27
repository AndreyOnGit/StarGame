package ru.gb.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.gb.base.Sprite;
import ru.gb.math.Rect;

public class Ship extends Sprite {

    private static final float HEIGHT = 0.2f;

    private Vector2 vectorVelocity, endPoint, vectorUp, vectorLeft;
    private float speed;


    public Ship(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship").split(195, 287)[0][0]);
        endPoint = new Vector2();
        vectorVelocity = new Vector2();
        speed = 0.01f;
        vectorUp = new Vector2(0f, 5 * speed);
        vectorLeft = new Vector2(5 * speed, 0f);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
        pos.set(worldBounds.pos);
    }


    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        endPoint.set(touch);
        vectorVelocity.set(touch.cpy().sub(pos)).setLength(speed);
        return false;
    }

    public boolean keyMove(int keycode) {
        if (keycode == 19) pos.add(vectorUp);
        if (keycode == 20) pos.sub(vectorUp);
        if (keycode == 22) pos.add(vectorLeft);
        if (keycode == 21) pos.sub(vectorLeft);
        endPoint.set(pos);
        return false;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if (endPoint.dst(pos) > speed) pos.add(vectorVelocity);
        else pos.set(endPoint);
    }

}
