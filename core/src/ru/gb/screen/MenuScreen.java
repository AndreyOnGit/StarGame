package ru.gb.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.gb.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Vector2 touch, endPoint, currentPoint, velocityVector;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        touch = new Vector2();
        endPoint = new Vector2(0f, 0f);
        currentPoint = new Vector2(0f, 0f);
        velocityVector = new Vector2(0f, 0f);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(img, currentPoint.x, currentPoint.y);
        if (currentPoint.cpy().sub(endPoint).len() > 1)
            currentPoint.add(velocityVector);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        endPoint = touch.cpy();
        velocityVector = endPoint.cpy().sub(currentPoint).nor();
        return super.touchDown(screenX, screenY, pointer, button);
    }

}
