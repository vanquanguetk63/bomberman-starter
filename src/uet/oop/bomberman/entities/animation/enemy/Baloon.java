package uet.oop.bomberman.entities.animation.enemy;

import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.entities.animation.Animated;
import uet.oop.bomberman.graphics.Sprite;

public class Baloon extends Animated {
    public Baloon(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public void destroy() {

    }

    @Override
    public boolean collide(Animated animated) {
        return false;
    }

    @Override
    public void move() {

    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
    }
}
