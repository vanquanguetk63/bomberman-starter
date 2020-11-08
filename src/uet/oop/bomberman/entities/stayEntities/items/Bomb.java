package uet.oop.bomberman.entities.stayEntities.items;

import uet.oop.bomberman.entities.animation.Bomber;
import uet.oop.bomberman.graphics.Sprite;

public class Bomb extends ItemEntities{
    public Bomb(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public void remove() {

    }

    @Override
    public boolean collide(Bomber bomber) {
        return false;
    }
}
