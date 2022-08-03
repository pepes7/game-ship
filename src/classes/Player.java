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
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public void goUp() {
		setY(getY() - 1);

	}
	public void goDown() {
		setY(getY() +1);
	}
	public void goLeft() {
		setX(getX() - 1);
	}
	public void goRight() {
		setX(getX() + 1);
	}
}
