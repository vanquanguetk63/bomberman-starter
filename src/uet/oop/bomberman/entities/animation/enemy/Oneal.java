package uet.oop.bomberman.entities.animation.enemy;

import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.entities.animation.Animated;
import uet.oop.bomberman.graphics.Sprite;

public class Oneal extends Animated {
    public Oneal(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void move() {

    }

    @Override
    public boolean collide(Animated animated) {
        return false;
    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
    }
}
