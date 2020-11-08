package uet.oop.bomberman.entities.stayEntities.items;

import uet.oop.bomberman.entities.animation.Bomber;
import uet.oop.bomberman.entities.stayEntities.Tile;
import uet.oop.bomberman.graphics.Sprite;

public abstract class ItemEntities extends Tile {
    public ItemEntities(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    public abstract boolean collide(Bomber bomber);
    public abstract void remove();
}
