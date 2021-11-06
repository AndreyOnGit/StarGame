package ru.gb.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.gb.base.Sprite;
import ru.gb.math.Rect;

public class MessageGameOver extends Sprite {

    private float relativeProportion;

    public MessageGameOver(TextureAtlas atlas) {
        super(atlas.findRegion("message_game_over"));
        this.relativeProportion = 0.1f;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(relativeProportion * worldBounds.getHeight());
    }
}