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
	public int coordenadaGerador(int max, int min) { // numero inteiro de max a min
		int range = max - min + 1; 
		int resultado = (int)(Math.random() * range) + min;
		return resultado;
	}
	public int movimentoGerador() { //incrementa a coordenada em +1 ou - 1 no tabuleiro
		Random rand = new Random();
		int incremento = rand.nextInt(2) * 2 - 1;
		return incremento;
	}

}
