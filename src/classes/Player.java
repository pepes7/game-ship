package classes;


public class Player {
	private int x, y;
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
	public void goUp() {
		this.y = y - 1;
	}
	public void goDown() {
		this.y = y + 1;
	}
	public void goLeft() {
		this.x = x - 1;
	}
	public void goRight() {
		this.x = x + 1;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
}
