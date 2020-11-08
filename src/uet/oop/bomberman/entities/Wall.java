package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.stayEntities.Tile;
import uet.oop.bomberman.graphics.Sprite;

public class Wall extends Tile {

    public Wall(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public void update() {

    }
}
