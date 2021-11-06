package ru.gb.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.gb.base.BaseButton;
import ru.gb.math.Rect;
import ru.gb.pool.BulletPool;
import ru.gb.pool.EnemyPool;

public class ButtonNewGame extends BaseButton {

    private float relativePadding;
    private float relativeProportion;
    private MainShip mainShip;
    private EnemyPool enemyPool;
    private BulletPool bulletPool;

    public ButtonNewGame(TextureAtlas atlas, MainShip mainShip, EnemyPool enemyPool, BulletPool bulletPool) {
        super(atlas.findRegion("button_new_game"));
        this.mainShip = mainShip;
        this.enemyPool = enemyPool;
        this.bulletPool = bulletPool;
        this.relativePadding = 0.1f;
        this.relativeProportion = 0.05f;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(relativeProportion * worldBounds.getHeight());
        setBottom(worldBounds.getBottom() + relativePadding * worldBounds.getHeight());
    }

    @Override
    public void action() {
        mainShip.recovery();
        enemyPool.destroyAll();
        bulletPool.destroyAll();
    }
}
