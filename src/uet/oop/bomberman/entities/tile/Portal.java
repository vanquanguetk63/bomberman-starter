package uet.oop.bomberman.entities.tile;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.Board;

public class Portal extends Tile {
	protected Board board;

	public Portal(int x, int y,Board _board, Sprite sprite) {
		super(x, y, sprite); board=_board;
	}

	@Override
	public boolean collide(Entity e) {
		// TODO: xử lý khi Bomber đi vào
		if(e instanceof Bomber){
			if(e.getXTile() == this.getX() && e.getYTile() == this.getY()) {
				if (board.detectNoEnemies()) {
					board.endGame();
				}

			}
			return true;
		}
		return false;
	}

}
