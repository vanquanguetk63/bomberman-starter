package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.animation.Animated;
import uet.oop.bomberman.entities.animation.Bomber;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.animation.enemy.Baloon;
import uet.oop.bomberman.entities.animation.enemy.Oneal;
import uet.oop.bomberman.entities.stayEntities.Grass;
import uet.oop.bomberman.entities.stayEntities.Portal;
import uet.oop.bomberman.entities.stayEntities.destroyable.Brick;
import uet.oop.bomberman.entities.stayEntities.items.Bomb;
import uet.oop.bomberman.entities.stayEntities.items.Flame;
import uet.oop.bomberman.entities.stayEntities.items.Speed;
import uet.oop.bomberman.graphics.Sprite;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BombermanGame extends Application {

    public static int WIDTH = 20;
    public static int HEIGHT = 15;
    public static char[][] _map;

    private GraphicsContext gc;
    private Canvas canvas;
    private List<Entity> entities = new ArrayList<>();
    private List<Entity> character = new ArrayList<>();

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
            }
        };
        timer.start();

        createMap();

        Entity bomberman = new Bomber(Sprite.SCALED_SIZE, Sprite.SCALED_SIZE, Sprite.player_right);
        entities.add(bomberman);
    }

    public void createMap() {
        //load File level
        try {
            InputStream inputStream = new FileInputStream("res/levels/Level1.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String firstLine = bufferedReader.readLine();
            String[] dataOfScreen = firstLine.split(" ");
            HEIGHT = Integer.parseInt(dataOfScreen[1]);
            WIDTH = Integer.parseInt(dataOfScreen[2]);

            _map = new char[HEIGHT][WIDTH];

            for (int i = 0; i < HEIGHT; i++) {
                String str = bufferedReader.readLine();
                char[] getEachChar = str.toCharArray();
                for (int j = 0; j < getEachChar.length; j++) {
                    _map[i][j] = getEachChar[j];
                }
            }



        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Entity object;
                if (_map[j][i] == '#') {

                } else if (_map[j][i] == '*'){
                    object = new LayeredEnity(i * Sprite.SCALED_SIZE, j  * Sprite.SCALED_SIZE,
                            new Grass(i * Sprite.SCALED_SIZE, j  * Sprite.SCALED_SIZE, Sprite.grass),
                            new Brick(i * Sprite.SCALED_SIZE, j  * Sprite.SCALED_SIZE, Sprite.brick));
                } else if (_map[j][i] == 'x') {
                    object = new LayeredEnity(i * Sprite.SCALED_SIZE, j * Sprite.SCALED_SIZE,
                            new Grass(i * Sprite.SCALED_SIZE, j * Sprite.SCALED_SIZE, Sprite.grass),
                            new Portal(i * Sprite.SCALED_SIZE, j * Sprite.SCALED_SIZE, Sprite.portal),
                            new Brick(i * Sprite.SCALED_SIZE, j * Sprite.SCALED_SIZE, Sprite.brick));
                } else if (_map[j][i] == '1') {
                    object = new LayeredEnity(i * Sprite.SCALED_SIZE, j * Sprite.SCALED_SIZE,
                            new Grass(i * Sprite.SCALED_SIZE, j * Sprite.SCALED_SIZE, Sprite.grass),
                            new Baloon(i * Sprite.SCALED_SIZE, j * Sprite.SCALED_SIZE, Sprite.balloom_left1));
                } else if (_map[j][i] == '2') {
                    object = new LayeredEnity(i * Sprite.SCALED_SIZE, j * Sprite.SCALED_SIZE,
                            new Grass(i * Sprite.SCALED_SIZE, j * Sprite.SCALED_SIZE, Sprite.grass),
                            new Oneal(i * Sprite.SCALED_SIZE, j * Sprite.SCALED_SIZE, Sprite.oneal_left1));
                } else if (_map[j][i] == 'b') {
                    object = new LayeredEnity(i * Sprite.SCALED_SIZE, j * Sprite.SCALED_SIZE,
                            new Grass(i * Sprite.SCALED_SIZE, j * Sprite.SCALED_SIZE, Sprite.grass),
                            new Bomb(i * Sprite.SCALED_SIZE, j * Sprite.SCALED_SIZE, Sprite.bomb));
                } else if (_map[j][i] == 'f') {
                    object = new LayeredEnity(i * Sprite.SCALED_SIZE, j * Sprite.SCALED_SIZE,
                            new Grass(i * Sprite.SCALED_SIZE, j * Sprite.SCALED_SIZE, Sprite.grass),
                            new Flame(i * Sprite.SCALED_SIZE, j * Sprite.SCALED_SIZE, Sprite.powerup_flames));
                } else if (_map[j][i] == 's') {
                    object = new LayeredEnity(i * Sprite.SCALED_SIZE, j * Sprite.SCALED_SIZE,
                            new Grass(i * Sprite.SCALED_SIZE, j * Sprite.SCALED_SIZE, Sprite.grass),
                            new Speed(i * Sprite.SCALED_SIZE, j * Sprite.SCALED_SIZE, Sprite.powerup_speed));
                } else {
                    object = new Grass(i  * Sprite.SCALED_SIZE, j  * Sprite.SCALED_SIZE, Sprite.grass);
                }

//                stillObjects.add(object);
            }
        }

    }

    public void update() {
//        for (Entity entity : stillObjects) {
//            if (entity instanceof LayeredEnity) {
//                entity.update();
//            }
//        }
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        character.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
    }
}
