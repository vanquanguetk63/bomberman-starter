package uet.oop.bomberman.entities.tile.item;

import uet.oop.bomberman.Sound;
import uet.oop.bomberman.entities.tile.Tile;
import uet.oop.bomberman.graphics.Sprite;

import java.io.IOException;

public abstract class Item extends Tile {

	public boolean _active=false;
	public Item(int x, int y, Sprite sprite) {
		super(x, y, sprite);
		//_level = level;
	}
	public void sound() {
		try {
			Sound.Item();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
}