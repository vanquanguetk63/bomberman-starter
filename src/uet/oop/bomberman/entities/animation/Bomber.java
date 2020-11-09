package uet.oop.bomberman.entities.animation;

import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.graphics.Sprite;

public class Bomber extends Animated {

    public Bomber(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public void update() {
        x+=10;
    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
    }

    @Override
    public void move() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public boolean collide(Animated animated) {
        return false;
    }
}
