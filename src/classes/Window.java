package classes;

public class Window {
	private String player01 =  "{°}";
	private String casa = " _|";
	private String inimigo = ".V.";
	private String tiro = " * ";
	
	private String[][] tabuleiro = new String[10][10]; 
	
	public void populate() {
		for(int i =0; i< 10; i++) {
			for(int j =0; j<10;j++) {
			tabuleiro[i][j] = casa;
			}
		}
	}
	
	public int criaPlayer(int x, int y) {
		tabuleiro[y][x] = player01;
		return 0;
	}
	public void imprimirTiro(int x, int y) { 
		for (int i=0; i<y; i++) {
			tabuleiro[i][x] = tiro;}
	}
	public int criaEnemy(int x, int y) {
		tabuleiro[y][x] = inimigo;
		return 0;
	}
	public  void imprimeTabuleiro () {
		for(int i=0; i<10;i++) {
			for(int j = 0; j<10; j++) {
				System.out.printf("%s",  this.tabuleiro[i][j]);
			}
		System.out.print("\n");
		}
	}
}
