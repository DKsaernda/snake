package net.dksaernda.snake.entities;

import net.dksaernda.snake.Inputhandler;
import net.dksaernda.snake.graphics.Colours;
import net.dksaernda.snake.graphics.Screen;
import net.dksaernda.snake.level.Level;

public class Player extends Mob {
	
	private Inputhandler input;

	public Player(Level level, int x, int y, Inputhandler input) {
		super(level, "Player", x, y, 1);
		this.input = input;
	}

	public boolean hasCollided(int xa, int ya) {
		return false;
	}

	public void tick() {
		int xa = 0;
		int ya = 0;
		
		if (input.up.isPressed()) {ya -= 1;}
		if (input.down.isPressed()) {ya += 1;}
		if (input.left.isPressed()) {xa -= 1;}
		if (input.right.isPressed()) {xa += 1;}
		
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			isMoving = true;
		} else {
			isMoving = false;
		}
		
	}

	public void render(Screen screen) {
		int xtile = 1;
		int ytile = 0;
		
		int modifier = 32 * scale;
		int xOffset = x - modifier/2;
		int yOffset = y - modifier/2 - 4;
		
		screen.render(xOffset + modifier, yOffset, xtile + ytile * 8, Colours.get(303, 313, -1, 323));
	}

}