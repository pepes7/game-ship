package classes;

import java.util.Random;

public class Enemy {
	private int x,y;
	private int health;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int coordenadaGerador(int max, int min) {
		int range = max - min + 1;
		int result = (int)(Math.random() * range) + min;
		return result;
	}
	
	 //increments the coordinate by +1 or -1 on the board
	public int movimentoGerador() {
		return new Random().nextInt(2) * 2 - 1;
	}

}
