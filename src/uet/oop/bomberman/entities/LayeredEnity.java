package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.LinkedList;

public class LayeredEnity extends Entity {
    private LinkedList<Entity> layeredEnity = new LinkedList<>();

    public LayeredEnity(int x, int y, Entity ... entities) {

        for (Entity entity : entities) {
            layeredEnity.add(entity);
        }
    }

    public Entity getTopEntity() {
        if (layeredEnity.size() > 1) return layeredEnity.getLast();
        return layeredEnity.getFirst();
    }

    public void removeTopEntity() {
        this.getLayeredEnity().removeLast();
    }

    @Override
    public void render(GraphicsContext gc) {
        getTopEntity().render(gc);
    }

    @Override
    public void update() {
//        if (this.layeredEnity.size() > 1) this.removeTopEntity();

    }

    public LinkedList<Entity> getLayeredEnity() {
        return layeredEnity;
    }

    public void setLayeredEnity(LinkedList<Entity> layeredEnity) {
        this.layeredEnity = layeredEnity;
    }
}
