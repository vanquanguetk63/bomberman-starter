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
    public int frameCnt = 0;
    public long lasttimeFPS = 0;
    final double ns = 1000000000.0 / 60.0;

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
                frameCnt++;

                // check if a second has passed
                long currenttimeNano = System.nanoTime();
                if (currenttimeNano > lasttimeFPS + 1000000000) {
                    render();
                    update();
                    frameCnt = 0;
                    lasttimeFPS = currenttimeNano;
                }

            }
        };
        timer.start();

        createMap();

        Entity bomberman = new Bomber(Sprite.SCALED_SIZE, Sprite.SCALED_SIZE, Sprite.player_right);
        character.add(bomberman);
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
                int x = i * Sprite.SCALED_SIZE;
                int y = j * Sprite.SCALED_SIZE;
                if (_map[j][i] == '#') {
                    entities.add(new LayeredEnity(x, y,
                            new Grass(x, y, Sprite.grass),
                            new Wall(x, y, Sprite.wall)));
                } else if (_map[j][i] == '*'){
                    entities.add(new LayeredEnity(x, y,
                            new Grass(x, y, Sprite.grass),
                            new Brick(x, y, Sprite.brick)));
                } else if (_map[j][i] == 'x') {
                    entities.add(new LayeredEnity(x, y,
                            new Grass(x, y, Sprite.grass),
                            new Portal(x, y, Sprite.portal),
                            new Wall(x, y, Sprite.wall)));
                } else if (_map[j][i] == '1') {
                    entities.add(new Grass(x, y, Sprite.grass));
                    character.add(new Baloon(x, y, Sprite.balloom_left1));
                } else if (_map[j][i] == '2') {
                    entities.add(new Grass(x, y, Sprite.grass));
                    character.add(new Oneal(x, y, Sprite.oneal_left1));
                } else if (_map[j][i] == 'b') {
                    entities.add(new LayeredEnity(x, y,
                                new Grass(x, y, Sprite.grass),
                                new Bomb(x, y, Sprite.bomb),
                                new Brick(x, y, Sprite.brick)
                    ));
                } else if (_map[j][i] == 'f') {
                    entities.add(new LayeredEnity(x, y,
                            new Grass(x, y, Sprite.grass),
                            new Flame(x, y, Sprite.powerup_flames),
                            new Brick(x, y, Sprite.brick)
                    ));
                } else if (_map[j][i] == 's') {
                    entities.add(new LayeredEnity(x, y,
                            new Grass(x, y, Sprite.grass),
                            new Speed(x, y, Sprite.powerup_speed),
                            new Brick(x, y, Sprite.brick)
                    ));
                } else {
                    entities.add(new Grass(i  * Sprite.SCALED_SIZE, j  * Sprite.SCALED_SIZE, Sprite.grass));
                }

            }
        }
    }

    public void update() {
        for (Entity entity : character) {
            if (entity instanceof Bomber) {
                entity.update();
            }
        }
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        entities.forEach(g -> g.render(gc));
        character.forEach(g -> g.render(gc));
    }
}
