package uet.oop.bomberman.level;

import javafx.fxml.LoadException;
import uet.oop.bomberman.Board;

/**
 * Load và lưu trữ thông tin bản đồ các màn chơi
 */
public abstract class LevelLoader {

	protected int _width = 20, _height = 20; // default values just for testing
	protected int _level;
	protected Board _board;

	public LevelLoader(Board board, int level) throws LoadException {
		_board = board;
		loadLevel(level);
	}

	public abstract void loadLevel(int level) throws LoadException;

	public abstract void createEntities();

	public int getWidth() {
		return _width;
	}

	public int getHeight() {
		return _height;
	}

	public int getLevel() {
		return _level;
	}

}
